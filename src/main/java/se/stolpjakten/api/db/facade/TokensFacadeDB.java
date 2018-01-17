/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.db.facade;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import se.stolpjakten.api.db.type.RoleMappings;
import se.stolpjakten.api.db.type.Tokens;

/**
 *
 * @author gengdahl
 */
public class TokensFacadeDB extends AbstractFacade<Tokens>{
    private EntityManager em;
    private TypedQuery deleteByUserName;

    public TokensFacadeDB(EntityManager em) {
        super(Tokens.class);
        this.em = em;
        deleteByUserName = em.createNamedQuery("Tokens.deleteByUserName", Tokens.class);
    }
    
    public void deleteByUserName(String userName) {
        deleteByUserName.setParameter("userName", userName).executeUpdate();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }    
    
}
