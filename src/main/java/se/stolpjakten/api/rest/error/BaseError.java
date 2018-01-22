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
 * Base class for all errors.
 * <br>
 * All errors contains a description text.
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class BaseError {
    /**
     * Human readable description for this error.
     * 
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String theDescription) {
        description = theDescription;
    }
    
    private String description = "Server error";
    
}
