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
import se.stolpjakten.api.db.type.Tokens;

/**
 *
 * @author gengdahl
 */
@XmlRootElement(name = "token")
@XmlAccessorType(XmlAccessType.FIELD)
public class Token implements TokenIF {

    private String accessToken;
    private String type;
    private long expire;

    /**
     * The Bearer access token to be used for token protected endpoints.
     * <br><br>
     * Sample value:
     * <br>
     * 5eb19a75-c1d2-4d57-b1ec-4c61ff3c3cf2
     */
    public String getAccessToken() {
        return accessToken;
    }

    @XmlElement(required = true)
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * Type of access token, currently only Bearer tokens are supported.
     * <br><br>
     * Sample value:
     * <br>
     * Bearer
     */
    public String getType() {
        return type;
    }

    @XmlElement(required = true)
    public void setType(String type) {
        this.type = type;
    }

    /**
     * The seconds left of the token life time.
     *
     * <br><br>
     * Sample value:
     * <br> 3600
     */
    public long getExpire() {
        return expire;
    }

    @XmlElement(required = true)
    public void setExpire(long expire) {
        this.expire = expire;
    }

    public static Token fromTokens(Tokens dbToken) {
        Token token = new Token();
        token.setAccessToken(dbToken.getToken());
        token.setExpire((dbToken.getExpires().longValue()
                - System.currentTimeMillis())/1000);
        token.setType("Bearer");
        return token;
    }

}
