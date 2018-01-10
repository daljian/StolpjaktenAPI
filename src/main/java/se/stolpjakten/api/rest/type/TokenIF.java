/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.rest.type;

/**
 *
 * @author gengdahl
 */
public interface TokenIF {
    public String getAccessToken();
    public String getType();
    public long getExpire();
}
