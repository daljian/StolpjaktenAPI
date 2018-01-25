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
public class InternalServerError extends se.stolpjakten.api.rest.error.BaseError {

  protected InternalServerError() {
  }

  /**
   * 
   */
  public final native java.lang.String getIdentifier() /*-{
    return this.identifier;
  }-*/;

  /**
   * 
   */
  public final native void setIdentifier(java.lang.String identifier) /*-{
    this.identifier = identifier;
  }-*/;

  /**
   * Create an instance of InternalServerError from JSON text.
   */
  public static native InternalServerError fromJson(String json) /*-{
    return eval('(' + json + ')');
  }-*/;
}
