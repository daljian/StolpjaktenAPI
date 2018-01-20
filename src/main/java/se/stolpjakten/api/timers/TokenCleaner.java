/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.timers;

import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.stolpjakten.api.db.facade.TokensFacadeDB;
import se.stolpjakten.api.utils.EntityManagerHolder;

/**
 *
 * @author gengdahl
 */
@Stateless
public class TokenCleaner {

    @PersistenceContext(unitName = "se.stolpjakten.api_stolpjaktenAPI_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    private TokensFacadeDB db = null;

    private TokensFacadeDB getDb() {
        if (db == null) {
            db = new TokensFacadeDB();
        }
        return db;
    }

    @Schedule(dayOfWeek = "Mon-Sun", month = "*", hour = "2-4", dayOfMonth = "*", year = "*", minute = "37", second = "37", persistent = false)
    public void myTimer() {
        EntityManagerHolder.INSTANCE.set(em);
        try {
            getDb().deleteExpiredTokens();
        } finally {
            EntityManagerHolder.INSTANCE.set(null);
        }
    }
}
