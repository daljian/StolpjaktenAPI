/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.db.facade;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import se.stolpjakten.api.db.type.RoleMappings;
import se.stolpjakten.api.utils.EntityManagerHolder;

/**
 *
 * @author gengdahl
 */
public class RoleMappingsFacadeDB extends AbstractFacade<RoleMappings>{
    TypedQuery<RoleMappings> findByUserName;
    public RoleMappingsFacadeDB() {
        super(RoleMappings.class);
        findByUserName = getEntityManager().createNamedQuery(
                "RoleMappings.findByUserName", RoleMappings.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return EntityManagerHolder.INSTANCE.get();
    }
    
    public List<RoleMappings> findByUserName(String userName)   {
        return findByUserName.setParameter("userName",
                userName).getResultList();
    }
            
    
    
}
