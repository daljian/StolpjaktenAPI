/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.db;

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
import se.stolpjakten.api.rest.User;

/**
 *
 * @author gengdahl
 */
@Entity
@Table(name = "Humans")
@NamedQueries({
    @NamedQuery(name = "Humans.findAll", query = "SELECT h FROM Humans h")
    , @NamedQuery(name = "Humans.findByUserName", query = "SELECT h FROM Humans h WHERE h.userName = :userName")
    , @NamedQuery(name = "Humans.findByEmail", query = "SELECT h FROM Humans h WHERE h.email = :email")
    , @NamedQuery(name = "Humans.findByPassword", query = "SELECT h FROM Humans h WHERE h.password = :password")
    , @NamedQuery(name = "Humans.findBySalt", query = "SELECT h FROM Humans h WHERE h.salt = :salt")})
public class Humans implements User, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "UserName")
    private String userName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "Email")
    private String email;
    @Size(max = 255)
    @Column(name = "Password")
    private String password;
    @Column(name = "Salt")
    private Integer salt;

    public Humans() {
    }

    public Humans(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Internal, never seen in API.
     * @return 
     */
    public Integer getSalt() {
        return salt;
    }

    public void setSalt(Integer salt) {
        this.salt = salt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userName != null ? userName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Humans)) {
            return false;
        }
        Humans other = (Humans) object;
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.stolpjakten.api.service.Humans[ userName=" + userName + " ]";
    }
    public Humans toRest() {
        setPassword(null);
        setSalt(null);
        return this;
    }
    
}
