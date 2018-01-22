/**
 * 
 *
 * Generated by <a href="http://enunciate.webcohesion.com">Enunciate</a>.
 */
package se.stolpjakten.api.rest.type;

import com.fasterxml.jackson.annotation.*;

/**
 * 
 *  Key/value container for one configuration entity.
 *  <br>
 *  
 */
@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonIgnoreProperties( ignoreUnknown = true )
public class Configuration implements java.io.Serializable {

  @JsonIgnore
  private java.lang.String _key;
  @JsonIgnore
  private java.lang.String _value;

  /**
   * Configuration key.
   */
  @JsonProperty( value = "key", required = false )
  public java.lang.String getKey() {
    return this._key;
  }

  /**
   * Configuration key.
   */
  @JsonProperty( value = "key", required = false )
  public void setKey(java.lang.String _key) {
    this._key = _key;
  }

  /**
   * Configuration value.
   */
  @JsonProperty( value = "value", required = false )
  public java.lang.String getValue() {
    return this._value;
  }

  /**
   * Configuration value.
   */
  @JsonProperty( value = "value", required = false )
  public void setValue(java.lang.String _value) {
    this._value = _value;
  }
}
