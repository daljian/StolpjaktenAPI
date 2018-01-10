/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.rest.facade;

import java.io.IOException;
import java.math.BigInteger;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import se.stolpjakten.api.db.type.Tokens;
import se.stolpjakten.api.rest.type.Token;
import se.stolpjakten.api.rest.type.TokenIF;
import se.stolpjakten.api.security.BasicSecured;
import se.stolpjakten.api.security.TokenSecured;
import se.stolpjakten.api.security.exceptions.AuthorizationException;

/**
 *
 * @author gengdahl
 */
@Stateless
@Path("/users/{userId}/tokens")
public class TokenFacadeREST {

    @PersistenceContext(unitName = "se.stolpjakten.api_stolpjaktenAPI_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    /**
     * Create a token to use for subsequent requests to this API.
     * <br>
     * If you do not have a user yet, please create one using the Users REST
     * facade (POST).
     * <br>
     * The retrieved token SHOULD be stored by API client implementations.
     * <br>
     * Client implementations <b>MUST NOT</b> store the user username and
     * password.
     * <br>
     * An API client can retrieve as many tokens as it likes, but server might
     * discard old tokens to manage memory resources.
     * <br>
     * <br>
     * <b>Authentication:</b> Basic Authentication (RFC 7617)
     *
     * @param context
     * @return
     */
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @BasicSecured
    public Token createToken(@PathParam("userId") String id, Token token,
            @Context ContainerRequestContext context) throws IOException {
        String userName
                = context.getSecurityContext().getUserPrincipal().getName();
        if (!userName.equals(id)) {
            throw new AuthorizationException();
        }
        Tokens dbToken = new Tokens();

        dbToken.setExpires(BigInteger.valueOf(System.currentTimeMillis()
                + token.getExpire() * 1000));
        dbToken.setScopes("user");
        dbToken.setUserName(userName);
        dbToken.setToken(UUID.randomUUID().toString());
        em.persist(dbToken);

        return Token.fromTokens(dbToken);
    }

    /**
     * Delete a previously created token.
     *
     * @param userId The user id (username) of te current user.
     * @param tokenId The access token to delete, eg
     * 8758f65a-c27b-4f86-a43d-3ce1add36ec6
     * <br>
     * <b>Authentication:</b> Bearer Token
     *
     */
    @DELETE
    @Path("{token-id}")
    @TokenSecured
    public void deleteToken(@PathParam("userId") String id,
            @PathParam("token-id") String tokenId,
            @Context ContainerRequestContext context) throws IOException {
        String userName
                = context.getSecurityContext().getUserPrincipal().getName();
        if (!userName.equals(id)) {
            throw new AuthorizationException();
        }
        em.remove(em.find(Tokens.class, tokenId));

    }

    /**
     * Delete a previously created token.
     *
     * @param userId The user id (username) of te current user.
     * @param tokenId The access token to delete, eg
     * 8758f65a-c27b-4f86-a43d-3ce1add36ec6
     * <br>
     * <b>Authentication:</b> Bearer Token
     *
     */
    @DELETE
    @TokenSecured
    public void deleteTokens(@PathParam("userId") String id,
            @Context ContainerRequestContext context) throws IOException {
        if (!context.getSecurityContext().getUserPrincipal().getName().equals(id)) {
            throw new AuthorizationException();
        }
        TypedQuery query = em.createNamedQuery("Tokens.deleteByUserName", Tokens.class);
        query.setParameter("userName", id);
        query.executeUpdate();

    }

}
