/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.filters;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.annotation.Priority;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import se.stolpjakten.api.db.type.Users;
import se.stolpjakten.api.security.BasicAuth;
import se.stolpjakten.api.security.aspects.BasicSecured;
import se.stolpjakten.api.security.User;
import se.stolpjakten.api.security.UserSecurityContext;
import se.stolpjakten.api.exceptions.AuthenticationException;
import se.stolpjakten.api.security.PasswordAuthentication;
import se.stolpjakten.api.utils.Strings;

@BasicSecured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class BasicAuthenticationFilter implements ContainerRequestFilter {
        private PasswordAuthentication passwordAuthentication = null;


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
                Users dbUser = entityManager.find(Users.class, userPass[0]);
                PasswordAuthentication helper = getPasswordAuthentication();
                
                if (helper.authenticate(userPass[1].toCharArray(),
                        dbUser.getPassword())) {
                    User user = new User(userPass[0]);
                    String scheme = 
                            requestContext.getUriInfo().getAbsolutePath().getScheme();
                    //TODO check the roles
                    List<String> roles = Collections.singletonList("USER");
                    SecurityContext securityContext = 
                            new UserSecurityContext(user, scheme, roles);
                    requestContext.setSecurityContext(securityContext);
                    authenticated = true;
                }

                //TODO check how to reach DB from here
            }
        } finally {
            if (!authenticated) {
                throw new AuthenticationException("Please provide valid basic authentication information");
            }
        }
    }
    private PasswordAuthentication getPasswordAuthentication(){
        if (passwordAuthentication == null) {
            passwordAuthentication = new PasswordAuthentication();
        }
        return passwordAuthentication;
    }
}
