/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.rest.error;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Payload for bad request (400) responses.
 * <br>
 * Please see error code and description for details about the specific error.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BadRequest extends BaseError {
    public static final String DEFAULT_DESCRIPTION = "Request data is sematically or syntactically incorrect.";

    private ErrorCode errorCode;

    /**
     * The Error code.
     */
    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public BadRequest() {

    }

    public BadRequest(ErrorCode code, String description) {
        this.errorCode = code;
        setDescription(description);
    }

}
