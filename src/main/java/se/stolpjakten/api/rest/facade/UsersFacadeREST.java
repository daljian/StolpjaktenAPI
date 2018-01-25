/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.rest.facade;

import com.webcohesion.enunciate.metadata.rs.RequestHeader;
import com.webcohesion.enunciate.metadata.rs.RequestHeaders;
import com.webcohesion.enunciate.metadata.rs.ResponseCode;
import com.webcohesion.enunciate.metadata.rs.StatusCodes;
import com.webcohesion.enunciate.metadata.rs.TypeHint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import se.stolpjakten.api.db.facade.TokensFacadeDB;
import se.stolpjakten.api.db.facade.UsersFacadeDB;
import se.stolpjakten.api.db.type.Users;
import se.stolpjakten.api.rest.error.ErrorCode;
import se.stolpjakten.api.rest.type.Role;
import se.stolpjakten.api.rest.type.User;
import se.stolpjakten.api.security.aspects.Authorization;
import se.stolpjakten.api.security.aspects.BasicSecured;
import se.stolpjakten.api.security.aspects.TokenSecured;
import se.stolpjakten.api.exceptions.AuthorizationException;
import se.stolpjakten.api.exceptions.NotFoundException;
import se.stolpjakten.api.exceptions.UserException;
import se.stolpjakten.api.rest.error.BadRequest;
import se.stolpjakten.api.rest.error.Forbidden;
import se.stolpjakten.api.rest.error.InternalServerError;
import se.stolpjakten.api.rest.error.NotFound;
import se.stolpjakten.api.rest.error.Unauthorized;
import se.stolpjakten.api.security.PasswordAuthentication;
import se.stolpjakten.api.utils.AuthorizationHelper;
import se.stolpjakten.api.utils.Strings;

/**
 *
 * CRUD operations for Users.
 * <br>
 * You need to create a user before using the protected REST APIs.
 */
@Stateless
@Path("/users")
public class UsersFacadeREST {

    private PasswordAuthentication passwordAuthentication = null;
    private UsersFacadeDB dbFacade = null;

    private UsersFacadeDB getDb() {
        if (dbFacade == null) {
            dbFacade = new UsersFacadeDB();
        }
        return dbFacade;
    }

    /**
     * Update the user.
     * <br>
     *
     * @param userName Username User to update.
     * @param user New User configuration, note that you cannot change the
     * userName.
     *
     * @RequestHeader Authorization Bearer token (RFC 6750).
     */
    @StatusCodes({
        @ResponseCode(code = 204, condition = "OK")
        ,@ResponseCode(code = 400, type = @TypeHint(BadRequest.class), condition = BadRequest.DEFAULT_DESCRIPTION)
        ,@ResponseCode(code = 401, type = @TypeHint(Unauthorized.class), condition = Unauthorized.DEFAULT_DESCRIPTION)
        ,@ResponseCode(code = 403, type = @TypeHint(Forbidden.class), condition = Forbidden.DEFAULT_DESCRIPTION)
        ,@ResponseCode(code = 404, type = @TypeHint(NotFound.class), condition = NotFound.DEFAULT_DESCRIPTION)
        ,@ResponseCode(code = 500, type = @TypeHint(InternalServerError.class), condition = InternalServerError.DEFAULT_DESCRIPTION)})
    @PUT
    @Path("{userName}")
    @Consumes({MediaType.APPLICATION_JSON})
    @TokenSecured
    @Authorization({Role.USER, Role.SYS_ADMIN})
    public void edit(@PathParam("userName") String userName, User user)
            throws UserException, AuthorizationException {
        Users entity = (Users) user;
        if (!AuthorizationHelper.isInRole(Role.SYS_ADMIN)) {
            AuthorizationHelper.assertRequestingUser(userName);
        }
        if (Strings.isNullOrEmpty(user.getUserName())) {
            entity.setUserName(userName);
        } else if (!userName.equals(entity.getUserName())) {
            throw new AuthorizationException();
            //TODO Refactor to have these type of validations inside REST data type objects.
        } else if (!Strings.isValidPasswordString(entity.getPassword())) {
            //TODO also have similar checks for username.
            throw new UserException(ErrorCode.JSON_FIELD_PASSWORD, "Please provide a valid password");
        }

        getDb().edit(entity);
    }

