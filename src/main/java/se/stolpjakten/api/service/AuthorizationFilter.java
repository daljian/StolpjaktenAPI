/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.service;

import java.io.IOException;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import se.stolpjakten.api.rest.type.Role;
import se.stolpjakten.api.security.Authorization;
import se.stolpjakten.api.security.exceptions.AuthorizationException;

/**
 *
 * @author gengdahl
 */
@Provider
@Priority(Priorities.AUTHORIZATION)
@Authorization
public class AuthorizationFilter implements ContainerRequestFilter {
    @Context
    private ResourceInfo resourceInfo;
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        // Get the resource class which matches with the requested URL
        // Extract the roles declared by it
        Class<?> resourceClass = resourceInfo.getResourceClass();
        List<Role> classRoles = extractRoles(resourceClass);

        // Get the resource method which matches with the requested URL
        // Extract the roles declared by it
        Method resourceMethod = resourceInfo.getResourceMethod();
        List<Role> methodRoles = extractRoles(resourceMethod);
        SecurityContext securityContext = requestContext.getSecurityContext();


        // Check if the user is allowed to execute the method
        // The method annotations override the class annotations
        if (methodRoles.isEmpty()) {
            checkPermissions(securityContext, classRoles);
        } else {
            checkPermissions(securityContext, methodRoles);
        }

    }

    // Extract the roles from the annotated element
    private List<Role> extractRoles(AnnotatedElement annotatedElement) {
        if (annotatedElement == null) {
            return new ArrayList<Role>();
        } else {
            Authorization authorization = annotatedElement.getAnnotation(Authorization.class);
            if (authorization == null) {
                return new ArrayList<Role>();
            } else {
                Role[] allowedRoles = authorization.value();
                return Arrays.asList(allowedRoles);
            }
        }
    }

    private void checkPermissions(SecurityContext securityContext,
            List<Role> allowedRoles) throws IOException {
        // Check if the user contains one of the allowed roles
        // Throw an Exception if the user has not permission to execute the method
        boolean authorized = false;
        for (Role role : allowedRoles) {
            authorized = securityContext.isUserInRole(role.name());
            if (authorized) {
                break;
            }
        }
        if (!authorized) {
            throw new AuthorizationException();
        }
    }
}
