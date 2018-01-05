/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.security;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.SecurityContext;
import se.stolpjakten.api.rest.Role;

/**
 *
 * @author gengdahl
 */
public class UserSecurityContext implements SecurityContext {
    private User user;
    private String scheme;
    private List<String> roles;
    public UserSecurityContext(User user, String scheme, List<String> roles) {
        this.user = user;
        this.scheme = scheme;
        this.roles = roles;
    }
   @Override
    public Principal getUserPrincipal() {return this.user;}
 
    @Override
    public boolean isUserInRole(String role) {
        return roles.contains(role);
    }
 
    @Override
    public boolean isSecure() {return "https".equals(this.scheme);}
 
    @Override
    public String getAuthenticationScheme() {
        return SecurityContext.BASIC_AUTH;
    }
    
}
