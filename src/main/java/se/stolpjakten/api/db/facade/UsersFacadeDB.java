/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.db.facade;

import javax.persistence.EntityManager;
import se.stolpjakten.api.db.type.Users;
import se.stolpjakten.api.utils.EntityManagerHolder;

/**
 *
 * @author gengdahl
 */
public class UsersFacadeDB extends AbstractFacade<Users> {
    private EntityManager em;

    public UsersFacadeDB() {
        super(Users.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return EntityManagerHolder.INSTANCE.get();
    }
    
}
