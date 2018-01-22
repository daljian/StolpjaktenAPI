/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.utils;

import java.security.Principal;
import javax.ws.rs.core.SecurityContext;
import se.stolpjakten.api.exceptions.AuthorizationException;
import se.stolpjakten.api.exceptions.UserException;
import se.stolpjakten.api.rest.error.ErrorCode;
import se.stolpjakten.api.rest.type.Role;

/**
 *
 * @author gengdahl
 */
public class AuthorizationHelper {
    public static void assertRequestingUser(String userName)
            throws AuthorizationException {
        Principal principal = ContainerRequestContextHolder.INSTANCE.get()
                .getSecurityContext().getUserPrincipal();
        if (principal == null || !principal.getName().equals(userName)) {
            throw new AuthorizationException();
        }
        
    }
    public static boolean isInRole(Role role) {
        if (isAnonymous()) {
            return false;
        } else {
            return getSecurityContext().isUserInRole(role.name());
        }
        
    }
    private static boolean isAnonymous() {
        return getSecurityContext() == null;
    }
    private static SecurityContext getSecurityContext() {
        return ContainerRequestContextHolder.INSTANCE.get()
                .getSecurityContext();
    }
    
}
