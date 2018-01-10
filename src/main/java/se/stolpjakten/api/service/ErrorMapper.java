/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.service;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import se.stolpjakten.api.rest.error.BaseError;
import se.stolpjakten.api.rest.error.Forbidden;
import se.stolpjakten.api.rest.error.InternalServerError;
import se.stolpjakten.api.rest.error.Unauthorized;
import se.stolpjakten.api.rest.error.UserError;
import se.stolpjakten.api.security.exceptions.AuthenticationException;
import se.stolpjakten.api.security.exceptions.AuthorizationException;
import se.stolpjakten.api.security.exceptions.UserException;
import se.stolpjakten.api.utils.Strings;

@Provider
public class ErrorMapper implements ExceptionMapper<Exception> {
    Logger logger = Logger.getLogger(ErrorMapper.class.getName());

    @Override
    public Response toResponse(Exception exception) {
        if (exception instanceof AuthenticationException) {
            return convert((AuthenticationException)exception);
        } else if (exception instanceof AuthorizationException) {
            return convert((AuthorizationException)exception);
        } else if (exception instanceof UserException) {
            return convert((UserException)exception);
        } else {
            return convert(exception);
        }
    }
    public Response convert(Exception exception) {
        InternalServerError error = new InternalServerError();
        String identifier = UUID.randomUUID().toString();
        error.setIdentifier(identifier);
        logger.log(Level.SEVERE, identifier, exception);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
    }
    public Response convert(AuthenticationException exception) {
        Forbidden error = new Forbidden();
        setErrorDescription(error, exception);
        return Response.status(Response.Status.UNAUTHORIZED).entity(error).build();
    }
    public Response convert(AuthorizationException exception) {
        Unauthorized error = new Unauthorized();
        setErrorDescription(error, exception);
        return Response.status(Response.Status.FORBIDDEN).entity(error).build();
    }
    public Response convert(UserException exception) {
        UserError error = new UserError(exception.getErrorCode(),
                exception.getMessage());
        setErrorDescription(error, exception);
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
    private void setErrorDescription (BaseError error, Exception exception) {
        if (!Strings.isNullOrEmpty(exception.getMessage())) {
            error.setDescription(exception.getMessage());
        }
    }
    
}
