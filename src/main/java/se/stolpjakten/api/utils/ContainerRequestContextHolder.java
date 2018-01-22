/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.utils;

import javax.ws.rs.container.ContainerRequestContext;

/**
 *
 * @author gengdahl
 */
public enum ContainerRequestContextHolder {
    INSTANCE;
    ThreadLocal<ContainerRequestContext> reqCtx = new ThreadLocal<>();
    public void set(ContainerRequestContext reqCtx) {
        this.reqCtx.set(reqCtx);
    }
    
    public ContainerRequestContext get() {
        return reqCtx.get();
    }
}
