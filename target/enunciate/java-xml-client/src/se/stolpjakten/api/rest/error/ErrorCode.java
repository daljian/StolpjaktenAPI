/**
 * 
 *
 * Generated by <a href="http://enunciate.webcohesion.com">Enunciate</a>.
 */
package se.stolpjakten.api.rest.error;

/**
 * 
 *  Enumeration of error codes that can occur in BadRequest responses.
 */
@javax.xml.bind.annotation.XmlType (
  name = "errorCode",
  namespace = ""
)
@javax.xml.bind.annotation.XmlEnum (
  java.lang.String.class
)
@javax.xml.bind.annotation.XmlRootElement (
  name = "errorCode",
  namespace = ""
)
public enum ErrorCode {

  /**
   *  JSON is not syntactically  correct.
   *  <br>
   *  Please make sure to use JSON lib to create your payload.
   */
  @javax.xml.bind.annotation.XmlEnumValue ( "JSON_SYNTAX" )
  JSON_SYNTAX("JSON_SYNTAX"),

  /**
   *  JSON is not semantically correct.
   *  <br>
   *  Please consult API documentation to assert you follow the correct format.
   */
  @javax.xml.bind.annotation.XmlEnumValue ( "JSON_SEMATIC" )
  JSON_SEMATIC("JSON_SEMATIC"),

  /**
   *  JSON field "userName" is not correct.
   *  <br>
   *  Please consult Configuration setting: USERNAME_PATTERN 
   */
  @javax.xml.bind.annotation.XmlEnumValue ( "JSON_FIELD_USERNAME" )
  JSON_FIELD_USERNAME("JSON_FIELD_USERNAME"),

  /**
   *  JSON field "email" is not correct.
   *  <br>
   *  Email address must pass validation by javax.mail.internet.InternetAddress
   */
  @javax.xml.bind.annotation.XmlEnumValue ( "JSON_FIELD_EMAIL" )
  JSON_FIELD_EMAIL("JSON_FIELD_EMAIL"),

  /**
   *  JSON field "password" is not correct.
   *  <br>
   *  Please consult Configuration setting: PASSWORD_PATTERN 
   */
  @javax.xml.bind.annotation.XmlEnumValue ( "JSON_FIELD_PASSWORD" )
  JSON_FIELD_PASSWORD("JSON_FIELD_PASSWORD"),

  /**
   *  Can not create resource, because it already exists.
   *  <br>
   *  POST another resource or use PUT to edit existing resource.
   */
  @javax.xml.bind.annotation.XmlEnumValue ( "RESOURCE_EXISTS" )
  RESOURCE_EXISTS("RESOURCE_EXISTS"),

  /**
   *  Requested resource was not found.
   *  <br>
   *  Could not find requested resource, maybe you want to POST to create it?
   */
  @javax.xml.bind.annotation.XmlEnumValue ( "RESOURCE_NOT_EXISTS" )
  RESOURCE_NOT_EXISTS("RESOURCE_NOT_EXISTS");

  private final String value;

  private ErrorCode(String value) {
    this.value = value;
  }

  public String toString() {
    return value;
  }

}
