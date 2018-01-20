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
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import se.stolpjakten.api.db.facade.TokensFacadeDB;
import se.stolpjakten.api.db.type.Tokens;
import se.stolpjakten.api.rest.type.Token;
import se.stolpjakten.api.security.aspects.BasicSecured;
import se.stolpjakten.api.security.aspects.TokenSecured;
import se.stolpjakten.api.exceptions.AuthorizationException;
import se.stolpjakten.api.utils.EntityManagerHolder;

/**
 *
 * @author gengdahl
 */
@Stateless
@Path("/users/{userId}/tokens")
public class TokenFacadeREST {
    private TokensFacadeDB db = null;
    private TokensFacadeDB getDb() {
        if (db == null) {
            db = new TokensFacadeDB();
        }
        return db;
    }


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
        getDb().create(dbToken);

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
        //TODO optimize to do delete instead of select + delete
        getDb().remove(getDb().find(tokenId));

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
        getDb().deleteByUserName(id);

    }

}
