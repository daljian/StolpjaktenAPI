/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.db.facade;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.stolpjakten.api.db.type.Users;

/**
 *
 * @author gengdahl
 */
public class UsersFacadeDB extends AbstractFacade<Users> {
    private EntityManager em;

    public UsersFacadeDB(EntityManager em) {
        super(Users.class);
        this.em = em;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
