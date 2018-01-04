/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.rest;

import se.stolpjakten.api.db.Tokens;


/**
 *
 * @author gengdahl
 */
public class Token {

    private String accessToken;
    private String type;
    private long expire;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }
    public static Token fromTokens(Tokens dbToken) {
        Token token = new Token();
        token.setAccessToken(dbToken.getToken());
        token.setExpire(dbToken.getExpires().longValue()
                - System.currentTimeMillis());
        token.setType("Bearer");
        return token;
    }

}
