/**
 * 
 *
 * Generated by <a href="http://enunciate.webcohesion.com">Enunciate</a>.
 */
package se.stolpjakten.api.rest.type;

/**
 * 
 *  Token data container.
 *  
 */
public class Token extends com.google.gwt.core.client.JavaScriptObject {

  protected Token() {
  }

  /**
   * The Bearer access token to be used for token protected endpoints.
   * <br>
   * <b>Note!</b> This property exists only in responses, ignored if present in requests.
   * <br>
   * <br>
   * Required: no
   */
  public final native java.lang.String getAccessToken() /*-{
    return this.accessToken;
  }-*/;

  /**
   * The Bearer access token to be used for token protected endpoints.
   * <br>
   * <b>Note!</b> This property exists only in responses, ignored if present in requests.
   * <br>
   * <br>
   * Required: no
   */
  public final native void setAccessToken(java.lang.String accessToken) /*-{
    this.accessToken = accessToken;
  }-*/;

  /**
   * Type of access token, currently only Bearer tokens are supported.
   * <br><br>
   */
  public final native java.lang.String getType() /*-{
    return this.type;
  }-*/;

  /**
   * Type of access token, currently only Bearer tokens are supported.
   * <br><br>
   */
  public final native void setType(java.lang.String type) /*-{
    this.type = type;
  }-*/;

  /**
   * The seconds left of the token life time.
   * <br>
   * Expired tokens are automatically rinsed.
   * 
   * <br><br>
   */
  public final native Long getExpire() /*-{
    return (this.expire == null ? null : @java.lang.Long::valueOf(Ljava/lang/String;)(this.expire + ''));
  }-*/;

  /**
   * The seconds left of the token life time.
   * <br>
   * Expired tokens are automatically rinsed.
   * 
   * <br><br>
   */
  public final native void setExpire(java.lang.Long expire) /*-{
    this.expire = (expire == null ? null : (+(@java.lang.String::valueOf(Ljava/lang/Object;)(expire))));
  }-*/;

  /**
   * Create an instance of Token from JSON text.
   */
  public static native Token fromJson(String json) /*-{
    return eval('(' + json + ')');
  }-*/;
}