    /**
     * Create a new User.
     * <br>
     * After creating a user you should proceed to get a token using the Token
     * REST service. After you have retrieved a token you can use that to access
     * the other APIs to explore arrangements, maps, courses and start register
     * poles.
     * <br>
     *
     * @ResponseHeader Location URL to created user
     * @param user The user to create.
     */
    @StatusCodes({
        @ResponseCode(code = 200, type = @TypeHint(User.class), condition = "OK")
        ,@ResponseCode(code = 400, type = @TypeHint(BadRequest.class), condition = BadRequest.DEFAULT_DESCRIPTION)
        ,@ResponseCode(code = 500, type = @TypeHint(InternalServerError.class), condition = InternalServerError.DEFAULT_DESCRIPTION)})
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public void create(Users user) throws UserException, IOException {
        //TODO implement location header in response
        Users entity = (Users) user;
        validateUserFields(user);
        if (getDb().find(entity.getUserName()) != null) {
            throw new UserException(ErrorCode.RESOURCE_EXISTS, "User "
                    + entity.getUserName() + " already exists.");
        }
        PasswordAuthentication helper = getPasswordAuthentication();
        String password = helper.hash(user.getPassword().toCharArray());
        entity.setPassword(password);
        getDb().create(entity);
    }

    /**
     * Delete a user account.
     * <br>
     * Please note that this will delete the user account and all data
     * associated to it. Anonymous statistics data will remain.
     * <br>
     * <b>SYS_ADMIN</b> Role can delete any user account.
     * <br>
     * <b>USER</b> Role can delete only one user account (his).
     *
     * @RequestHeader Authorization Bearer token.
     */
    @DELETE
    @Path("{userName}")
    @TokenSecured
    @Authorization({Role.USER, Role.SYS_ADMIN})
    @StatusCodes({
        @ResponseCode(code = 204, condition = "OK")
        ,@ResponseCode(code = 401, type = @TypeHint(Unauthorized.class), condition = Unauthorized.DEFAULT_DESCRIPTION)
        ,@ResponseCode(code = 403, type = @TypeHint(Forbidden.class), condition = Forbidden.DEFAULT_DESCRIPTION)
        ,@ResponseCode(code = 404, type = @TypeHint(NotFound.class), condition = NotFound.DEFAULT_DESCRIPTION)
        ,@ResponseCode(code = 500, type = @TypeHint(InternalServerError.class), condition = InternalServerError.DEFAULT_DESCRIPTION)})
    public void remove(@PathParam("userName") String userName) throws AuthorizationException, NotFoundException {
        if (!AuthorizationHelper.isInRole(Role.SYS_ADMIN)) {
            AuthorizationHelper.assertRequestingUser(userName);
        }
        TokensFacadeDB tokensDB = new TokensFacadeDB();
        tokensDB.deleteByUserName(userName);
        Users user = getDb().find(userName);
        if (user == null) {
            throw new NotFoundException();
        }
        getDb().remove(user);
    }

    /**
     * Retrieve a User.
     * <br>
     * <b>SYS_ADMIN</b> Role can retrieve any user.
     * <br>
     * <b>USER</b> Role can retrieve only one user (himself).
     *
     * @RequestHeader Authorization Bearer token.
     */
    @StatusCodes({
        @ResponseCode(code = 200, type = @TypeHint(User.class), condition = "OK")
        ,@ResponseCode(code = 400, type = @TypeHint(BadRequest.class), condition = BadRequest.DEFAULT_DESCRIPTION)
        ,@ResponseCode(code = 401, type = @TypeHint(Unauthorized.class), condition = Unauthorized.DEFAULT_DESCRIPTION)
        ,@ResponseCode(code = 403, type = @TypeHint(Forbidden.class), condition = Forbidden.DEFAULT_DESCRIPTION)
        ,@ResponseCode(code = 404, type = @TypeHint(NotFound.class), condition = NotFound.DEFAULT_DESCRIPTION)
        ,@ResponseCode(code = 500, type = @TypeHint(InternalServerError.class), condition = InternalServerError.DEFAULT_DESCRIPTION)})
    @GET
    @TokenSecured()
    @Authorization({Role.USER, Role.SYS_ADMIN})
    @Path("{userName}")
    @Produces({MediaType.APPLICATION_JSON})
    public User find(@PathParam("userName") String userName)
            throws NotFoundException, AuthorizationException {
        if (!AuthorizationHelper.isInRole(Role.SYS_ADMIN)) {
            AuthorizationHelper.assertRequestingUser(userName);
        }

        Users user = getDb().find(userName);
        if (user != null) {
            return user.toUser();
        } else {
            throw new NotFoundException();
        }
    }

