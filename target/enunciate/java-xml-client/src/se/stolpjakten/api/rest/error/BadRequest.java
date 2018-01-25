/**
 * 
 *
 * Generated by <a href="http://enunciate.webcohesion.com">Enunciate</a>.
 */
package se.stolpjakten.api.rest.error;

/**
 * 
 *  Payload for bad request (400) responses.
 *  <br>
 *  Please see error code and description for details about the specific error.
 */
@javax.xml.bind.annotation.XmlType (
  name = "badRequest",
  namespace = ""
)
@javax.xml.bind.annotation.XmlRootElement (
  name = "badRequest",
  namespace = ""
)
public class BadRequest extends se.stolpjakten.api.rest.error.BaseError {

  private se.stolpjakten.api.rest.error.ErrorCode _errorCode;

  /**
   * (no documentation provided)
   */
  @javax.xml.bind.annotation.XmlElement (
    name = "errorCode",
    namespace = ""
  )
  public se.stolpjakten.api.rest.error.ErrorCode getErrorCode() {
    return this._errorCode;
  }

  /**
   * (no documentation provided)
   */
  public void setErrorCode(se.stolpjakten.api.rest.error.ErrorCode _errorCode) {
    this._errorCode = _errorCode;
  }

}