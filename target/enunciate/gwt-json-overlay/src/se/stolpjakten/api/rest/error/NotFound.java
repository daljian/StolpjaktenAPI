/**
 * 
 *
 * Generated by <a href="http://enunciate.webcohesion.com">Enunciate</a>.
 */
package se.stolpjakten.api.rest.error;

/**
 * 
 *  Payload for not found (404) responses.
 *  <br>
 *  Please see description for details about the specific error.
 */
public class NotFound extends se.stolpjakten.api.rest.error.BaseError {

  protected NotFound() {
  }

  /**
   * Create an instance of NotFound from JSON text.
   */
  public static native NotFound fromJson(String json) /*-{
    return eval('(' + json + ')');
  }-*/;
}