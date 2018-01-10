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
 * @author gengdahl
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Forbidden extends BaseError {
    public Forbidden() {
        setDescription("Please provide correct authentication details.");
    }
    public Forbidden(String description) {
        setDescription(description);
    }
}
