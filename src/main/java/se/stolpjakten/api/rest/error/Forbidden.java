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
 * Payload for forbidden (403) responses.
 * <br>
 * Please see error code and description for details about the specific error.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Forbidden extends BaseError {
   public static final String DEFAULT_DESCRIPTION = "Authorization header is missing or contains incorrect credentials.";

    public Forbidden() {
        setDescription(DEFAULT_DESCRIPTION);
    }
    public Forbidden(String description) {
        setDescription(description);
    }
}
