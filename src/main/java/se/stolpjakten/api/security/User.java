/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.security;

import java.security.Principal;

/**
 *
 * @author gengdahl
 */
public class User implements Principal {
    public User(String name) {
        this(name, null);
    }
    public User(String name,
            String scopes) {
        this.name = name;
        this.scopes = scopes;
    }
    private final String name;
    private final String scopes;

    @Override
    public String getName() {
        return name;
    }
    public String getScopes() {
        return scopes;
        
    }
    
}
