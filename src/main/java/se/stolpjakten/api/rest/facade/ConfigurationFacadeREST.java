/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.rest.facade;

import java.io.IOException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import se.stolpjakten.api.exceptions.NotFoundException;
import se.stolpjakten.api.rest.type.Configuration;
import se.stolpjakten.api.rest.type.Role;
import se.stolpjakten.api.security.aspects.Authorization;
import se.stolpjakten.api.security.aspects.TokenSecured;
import se.stolpjakten.api.utils.ConfigurationStore;
import se.stolpjakten.api.utils.EntityManagerHolder;

/**
 *
 * Configuration endpoint for global configuration setting.
 * <br>
 * This REST endpoint contains global configuration settings that is readable
 * by anyone and writable by system administrators.
 * 
 */
@Stateless
@Path("/configurations")
public class ConfigurationFacadeREST {
    private static final String NOT_FOUND_MSG =
            "No such configuration value.";

    @PersistenceContext(unitName = "se.stolpjakten.api_stolpjaktenAPI_war_1.0-SNAPSHOTPU")
    private EntityManager em;
/**
 * Get 
 * @param key
 * @return
 * @throws IOException 
 */
    @GET
    @Path("{key}")
    @Produces({MediaType.APPLICATION_JSON})
    public String find(@PathParam("key") String key) throws NotFoundException {
        try {
            return ConfigurationStore.valueOf(key).get();
        } catch (IllegalArgumentException exception) {
            throw new NotFoundException(NOT_FOUND_MSG);
        }
    }

    @PUT
    @Path("{key}")
    @Produces({MediaType.APPLICATION_JSON})
    @TokenSecured
    @Authorization(Role.SYS_ADMIN)
    public void update(@PathParam("key") String key,
            String value) throws IOException {
        ConfigurationStore.valueOf(key).set(value);

    }

    /**
     *
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Configuration> findAll() {
        return ConfigurationStore.toConfigurations();
    }
}
