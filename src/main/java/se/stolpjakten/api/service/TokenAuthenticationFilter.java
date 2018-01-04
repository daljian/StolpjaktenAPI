/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.annotation.Priority;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import se.stolpjakten.api.db.RoleMappings;
import se.stolpjakten.api.db.Tokens;
import se.stolpjakten.api.security.TokenSecured;
import se.stolpjakten.api.security.User;
import se.stolpjakten.api.security.UserSecurityContext;
import se.stolpjakten.api.security.exceptions.AuthenticationException;
import se.stolpjakten.api.utils.Strings;

/**
 *
 * @author gengdahl
 */
@TokenSecured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class TokenAuthenticationFilter implements ContainerRequestFilter {

    //https://stackoverflow.com/questions/26777083/best-practice-for-rest-token-based-authentication-with-jax-rs-and-jersey
    @PersistenceContext(unitName = "se.stolpjakten.api_stolpjaktenAPI_war_1.0-SNAPSHOTPU")
    EntityManager entityManager;

    private static final String REALM = "stolpjakten.se";
    private static final String AUTHENTICATION_SCHEME = "Bearer";

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        // Get the Authorization header from the request
        String authorizationHeader
                = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        // Validate the Authorization header
        if (!isTokenBasedAuthentication(authorizationHeader)) {
            abortWithUnauthorized();
            return;
        }

        // Extract the token from the Authorization header
        String token = authorizationHeader
                .substring(AUTHENTICATION_SCHEME.length()).trim();

        try {

            // Validate the token
            String[] userScopes = extractUserRolesFromToken(token);
            if (!Strings.isNullOrEmpty(userScopes[0])) {
                User user = new User(userScopes[0],
                        userScopes[1]);
                String scheme
                        = requestContext.getUriInfo().getAbsolutePath().getScheme();
                List<String> roles = Collections.singletonList("test");
                SecurityContext securityContext = new UserSecurityContext(user,
                        scheme, roles);
                requestContext.setSecurityContext(securityContext);
            }

        } catch (Exception e) {
            abortWithUnauthorized();
        }
    }

    private boolean isTokenBasedAuthentication(String authorizationHeader) {

        // Check if the Authorization header is valid
        // It must not be null and must be prefixed with "Bearer" plus a whitespace
        // The authentication scheme comparison must be case-insensitive
        //TODO since we know the length of tokens are always the same we can 
        //also do length validation here.
        return authorizationHeader != null && authorizationHeader.toLowerCase()
                .startsWith(AUTHENTICATION_SCHEME.toLowerCase() + " ");
    }

    private void abortWithUnauthorized()
    throws AuthenticationException {
        throw new AuthenticationException("Please provide valid Bearer token.");
    }

    private String[] extractUserRolesFromToken(String token) throws Exception {
        // Check if the token was issued by the server and if it's not expired
        // Throw an Exception if the token is invalid
        Tokens dbToken = entityManager.find(Tokens.class, token);
        TypedQuery query = entityManager.createNamedQuery("RoleMappings.findByUserName", RoleMappings.class);
        query.setParameter("userName", dbToken.getUserName());
        List<RoleMappings> result = query.getResultList();
        for (RoleMappings mapping : result) {
            System.out.println("Bossekaka: " + mapping.getRoleMappingsPK().getRole());
        }

        return new String[]{dbToken.getUserName(), dbToken.getScopes()};
    }

}
