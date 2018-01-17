/**
 * 
 *
 * Generated by <a href="http://enunciate.webcohesion.com">Enunciate</a>.
 */
package se.stolpjakten.api.db.type;

import com.fasterxml.jackson.annotation.*;

/**
 * 
 *  @author gengdahl
 */
@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonIgnoreProperties( ignoreUnknown = true )
public class Users implements java.io.Serializable {

  @JsonIgnore
  private java.lang.String _userName;
  @JsonIgnore
  private java.lang.String _email;
  @JsonIgnore
  private java.lang.String _password;
  @JsonIgnore
  private int _salt;

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "userName", required = false )
  public java.lang.String getUserName() {
    return this._userName;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "userName", required = false )
  public void setUserName(java.lang.String _userName) {
    this._userName = _userName;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "email", required = false )
  public java.lang.String getEmail() {
    return this._email;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "email", required = false )
  public void setEmail(java.lang.String _email) {
    this._email = _email;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "password", required = false )
  public java.lang.String getPassword() {
    return this._password;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "password", required = false )
  public void setPassword(java.lang.String _password) {
    this._password = _password;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "salt", required = false )
  public int getSalt() {
    return this._salt;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "salt", required = false )
  public void setSalt(int _salt) {
    this._salt = _salt;
  }
}