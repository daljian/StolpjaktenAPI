/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.db.facade;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import se.stolpjakten.api.db.type.RoleMappings;
import se.stolpjakten.api.db.type.Tokens;
import se.stolpjakten.api.utils.EntityManagerHolder;

/**
 *
 * @author gengdahl
 */
public class TokensFacadeDB extends AbstractFacade<Tokens> {

    private Query deleteByUserName;
    private Query deleteByExpirationTime;

    public TokensFacadeDB() {
        super(Tokens.class);
        deleteByUserName
                = getEntityManager().createNamedQuery("Tokens.deleteByUserName");
        deleteByExpirationTime
                = getEntityManager().createNamedQuery("Tokens.deleteByExpiresTime");

    }
    @Override
    public Tokens find(Object id) {
        Tokens tokens = super.find(id);
        if (tokens.getExpires().longValue() < System.currentTimeMillis()) {
            remove(tokens);
            tokens = null;
        }
        return tokens;
    }
    public void deleteByUserName(String userName) {
        deleteByUserName.setParameter("userName", userName).executeUpdate();
    }

    public void deleteExpiredTokens() {
        deleteByExpirationTime.setParameter("currentTime",
                System.currentTimeMillis()).executeUpdate();
    }

    @Override
    protected EntityManager getEntityManager() {
        return EntityManagerHolder.INSTANCE.get();
    }

}