    /**
     * Get a list of users.
     * <br>
     * <b>SYS_ADMIN</b> Role can retrieve all user data.
     * <br>
     * <b>USER</b> Role can retrieve all user data for himself, and partial data
     * for other users.
     *
     * @RequestHeader Authorization Bearer token.
     */
    @StatusCodes({
        @ResponseCode(code = 200, type = @TypeHint(User.class), condition = "OK")
        ,@ResponseCode(code = 400, type = @TypeHint(BadRequest.class), condition = BadRequest.DEFAULT_DESCRIPTION)
        ,@ResponseCode(code = 401, type = @TypeHint(Unauthorized.class), condition = Unauthorized.DEFAULT_DESCRIPTION)
        ,@ResponseCode(code = 403, type = @TypeHint(Forbidden.class), condition = Forbidden.DEFAULT_DESCRIPTION)
        ,@ResponseCode(code = 404, type = @TypeHint(NotFound.class), condition = NotFound.DEFAULT_DESCRIPTION)
        ,@ResponseCode(code = 500, type = @TypeHint(InternalServerError.class), condition = InternalServerError.DEFAULT_DESCRIPTION)})
    @GET
    @TokenSecured()
    @Authorization({Role.USER, Role.SYS_ADMIN})
    @Produces({MediaType.APPLICATION_JSON})
    public List<User> findAll(@Context ContainerRequestContext context) {
        //TODO, implement this method properly.
        //It needs result reduction
        //parameter filtering
        //sorting
        //paging
        List<Users> dbUsers = getDb().findAll();
        List<User> users = new ArrayList<>(dbUsers.size());
        for (Users dbUser : dbUsers) {
            users.add(dbUser.toUser());
        }
        return users;
    }

    /**
     *
     * @param from
     * @param to
     * @return
     * @RequestHeader Authorization Bearer token.
     */
    @StatusCodes({
        @ResponseCode(code = 200, type = @TypeHint(User.class), condition = "OK")
        ,@ResponseCode(code = 400, type = @TypeHint(BadRequest.class), condition = BadRequest.DEFAULT_DESCRIPTION)
        ,@ResponseCode(code = 401, type = @TypeHint(Unauthorized.class), condition = Unauthorized.DEFAULT_DESCRIPTION)
        ,@ResponseCode(code = 403, type = @TypeHint(Forbidden.class), condition = Forbidden.DEFAULT_DESCRIPTION)
        ,@ResponseCode(code = 404, type = @TypeHint(NotFound.class), condition = NotFound.DEFAULT_DESCRIPTION)
        ,@ResponseCode(code = 500, type = @TypeHint(InternalServerError.class), condition = InternalServerError.DEFAULT_DESCRIPTION)})
    @GET
    @TokenSecured()
    @Authorization({Role.USER, Role.SYS_ADMIN})
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<User> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        List<Users> dbUsers = getDb().findRange(new int[]{from, to});
        List<User> users = new ArrayList<>(dbUsers.size());
        for (Users dbUser : dbUsers) {
            users.add(dbUser.toUser());
        }
        return users;
    }

    /**
     *
     * @param asyncResponse
     * @RequestHeader Authorization Bearer token.
     */
    @GET
    @TokenSecured()
    @Authorization({Role.USER, Role.SYS_ADMIN})
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    @Asynchronous
    public void countREST(@Suspended
            final AsyncResponse asyncResponse) {
        asyncResponse.resume(doCountREST());
    }

    private String doCountREST() {
        return String.valueOf(getDb().count());
    }

    private PasswordAuthentication getPasswordAuthentication() {
        if (passwordAuthentication == null) {
            passwordAuthentication = new PasswordAuthentication();
        }
        return passwordAuthentication;
    }

    private void validateUserFields(User user) throws UserException {
        if (!Strings.isValidUsername(user.getUserName())) {
            throw new UserException(ErrorCode.JSON_FIELD_USERNAME,
                    "Please provide a valid username");
        } else if (!Strings.isValidEmail(user.getEmail())) {
            throw new UserException(ErrorCode.JSON_FIELD_EMAIL,
                    "Please provide a valid email address");
        } else if (!Strings.isValidPasswordString(user.getPassword())) {
            throw new UserException(ErrorCode.JSON_FIELD_PASSWORD,
                    "Please provide a valid password");
        }

    }
}
