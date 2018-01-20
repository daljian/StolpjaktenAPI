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
import se.stolpjakten.api.rest.type.Configuration;
import se.stolpjakten.api.utils.ConfigurationStore;
import se.stolpjakten.api.utils.EntityManagerHolder;

/**
 *
 * @author gengdahl
 */
@Stateless
@Path("/configurations")
public class ConfigurationFacadeREST {

    @PersistenceContext(unitName = "se.stolpjakten.api_stolpjaktenAPI_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    @GET
    @Path("{key}")
    @Produces({MediaType.APPLICATION_JSON})
    public Configuration find(@PathParam("key") String key) throws IOException {
        return ConfigurationStore.valueOf(key).toConfiguration();
    }

    @PUT
    @Path("{key}")
    @Produces({MediaType.APPLICATION_JSON})
    public void update(@PathParam("key") String key,
            Configuration configuration) throws IOException {
        ConfigurationStore.valueOf(key).set(configuration.value);
        
    }
    /**
     *
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Configuration> findAll() {
        //TODO implement
        return null;
    }
}
