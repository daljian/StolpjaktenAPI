/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.security;

import java.security.Principal;
import java.util.List;
import javax.ws.rs.core.SecurityContext;

/**
 *
 * @author gengdahl
 */
public class UserSecurityContext implements SecurityContext {
    private User user;
    private String scheme;
    public UserSecurityContext(User user, String scheme, List<String> roles) {
        this.user = user;
        this.scheme = scheme;
    }
   @Override
    public Principal getUserPrincipal() {return this.user;}
 
    @Override
    public boolean isUserInRole(String s) {
        return true;
    }
 
    @Override
    public boolean isSecure() {return "https".equals(this.scheme);}
 
    @Override
    public String getAuthenticationScheme() {
        return SecurityContext.BASIC_AUTH;
    }
    
}
