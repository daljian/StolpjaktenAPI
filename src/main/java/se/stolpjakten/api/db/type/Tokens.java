/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.db.type;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author gengdahl
 */
@Entity
@Table(name = "Tokens")
@NamedQueries({
    @NamedQuery(name = "Tokens.findAll", query = "SELECT t FROM Tokens t")
    , @NamedQuery(name = "Tokens.findByToken", query = "SELECT t FROM Tokens t WHERE t.token = :token")
    , @NamedQuery(name = "Tokens.findByUserName", query = "SELECT t FROM Tokens t WHERE t.userName = :userName")
    , @NamedQuery(name = "Tokens.findByExpires", query = "SELECT t FROM Tokens t WHERE t.expires = :expires")
    , @NamedQuery(name = "Tokens.deleteByUserName", query = "DELETE FROM Tokens t WHERE t.userName = :userName")
    , @NamedQuery(name = "Tokens.deleteByExpiresTime", query = "DELETE FROM Tokens t WHERE t.expires < :currentTime")
    , @NamedQuery(name = "Tokens.findByScopes", query = "SELECT t FROM Tokens t WHERE t.scopes = :scopes")})
public class Tokens implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    @Column(name = "Token")
    private String token;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "UserName")
    private String userName;
    @Column(name = "Expires")
    private BigInteger expires;
    @Size(max = 255)
    @Column(name = "Scopes")
    private String scopes;

    public Tokens() {
    }

    public Tokens(String token) {
        this.token = token;
    }

    public Tokens(String token, String userName) {
        this.token = token;
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BigInteger getExpires() {
        return expires;
    }

    public void setExpires(BigInteger expires) {
        this.expires = expires;
    }

    public String getScopes() {
        return scopes;
    }

    public void setScopes(String scopes) {
        this.scopes = scopes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (token != null ? token.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tokens)) {
            return false;
        }
        Tokens other = (Tokens) object;
        if ((this.token == null && other.token != null) || (this.token != null && !this.token.equals(other.token))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.stolpjakten.api.db.Tokens[ token=" + token + " ]";
    }
    
}