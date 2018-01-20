/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.db.facade;

import javax.persistence.EntityManager;
import se.stolpjakten.api.db.type.Configuration;
import se.stolpjakten.api.utils.EntityManagerHolder;

/**
 *
 * @author gengdahl
 */
public class ConfigurationFacadeDB extends AbstractFacade<Configuration> {
    private EntityManager em;
    public ConfigurationFacadeDB() {
        super(Configuration.class);
        this.em = EntityManagerHolder.INSTANCE.get();
    }


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
