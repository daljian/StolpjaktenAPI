/**
 * 
 *
 * Generated by <a href="http://enunciate.webcohesion.com">Enunciate</a>.
 */
package se.stolpjakten.api.rest.error;

/**
 * 
 *  Payload for unauthorized (403) responses.
 *  <br>
 *  Please see description for details about the specific error.
 */
public class Unauthorized extends se.stolpjakten.api.rest.error.BaseError {

  protected Unauthorized() {
  }

  /**
   * Create an instance of Unauthorized from JSON text.
   */
  public static native Unauthorized fromJson(String json) /*-{
    return eval('(' + json + ')');
  }-*/;
}
