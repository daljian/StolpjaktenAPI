/**
 * 
 *
 * Generated by <a href="http://enunciate.webcohesion.com">Enunciate</a>.
 */
package se.stolpjakten.api.rest.error;

/**
 * 
 *  Payload for forbidden (403) responses.
 *  <br>
 *  Please see error code and description for details about the specific error.
 */
public class Forbidden extends se.stolpjakten.api.rest.error.BaseError {

  protected Forbidden() {
  }

  /**
   * Create an instance of Forbidden from JSON text.
   */
  public static native Forbidden fromJson(String json) /*-{
    return eval('(' + json + ')');
  }-*/;
}
