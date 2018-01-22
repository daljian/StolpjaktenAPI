/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.rest.type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import se.stolpjakten.api.db.type.RoleMappings;

/**
 *
 * @author gengdahl
 */
@XmlRootElement(name = "roleMapping")
@XmlAccessorType(XmlAccessType.FIELD)
public class RoleMapping {
    private String role;
    private String userName;

    public String getRole() {
        return role;
    }

    @XmlElement(required = true)
    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    @XmlElement(required = true)
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public RoleMappings toRoleMappings() {
        return new RoleMappings(userName, role);
        
    }
    
    
}
