/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import se.stolpjakten.api.service.exception.InternalServerError;

@Provider
public class ErrorMapper implements ExceptionMapper<RuntimeException> {
    Logger logger = Logger.getLogger(ErrorMapper.class.getName());

    @Override
    public Response toResponse(RuntimeException exception) {
        InternalServerError error = new InternalServerError();
        String identifier = "..";
        error.setIdentifier(identifier);
        logger.log(Level.SEVERE, identifier, exception);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
    }
    
}
