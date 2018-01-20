/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.utils;

import javax.persistence.EntityManager;

/**
 *
 * @author gengdahl
 */
public enum EntityManagerHolder {
    INSTANCE;
    ThreadLocal <EntityManager> em = new ThreadLocal<>();
    public EntityManager get() {
        return em.get();
    }
    public void set(EntityManager em) {
        this.em.set(em);
    }
            
    
}
