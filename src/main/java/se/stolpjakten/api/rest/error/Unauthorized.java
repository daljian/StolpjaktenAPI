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
 * Payload for unauthorized (401) responses.
 * <br>
 * Please see description for details about the specific error.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Unauthorized extends BaseError {
   public static final String DEFAULT_DESCRIPTION = "You are not authorized to access this resource.";
    public Unauthorized() {
        setDescription(DEFAULT_DESCRIPTION);
    }
    public Unauthorized(String description) {
        setDescription(description);
    }
}
