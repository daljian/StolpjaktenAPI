/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.exceptions;

import java.io.IOException;

/**
 *
 * @author gengdahl
 */
public class AuthenticationException extends IOException{
    public AuthenticationException() {
        super();
    }
    public AuthenticationException(String message){
        super(message);
    }
    
}
