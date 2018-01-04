/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.service;

import java.math.BigInteger;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import se.stolpjakten.api.db.Tokens;
import se.stolpjakten.api.rest.Token;
import se.stolpjakten.api.security.BasicSecured;

/**
 *
 * @author gengdahl
 */
@Stateless
@Path("/token")
public class TokenFacadeREST {
    @PersistenceContext(unitName = "se.stolpjakten.api_stolpjaktenAPI_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @BasicSecured
    public Token getToken(@Context ContainerRequestContext context) {
        String userName = 
                context.getSecurityContext().getUserPrincipal().getName();
        Tokens dbToken = new Tokens();
        
        dbToken.setExpires(
                BigInteger.valueOf(System.currentTimeMillis() + 3600));
        dbToken.setScopes("user");
        dbToken.setUserName(userName);
        dbToken.setToken(UUID.randomUUID().toString());
        em.persist(dbToken);
        
        return Token.fromTokens(dbToken);
    }


}
