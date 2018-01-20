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
 * @author gengdahl
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public enum ErrorCode {
    JSON_SYNTAX(100,"JSON", "JSON syntax is incorrect."),
    JSON_SEMATIC(101,"JSON", "JSON semantic is incorrect."),
    JSON_FIELD_USERNAME(102,"JSON", "Field: username must follow configuration "
            + ConfigurationStore.USERNAME_PATTERN),
    JSON_FIELD_EMAIL(103,"JSON", "Field: email must be valid"),
    JSON_FIELD_PASSWORD(104,"JSON", "Field: password must follow Configuration "
            + ConfigurationStore.PASSWORD_PATTERN),
    RESOURCE_EXISTS(200, "RESOURCE", "Resource already exists"),
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
