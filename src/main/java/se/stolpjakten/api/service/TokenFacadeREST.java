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
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
@Path("/users/{id}/tokens")
public class TokenFacadeREST {
    @PersistenceContext(unitName = "se.stolpjakten.api_stolpjaktenAPI_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    /**
     * Create a token to use for subsequent requests to this API. 
     * <br>
     * If you do not have a user yet, please create one using the Users REST facade (POST).
     * <br>
     * The retrieved token SHOULD be stored by API client implementations. 
     * <br>
     * Client implementations <b>MUST NOT</b> store the user username and password.
     * <br>
     * An API client can retrieve as many tokens as it likes, but server might 
     * discard old tokens to manage memory resources.
     * <br>
     * <br>
     * <b>Authentication:</b> Basic Authentication (RFC 7617)
     * @param context
     * @return 
     */
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
    }/*
    @DELETE
    public void deleteToken(@Context ContainerRequestContext context) {
        
    }*/


}
