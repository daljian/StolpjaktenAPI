/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.rest.facade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import se.stolpjakten.api.db.facade.RoleMappingsFacadeDB;
import se.stolpjakten.api.db.type.RoleMappings;
import se.stolpjakten.api.db.type.RoleMappingsPK;
import se.stolpjakten.api.rest.type.Role;
import se.stolpjakten.api.rest.type.RoleMapping;
import se.stolpjakten.api.security.aspects.Authorization;
import se.stolpjakten.api.security.aspects.TokenSecured;
import se.stolpjakten.api.utils.AuthorizationHelper;

/**
 *
 * @author gengdahl
 */
@Stateless
@Path("/users/{userId}/roles")
public class RoleMappingsFacadeREST {
    RoleMappingsFacadeDB db = null;
    private RoleMappingsFacadeDB getDb() {
        if (db == null) {
            db = new RoleMappingsFacadeDB();
        }
        return db;
    }
    @GET
    @TokenSecured
    @Authorization({Role.SYS_ADMIN, Role.USER})
    @Produces({MediaType.APPLICATION_JSON})
    public List<String> findAll(@PathParam("userId") String id) {
        List<RoleMappings> dbTypes = getDb().findByUserName(id);
        List<String> roles = new ArrayList<>(dbTypes.size());
        for (RoleMappings dbType : dbTypes) {
            roles.add(dbType.getRoleMappingsPK().getRole());
            
        }
        return roles;
    }
    @PUT
    @Path("{role}")
    @TokenSecured
    @Authorization({Role.SYS_ADMIN})
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(@PathParam("userId") String id)
    throws IOException {
        RoleMappings roleMappings = new RoleMappings(id, id);
        getDb().edit(roleMappings);
    }
    @GET
    @Path("{role}")
    @TokenSecured
    @Authorization({Role.SYS_ADMIN, Role.USER})
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public String find(@PathParam("userId") String id,
            @PathParam("role") String role)
    throws IOException {
        if (!AuthorizationHelper.isInRole(Role.SYS_ADMIN)) {
            AuthorizationHelper.assertRequestingUser(id);
        }
        final RoleMappings roleMappings = new RoleMappings(id, role);
        RoleMappingsPK key = new RoleMappingsPK(id, role);
        RoleMappings dbType = getDb().find(key);
        if (dbType != null) {
            return dbType.getRoleMappingsPK().getRole();
        } else {
            return null;
        }
    }
    
}
