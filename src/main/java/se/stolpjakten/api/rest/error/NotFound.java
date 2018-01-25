/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.rest.error;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Payload for not found (404) responses.
 * <br>
 * Please see description for details about the specific error.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NotFound extends BaseError {
    public static final String DEFAULT_DESCRIPTION = "This resource does not exist.";

    public NotFound() {
        setDescription(DEFAULT_DESCRIPTION);
    }
    public NotFound(String description) {
        setDescription(description);
    }
    
}
