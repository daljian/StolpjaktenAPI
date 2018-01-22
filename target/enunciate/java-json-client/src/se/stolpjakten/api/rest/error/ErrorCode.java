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
public enum ErrorCode {

  /**
   *  JSON is not syntactically  correct.
   *  <br>
   *  Please make sure to use JSON lib to create your payload.
   */
  JSON_SYNTAX,

  /**
   *  JSON is not semantically correct.
   *  <br>
   *  Please consult API documentation to assert you follow the correct format.
   */
  JSON_SEMATIC,

  /**
   *  JSON field "userName" is not correct.
   *  <br>
   *  Please consult Configuration setting: USERNAME_PATTERN 
   */
  JSON_FIELD_USERNAME,

  /**
   *  JSON field "email" is not correct.
   *  <br>
   *  Email address must pass validation by javax.mail.internet.InternetAddress
   */
  JSON_FIELD_EMAIL,

  /**
   *  JSON field "password" is not correct.
   *  <br>
   *  Please consult Configuration setting: PASSWORD_PATTERN 
   */
  JSON_FIELD_PASSWORD,

  /**
   *  Can not create resource, because it already exists.
   *  <br>
   *  POST another resource or use PUT to edit existing resource.
   */
  RESOURCE_EXISTS,

  /**
   *  Requested resource was not found.
   *  <br>
   *  Could not find requested resource, maybe you want to POST to create it?
   */
  RESOURCE_NOT_EXISTS;
}