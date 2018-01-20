/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.db.type;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gengdahl
 */
@Entity
@Table(name = "Configuration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Configuration.findAll", query = "SELECT c FROM Configuration c")
    , @NamedQuery(name = "Configuration.findByCfgKey", query = "SELECT c FROM Configuration c WHERE c.cfgKey = :cfgKey")
    , @NamedQuery(name = "Configuration.findByCfgValue", query = "SELECT c FROM Configuration c WHERE c.cfgValue = :cfgValue")})
public class Configuration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CfgKey")
    private String cfgKey;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CfgValue")
    private String cfgValue;

    public Configuration() {
    }

    public Configuration(String cfgKey) {
        this.cfgKey = cfgKey;
    }

    public Configuration(String cfgKey, String cfgValue) {
        this.cfgKey = cfgKey;
        this.cfgValue = cfgValue;
    }

    public String getCfgKey() {
        return cfgKey;
    }

    public void setCfgKey(String cfgKey) {
        this.cfgKey = cfgKey;
    }

    public String getCfgValue() {
        return cfgValue;
    }

    public void setCfgValue(String cfgValue) {
        this.cfgValue = cfgValue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cfgKey != null ? cfgKey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Configuration)) {
            return false;
        }
        Configuration other = (Configuration) object;
        if ((this.cfgKey == null && other.cfgKey != null) || (this.cfgKey != null && !this.cfgKey.equals(other.cfgKey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.stolpjakten.api.db.type.Configuration[ cfgKey=" + cfgKey + " ]";
    }
    
}
