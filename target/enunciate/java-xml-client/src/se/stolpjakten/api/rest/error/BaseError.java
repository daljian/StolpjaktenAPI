/**
 * 
 *
 * Generated by <a href="http://enunciate.webcohesion.com">Enunciate</a>.
 */
package se.stolpjakten.api.rest.error;

/**
 * 
 *  Base class for all errors.
 *  <br>
 *  All errors contains a description text.
 * 
 */
@javax.xml.bind.annotation.XmlType (
  name = "baseError",
  namespace = ""
)
@javax.xml.bind.annotation.XmlRootElement (
  name = "baseError",
  namespace = ""
)
public class BaseError implements java.io.Serializable {

  private java.lang.String _description;

  /**
   * (no documentation provided)
   */
  @javax.xml.bind.annotation.XmlElement (
    name = "description",
    namespace = ""
  )
  public java.lang.String getDescription() {
    return this._description;
  }

  /**
   * (no documentation provided)
   */
  public void setDescription(java.lang.String _description) {
    this._description = _description;
  }

}
