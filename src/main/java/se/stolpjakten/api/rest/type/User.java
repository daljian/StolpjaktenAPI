/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.rest.type;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * User container class.
 */
public interface User {
    /**
     * A globally unique username that identifies a user.
     * <br>
     * Required: yes
     * @documentationExample kalle
     */
    @XmlElement(required = true)
    public String getUserName();

    /**
     * Email address for this user.
     * <br>
     * Required: no
     * @documentationExample Kalle@stolpjakten.se
     */
    @XmlElement(required = false)
    public String getEmail();

    /**
     * Password for this user.
     * <br>
     * Only available for add (POST) and update (PUT) requests.
     * <br>
     * Stored in database using salted one-way hash algorithm with.
     * <br>
     * Required: yes
     * @documentationExample H4MM3Rf@ll
     */
    public String getPassword();

}
