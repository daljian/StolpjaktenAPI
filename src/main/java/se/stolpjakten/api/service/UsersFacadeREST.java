/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.service;

import se.stolpjakten.api.db.Humans;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import se.stolpjakten.api.security.BasicSecured;
import se.stolpjakten.api.security.TokenSecured;

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
    public void edit(@PathParam("id") String id, Humans entity) {
        if (!id.equals(entity.getUserName())) {
            throw new IllegalArgumentException("Path id and entity id doesn't match!");
        }
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @TokenSecured()
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Humans find(@PathParam("id") String id,
            @Context ContainerRequestContext context) {
        if (id.equals(context.getSecurityContext().getUserPrincipal().getName())) {
            System.out.println("We are good");
        } else {
            throw new RuntimeException("Forbidden");
        }
        
        Humans humans = super.find(id);
        if (humans != null) {
            humans = humans.toRest();
        }
        return humans;
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Humans> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Humans> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
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
