/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.rest.facade;

import com.webcohesion.enunciate.metadata.rs.ResponseCode;
import com.webcohesion.enunciate.metadata.rs.StatusCodes;
import com.webcohesion.enunciate.metadata.rs.TypeHint;
import java.io.IOException;
import java.math.BigInteger;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import se.stolpjakten.api.db.facade.TokensFacadeDB;
import se.stolpjakten.api.db.type.Tokens;
import se.stolpjakten.api.rest.type.Token;
import se.stolpjakten.api.security.aspects.BasicSecured;
import se.stolpjakten.api.security.aspects.TokenSecured;
import se.stolpjakten.api.exceptions.AuthorizationException;
import se.stolpjakten.api.exceptions.NotFoundException;
import se.stolpjakten.api.rest.error.Forbidden;
import se.stolpjakten.api.rest.error.InternalServerError;
import se.stolpjakten.api.rest.error.NotFound;
import se.stolpjakten.api.rest.error.Unauthorized;
import se.stolpjakten.api.rest.type.Role;
import se.stolpjakten.api.security.aspects.Authorization;
import se.stolpjakten.api.utils.AuthorizationHelper;
import se.stolpjakten.api.utils.EntityManagerHolder;

/**
 *
 * @author gengdahl
 */
@Stateless
@Path("/users/{userName}/tokens")
public class TokenFacadeREST {
    private TokensFacadeDB db = null;
    private TokensFacadeDB getDb() {
        if (db == null) {
            db = new TokensFacadeDB();
        }
        return db;
    }


    /**
     * Create a token to use for subsequent requests to this API.
     * <br>
     * If you do not have a user yet, please create one using the Users REST
     * facade (POST).
     * <br>
     * The retrieved token SHOULD be stored by API client implementations.
     * <br>
     * Client implementations <b>MUST NOT</b> store the user username and
     * password.
     * <br>
     * An API client can retrieve as many tokens as it likes, but server might
     * discard old tokens to manage memory resources.
     * <br>
     * <br>
     * A SYS_ADMIN can impersonate a USER in order to troubleshoot specific user issues. 
     * 
     * @RequestHeader Authorization Basic Authentication (RFC 7617)
     *
     * @param userName The username of the user to create the token for.
     * @return Created token.
     */
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @BasicSecured
    @Authorization({Role.USER, Role.SYS_ADMIN})
    @StatusCodes({
        @ResponseCode(code = 200, condition = "OK")
        ,@ResponseCode(code = 403, type = @TypeHint(Forbidden.class), condition = Forbidden.DEFAULT_DESCRIPTION)
        ,@ResponseCode(code = 500, type = @TypeHint(InternalServerError.class), condition = InternalServerError.DEFAULT_DESCRIPTION)})
    public Token createToken(@PathParam("userName") String userName, Token token) throws IOException {
        //Below check will make impersionation possible.
        //Potentially this could be useful for troubleshooting a user issue.
        if (!AuthorizationHelper.isInRole(Role.SYS_ADMIN)) {
            AuthorizationHelper.assertRequestingUser(userName);
        }
        Tokens dbToken = new Tokens();

        dbToken.setExpires(BigInteger.valueOf(System.currentTimeMillis()
                + token.getExpire() * 1000));
        dbToken.setScopes("user");
        dbToken.setUserName(userName);
        dbToken.setToken(UUID.randomUUID().toString());
        getDb().create(dbToken);

        return Token.fromTokens(dbToken);
    }

    /**
     * Delete a previously created token.
     * <br>
     * If user or token does not exist, operation will return OK
     * result (if authentication & authorization passed)..
     *
     * @param userName The user id (username) of the current user.
     * @param tokenId The access token to delete, eg
     * 8758f65a-c27b-4f86-a43d-3ce1add36ec6
     *
     * @RequestHeader Authorization Bearer token (RFC 6750).
     */
    @StatusCodes({
        @ResponseCode(code = 204, condition = "OK")
        ,@ResponseCode(code = 401, type = @TypeHint(Unauthorized.class), condition = Unauthorized.DEFAULT_DESCRIPTION)
        ,@ResponseCode(code = 403, type = @TypeHint(Forbidden.class), condition = Forbidden.DEFAULT_DESCRIPTION)
        ,@ResponseCode(code = 500, type = @TypeHint(InternalServerError.class), condition = InternalServerError.DEFAULT_DESCRIPTION)})
    @DELETE
    @Path("{token-id}")
    @TokenSecured
    @Authorization({Role.USER, Role.SYS_ADMIN})
    public void deleteToken(@PathParam("userName") String userName,
            @PathParam("token-id") String tokenId,
            @Context ContainerRequestContext context) throws IOException, NotFoundException {
        if (!AuthorizationHelper.isInRole(Role.SYS_ADMIN)) {
            AuthorizationHelper.assertRequestingUser(userName);
        }
        //TODO optimize to do delete instead of select + delete
        Tokens token = getDb().find(tokenId);
        if (token != null) {
            getDb().remove(token);
        }

    }

    /**
     * Delete all tokens for this user.
     * If user does not exist or user have no tokens, operation will return OK
     * result (if authentication & authorization passed)..
     *
     * @param userName The user userName (username) of the current user.
     *
     *
     * @RequestHeader Authorization Bearer token (RFC 6750).
     */
    @StatusCodes({
        @ResponseCode(code = 204, condition = "OK")
        ,@ResponseCode(code = 401, type = @TypeHint(Unauthorized.class), condition = Unauthorized.DEFAULT_DESCRIPTION)
        ,@ResponseCode(code = 403, type = @TypeHint(Forbidden.class), condition = Forbidden.DEFAULT_DESCRIPTION)
        ,@ResponseCode(code = 500, type = @TypeHint(InternalServerError.class), condition = InternalServerError.DEFAULT_DESCRIPTION)})
    @DELETE
    @TokenSecured
    @Authorization({Role.USER, Role.SYS_ADMIN})
    public void deleteTokens(@PathParam("userName") String userName,
            @Context ContainerRequestContext context) throws IOException {
        if (!AuthorizationHelper.isInRole(Role.SYS_ADMIN)) {
            AuthorizationHelper.assertRequestingUser(userName);
        }
        getDb().deleteByUserName(userName);

    }

}
