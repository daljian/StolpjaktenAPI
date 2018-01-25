/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.rest.error;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.stream.JsonParsingException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import se.stolpjakten.api.exceptions.AuthenticationException;
import se.stolpjakten.api.exceptions.AuthorizationException;
import se.stolpjakten.api.exceptions.NotFoundException;
import se.stolpjakten.api.exceptions.UserException;
import se.stolpjakten.api.utils.AuthorizationHelper;
import se.stolpjakten.api.utils.ContainerRequestContextHolder;
import se.stolpjakten.api.utils.Strings;

@Provider
/**
 * This class maps java Exceptions to defined REST errors defined in this API.
 */
public class ErrorMapper implements ExceptionMapper<Exception> {
    static final Logger logger = Logger.getLogger(ErrorMapper.class.getName());

    @Override
    public Response toResponse(Exception exception) {
        if (exception instanceof AuthenticationException) {
            return convert((AuthenticationException)exception);
        } else if (exception instanceof AuthorizationException) {
            return convert((AuthorizationException)exception);
        } else if (exception instanceof UserException) {
            return convert((UserException)exception);
        } else if (exception instanceof NotFoundException) {
            return convert((NotFoundException)exception);
        } else if (exception instanceof JsonParsingException) {
            return convert((JsonParsingException)exception);
        } else {
            return convert(exception);
        }
        
    }
    public Response convert(Exception exception) {
        InternalServerError error = new InternalServerError();
        String identifier = UUID.randomUUID().toString();
        error.setIdentifier(identifier);
        StringBuilder sb = new StringBuilder();
        if (AuthorizationHelper.isAnonymous()) {
            sb.append("User: ").append(AuthorizationHelper.getUserName());
        } else {
            sb.append("No user");
        }
        sb.append(", ip: ").append(AuthorizationHelper.getIpAddress())
                .append(", error identifier: ").append(identifier);
        
        logger.log(Level.SEVERE, sb.toString(), exception);
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
        BadRequest error = new BadRequest(exception.getErrorCode(),
                exception.getMessage());
        setErrorDescription(error, exception);
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
    public Response convert(JsonParsingException exception) {
        BadRequest error = new BadRequest(ErrorCode.JSON_SYNTAX,
                ErrorCode.JSON_SYNTAX.getDescription());
        setErrorDescription(error, exception);
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
    public Response convert (NotFoundException exception ) {
        NotFound error = new NotFound(exception.getMessage());
        return Response.status(Response.Status.NOT_FOUND).entity(error).build();
    }
    private void setErrorDescription (BaseError error, Exception exception) {
        if (!Strings.isNullOrEmpty(exception.getMessage())) {
            error.setDescription(exception.getMessage());
        }
    }
    
    
    
}
