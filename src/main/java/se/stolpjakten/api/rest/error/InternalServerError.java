/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.rest.error;

import java.util.UUID;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Payload for internal server error (500) responses.
 * <br>
 * When an unforseen error happens, this payload will be generated.
 * <br>
 * Should you file a bug report for receiving this error please do so here:
 * <br>
 * https://github.com/daljian/StolpjaktenAPI/issues
 * <br>
 * Please include the identifier as a minimum, and if you know how to reproduce
 * the error, please also provide the steps to reproduce the error.
 * <br>
 * Thanks!
 * 
 * 
 */
@XmlRootElement(name = "serverError")
@XmlAccessorType(XmlAccessType.FIELD)
public class InternalServerError extends BaseError {
    
    private String identifier = UUID.randomUUID().toString();
/**
 * A unique identifier for this specific error incident.
 * <br>
 * The server log file will have more details about the error.
 * 
 * @return 
 */
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    
}
