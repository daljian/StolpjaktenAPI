/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.service;

import se.stolpjakten.api.db.Humans;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import se.stolpjakten.api.security.BasicAuth;
import se.stolpjakten.api.security.BasicSecured;
import se.stolpjakten.api.security.User;
import se.stolpjakten.api.security.UserSecurityContext;
import se.stolpjakten.api.utils.Strings;

@BasicSecured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class BasicAuthenticationFilter implements ContainerRequestFilter {

    @PersistenceContext(unitName = "se.stolpjakten.api_stolpjaktenAPI_war_1.0-SNAPSHOTPU")
    EntityManager entityManager;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        boolean authenticated = false;
        try {
            String auth = requestContext.getHeaderString("authorization");
            String[] userPass = BasicAuth.decode(auth.replaceFirst("[Bb]asic ", ""));
            if (!Strings.isNullOrEmpty(userPass[0])
                    && !Strings.isNullOrEmpty(userPass[1])) {
                Humans human = entityManager.find(Humans.class, userPass[0]);
                if (human.getPassword().equals(userPass[1])) {
                    User user = new User(userPass[0]);
                    String scheme = 
                            requestContext.getUriInfo().getAbsolutePath().getScheme();
                    List<String> roles = Collections.singletonList("test");
                    SecurityContext securityContext = 
                            new UserSecurityContext(user, scheme, roles);
                    requestContext.setSecurityContext(securityContext);
                    authenticated = true;
                }

                //TODO check how to reach DB from here
            }
        } finally {
            if (!authenticated) {
                throw new RuntimeException("Forbidden");
            }
        }
    }
}
