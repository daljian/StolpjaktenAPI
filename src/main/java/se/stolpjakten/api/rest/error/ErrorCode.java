/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.rest.error;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import se.stolpjakten.api.utils.ConfigurationStore;

/**
 *
 * Enumeration of error codes that can occur in BadRequest responses.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public enum ErrorCode {
    /**
     * JSON is not syntactically  correct.
     * <br>
     * Please make sure to use JSON lib to create your payload.
     */
    JSON_SYNTAX(100,"JSON", "JSON syntax is incorrect."),
    /**
     * JSON is not semantically correct.
     * <br>
     * Please consult API documentation to assert you follow the correct format.
     */
    JSON_SEMATIC(101,"JSON", "JSON semantic is incorrect."),
    /**
     * JSON field "userName" is not correct.
     * <br>
     * Please consult Configuration setting: USERNAME_PATTERN 
     */
    JSON_FIELD_USERNAME(102,"JSON", "Field: username must follow configuration "
            + ConfigurationStore.USERNAME_PATTERN),
    /**
     * JSON field "email" is not correct.
     * <br>
     * Email address must pass validation by javax.mail.internet.InternetAddress
     */
    JSON_FIELD_EMAIL(103,"JSON", "Field: email must be valid"),
    /**
     * JSON field "password" is not correct.
     * <br>
     * Please consult Configuration setting: PASSWORD_PATTERN 
     */
    JSON_FIELD_PASSWORD(104,"JSON", "Field: password must follow Configuration "
            + ConfigurationStore.PASSWORD_PATTERN),
    /**
     * Can not create resource, because it already exists.
     * <br>
     * POST another resource or use PUT to edit existing resource.
     */
    RESOURCE_EXISTS(200, "RESOURCE", "Resource already exists"),
    /**
     * Requested resource was not found.
     * <br>
     * Could not find requested resource, maybe you want to POST to create it?
     */
    RESOURCE_NOT_EXISTS(201, "RESOURCE", "This resource does not exist");
    private static final Map<Integer, ErrorCode> CACHE = new HashMap<>();
  static {
    for (final ErrorCode code : ErrorCode.values()) {
      CACHE.put(code.getCode(), code);
    }
  }
    
    
    private final int code;
    private final String category;
    private final String description;
    private ErrorCode(int code, String category, String description) {
        this.code = code;
        this.category = category;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

  /**
   * Lookup ErrorCode object based on deny code integer.
   * @param code code to lookup
   * @return instance of ErrorCode or null if not found
   */
  public static ErrorCode fromCode(int code) {
    return CACHE.get(code);
  }    
    
}
