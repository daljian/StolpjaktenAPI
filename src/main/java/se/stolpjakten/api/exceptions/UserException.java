/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.exceptions;

import java.io.IOException;
import se.stolpjakten.api.rest.error.ErrorCode;

/**
 *
 * @author gengdahl
 */
public class UserException extends IOException {
    private final ErrorCode errorCode;
    public UserException(ErrorCode code, String message){
        super(message);
        this.errorCode = code;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
    
    
}
