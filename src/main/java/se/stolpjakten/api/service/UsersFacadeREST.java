/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.service;

import java.io.IOException;
import java.util.ArrayList;
import se.stolpjakten.api.db.Humans;
import java.util.List;
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
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import se.stolpjakten.api.rest.Role;
import se.stolpjakten.api.rest.errors.ErrorCode;
import se.stolpjakten.api.security.Authorization;
import se.stolpjakten.api.security.BasicSecured;
import se.stolpjakten.api.security.TokenSecured;
import se.stolpjakten.api.security.exceptions.AuthorizationException;
import se.stolpjakten.api.security.exceptions.UserException;
import se.stolpjakten.api.rest.User;
import se.stolpjakten.api.utils.Strings;

/**
 *
 * @author gengdahl
 */
@Stateless
@Path("/users")
public class UsersFacadeREST extends AbstractFacade<Humans> {

    @PersistenceContext(unitName = "se.stolpjakten.api_stolpjaktenAPI_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public UsersFacadeREST() {
        super(Humans.class);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @TokenSecured
    @Authorization({Role.USER})
    public void edit(@PathParam("id") String id, User human) throws IOException {
        Humans entity = (Humans) human;
        entity.setSalt((int) System.currentTimeMillis() % 10000);
        if (!id.equals(entity.getUserName())) {
            throw new AuthorizationException();
            //TODO Refactor to have these type of validations inside REST data type objects.
        } else if(!Strings.isValidPasswordString(entity.getPassword())) {
            //TODO also have similar checks for username.
            throw new UserException(ErrorCode.JSON_FIELD_PASSWORD, "Please provide a valid password");
        }
        
        
        
        super.edit(entity);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Humans human) throws IOException {
        Humans entity = (Humans) human;
        entity.setSalt((int) System.currentTimeMillis() % 10000);

        if (super.find(entity.getUserName()) != null) {
            throw new UserException(ErrorCode.RESOURCE_EXISTS, "User "
                    + entity.getUserName() + " already exists.");
        }
        super.create(entity);
    }

    @DELETE
    @Path("{id}")
    @BasicSecured
    @Authorization({Role.USER})
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
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

        Humans humans = super.find(id);
        if (humans != null) {
            return humans.toUser();
        } else {
            throw new NotFoundException();
        }
    }
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<User> findAll(@Context ContainerRequestContext context) {
        List<Humans> humans =  super.findAll();
        List<User> users = new ArrayList<>(humans.size());
        for (Humans human : humans) {
            users.add(human.toUser());
        }
        return users;
    }
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<User> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        List<Humans> humans =  super.findRange(new int[]{from, to});
        List<User> users = new ArrayList<>(humans.size());
        for (Humans human : humans) {
            users.add(human.toUser());
        }
        return users;
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
