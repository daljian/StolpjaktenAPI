/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.rest.type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gengdahl
 * @documentationExample kalle
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public enum Role {
    /**
     * All users have at least USER role.
     */
    USER,
    /**
     * AREA_ADMIN users manages a specific area.
     * <br>
     * One user can manage several areas.
     */
    AREA_ADMIN,
    /**
     * SYS_ADMIN users is a small set of users that have unlimited API access.
     */
    SYS_ADMIN;

}
