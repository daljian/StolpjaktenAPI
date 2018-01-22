/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.exceptions;

/**
 *
 * @author gengdahl
 */
public class NotFoundException extends Exception {
    public NotFoundException(String message) {
        super(message);
    }
    public NotFoundException() {
        super("The requested resource was not found");
    }
    
}
