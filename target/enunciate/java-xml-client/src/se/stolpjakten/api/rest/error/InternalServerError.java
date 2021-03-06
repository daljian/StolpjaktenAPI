/**
 * 
 *
 * Generated by <a href="http://enunciate.webcohesion.com">Enunciate</a>.
 */
package se.stolpjakten.api.rest.error;

/**
 * 
 *  Payload for internal server error (500) responses.
 *  <br>
 *  When an unforseen error happens, this payload will be generated.
 *  <br>
 *  Should you file a bug report for receiving this error please do so here:
 *  <br>
 *  https://github.com/daljian/StolpjaktenAPI/issues
 *  <br>
 *  Please include the identifier as a minimum, and if you know how to reproduce
 *  the error, please also provide the steps to reproduce the error.
 *  <br>
 *  Thanks!
 * 
 * 
 */
@javax.xml.bind.annotation.XmlType (
  name = "internalServerError",
  namespace = ""
)
@javax.xml.bind.annotation.XmlRootElement (
  name = "serverError",
  namespace = ""
)
public class InternalServerError extends se.stolpjakten.api.rest.error.BaseError {

  private java.lang.String _identifier;

  /**
   * (no documentation provided)
   */
  @javax.xml.bind.annotation.XmlElement (
    name = "identifier",
    namespace = ""
  )
  public java.lang.String getIdentifier() {
    return this._identifier;
  }

  /**
   * (no documentation provided)
   */
  public void setIdentifier(java.lang.String _identifier) {
    this._identifier = _identifier;
  }

}
