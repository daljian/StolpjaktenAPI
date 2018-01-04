/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.db;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gengdahl
 */
@Entity
@Table(name = "RoleMappings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoleMappings.findAll", query = "SELECT r FROM RoleMappings r")
    , @NamedQuery(name = "RoleMappings.findByUserName", query = "SELECT r FROM RoleMappings r WHERE r.roleMappingsPK.userName = :userName")
    , @NamedQuery(name = "RoleMappings.findByRole", query = "SELECT r FROM RoleMappings r WHERE r.roleMappingsPK.role = :role")})
public class RoleMappings implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RoleMappingsPK roleMappingsPK;

    public RoleMappings() {
    }

    public RoleMappings(RoleMappingsPK roleMappingsPK) {
        this.roleMappingsPK = roleMappingsPK;
    }

    public RoleMappings(String userName, String role) {
        this.roleMappingsPK = new RoleMappingsPK(userName, role);
    }

    public RoleMappingsPK getRoleMappingsPK() {
        return roleMappingsPK;
    }

    public void setRoleMappingsPK(RoleMappingsPK roleMappingsPK) {
        this.roleMappingsPK = roleMappingsPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleMappingsPK != null ? roleMappingsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleMappings)) {
            return false;
        }
        RoleMappings other = (RoleMappings) object;
        if ((this.roleMappingsPK == null && other.roleMappingsPK != null) || (this.roleMappingsPK != null && !this.roleMappingsPK.equals(other.roleMappingsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.stolpjakten.api.db.RoleMappings[ roleMappingsPK=" + roleMappingsPK + " ]";
    }
    
}
