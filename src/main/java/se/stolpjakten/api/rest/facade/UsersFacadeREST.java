/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.rest.facade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
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
import se.stolpjakten.api.db.facade.UsersFacadeDB;
import se.stolpjakten.api.db.type.Users;
import se.stolpjakten.api.rest.error.ErrorCode;
import se.stolpjakten.api.rest.type.Role;
import se.stolpjakten.api.rest.type.User;
import se.stolpjakten.api.security.Authorization;
import se.stolpjakten.api.security.BasicSecured;
import se.stolpjakten.api.security.TokenSecured;
import se.stolpjakten.api.security.exceptions.AuthorizationException;
import se.stolpjakten.api.security.exceptions.UserException;
import se.stolpjakten.api.utils.Strings;

/**
 *
 * @author gengdahl
 */
@Stateless
@Path("/users")
public class UsersFacadeREST {
    @PersistenceContext(unitName = "se.stolpjakten.api_stolpjaktenAPI_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    private UsersFacadeDB dbFacade = null;
    private UsersFacadeDB getDb(){
        if (dbFacade == null) {
            dbFacade = new UsersFacadeDB(em);
        }
        return dbFacade;
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @TokenSecured
    @Authorization({Role.USER})
    public void edit(@PathParam("id") String id, User user) throws IOException {
        Users entity = (Users) user;
        entity.setSalt((int) System.currentTimeMillis() % 10000);
        if (!id.equals(entity.getUserName())) {
            throw new AuthorizationException();
            //TODO Refactor to have these type of validations inside REST data type objects.
        } else if(!Strings.isValidPasswordString(entity.getPassword())) {
            //TODO also have similar checks for username.
            throw new UserException(ErrorCode.JSON_FIELD_PASSWORD, "Please provide a valid password");
        }
        
        
        
        dbFacade.edit(entity);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Users user) throws IOException {
        getDb();
        Users entity = (Users) user;
        entity.setSalt((int) System.currentTimeMillis() % 10000);

        if (dbFacade.find(entity.getUserName()) != null) {
            throw new UserException(ErrorCode.RESOURCE_EXISTS, "User "
                    + entity.getUserName() + " already exists.");
        }
        dbFacade.create(entity);
    }

    @DELETE
    @Path("{id}")
    @BasicSecured
    @Authorization({Role.USER})
    public void remove(@PathParam("id") String id) {
        dbFacade.remove(dbFacade.find(id));
    }

    @GET
    @TokenSecured()
    @Authorization({Role.USER})
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public User find(@PathParam("id") String id,
            @Context ContainerRequestContext context) throws IOException {
        if (id.equals(context.getSecurityContext().getUserPrincipal().getName())) {
            System.out.println("We are good");
        } else {
            throw new AuthorizationException();
        }

        Users user = dbFacade.find(id);
        if (user != null) {
            return user.toUser();
        } else {
            throw new NotFoundException();
        }
    }
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<User> findAll(@Context ContainerRequestContext context) {
        List<Users> dbUsers =  dbFacade.findAll();
        List<User> users = new ArrayList<>(dbUsers.size());
        for (Users dbUser : dbUsers) {
            users.add(dbUser.toUser());
        }
        return users;
    }
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<User> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        List<Users> dbUsers =  dbFacade.findRange(new int[]{from, to});
        List<User> users = new ArrayList<>(dbUsers.size());
        for (Users dbUser : dbUsers) {
            users.add(dbUser.toUser());
        }
        return users;
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    @Asynchronous
    public void countREST(@Suspended
    final AsyncResponse asyncResponse) {
        asyncResponse.resume(doCountREST());
    }

    private String doCountREST() {
        return String.valueOf(dbFacade.count());
    }
}

