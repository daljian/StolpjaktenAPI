/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.rest.type;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author gengdahl
 */
public interface User {
    /**
     * A globally unique username that identifies a user.
     * <br>
     * Required: yes
     */
    @XmlElement(required = true)
    public String getUserName();

    /**
     * Email address for this user.
     * <br>
     * Required: no
     */
    @XmlElement(required = false)
    public String getEmail();

    /**
     * Password for this user.
     * <br>
     * Only available for add (POST) and update (PUT) requests.
     * <br>
     * Stored in database using xxx one-way hash algorithm with key yyy and salt length ZZZ.
     * <br>
     * Required: yes
     */
    public String getPassword();

}
