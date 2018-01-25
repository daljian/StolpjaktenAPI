// <auto-generated>
// 
//
// Generated by <a href="http://enunciate.webcohesion.com">Enunciate</a>.
// </auto-generated>
using System;

namespace Se.Stolpjakten.Api.Rest.Error {

  /// <remarks>
  ///  (no documentation provided)
  /// </remarks>
  /// <summary>
  ///  (no documentation provided)
  /// </summary>
  [System.SerializableAttribute()]
  [System.Xml.Serialization.XmlTypeAttribute(Namespace="",TypeName="badRequest")]
  [System.Xml.Serialization.SoapTypeAttribute(TypeName="badRequest")]
  [System.Xml.Serialization.XmlRootAttribute(Namespace="",ElementName="badRequest")]
  public partial class BadRequest : Se.Stolpjakten.Api.Rest.Error.BaseError {

    private Se.Stolpjakten.Api.Rest.Error.ErrorCode _errorCode;
    /// <summary>
    ///  (no documentation provided)
    /// </summary>
    [System.Xml.Serialization.XmlElementAttribute(ElementName="errorCode",Namespace="")]
    [System.Xml.Serialization.SoapElementAttribute(ElementName="errorCode")]
    public Se.Stolpjakten.Api.Rest.Error.ErrorCode ErrorCode {
      get {
        return this._errorCode;
      }
      set {
        this._errorCode = value;
      }
    }

    /// <summary>
    ///  Property for the XML serializer indicating whether the "ErrorCode" property should be included in the output.
    /// </summary>
    [System.Xml.Serialization.XmlIgnoreAttribute]
    [System.Xml.Serialization.SoapIgnoreAttribute]
    [System.ComponentModel.EditorBrowsable(System.ComponentModel.EditorBrowsableState.Never)]
    public bool ErrorCodeSpecified {
      get {
        return this._errorCode != Se.Stolpjakten.Api.Rest.Error.ErrorCode.NULL;
      }
      set {
        if (!value) {
          this._errorCode = Se.Stolpjakten.Api.Rest.Error.ErrorCode.NULL;
        }
      }
    }
  }
}  
namespace Se.Stolpjakten.Api.Rest.Error {

  /// <remarks>
  ///  (no documentation provided)
  /// </remarks>
  /// <summary>
  ///  (no documentation provided)
  /// </summary>
  [System.SerializableAttribute()]
  [System.Xml.Serialization.XmlTypeAttribute(Namespace="",TypeName="baseError")]
  [System.Xml.Serialization.SoapTypeAttribute(TypeName="baseError")]
  [System.Xml.Serialization.XmlRootAttribute(Namespace="",ElementName="baseError")]
  public abstract partial class BaseError {

    private string _description;
    /// <summary>
    ///  (no documentation provided)
    /// </summary>
    [System.Xml.Serialization.XmlElementAttribute(ElementName="description",Namespace="")]
    [System.Xml.Serialization.SoapElementAttribute(ElementName="description")]
    public string Description {
      get {
        return this._description;
      }
      set {
        this._description = value;
      }
    }
  }
}  
namespace Se.Stolpjakten.Api.Rest.Error {

  /// <remarks>
  ///  (no documentation provided)
  /// </remarks>
  /// <summary>
  ///  (no documentation provided)
  /// </summary>
  [System.Xml.Serialization.XmlRootAttribute(Namespace="", ElementName="errorCode")]
  public enum ErrorCode {

    /// <summary>
    ///  Unspecified enum value.
    /// </summary>
    [System.Xml.Serialization.XmlEnumAttribute(Name="__NULL__")]
    [System.Xml.Serialization.SoapEnumAttribute(Name="__NULL__")]
    NULL,

    /// <summary>
    ///   JSON is not syntactically  correct.
    ///   &lt;br&gt;
    ///   Please make sure to use JSON lib to create your payload.
    /// </summary>
    [System.Xml.Serialization.XmlEnumAttribute(Name="JSON_SYNTAX")]
    [System.Xml.Serialization.SoapEnumAttribute(Name="JSON_SYNTAX")]
      JSON_SYNTAX,

    /// <summary>
    ///   JSON is not semantically correct.
    ///   &lt;br&gt;
    ///   Please consult API documentation to assert you follow the correct format.
    /// </summary>
    [System.Xml.Serialization.XmlEnumAttribute(Name="JSON_SEMATIC")]
    [System.Xml.Serialization.SoapEnumAttribute(Name="JSON_SEMATIC")]
      JSON_SEMATIC,

    /// <summary>
    ///   JSON field &quot;userName&quot; is not correct.
    ///   &lt;br&gt;
    ///   Please consult Configuration setting: USERNAME_PATTERN 
    /// </summary>
    [System.Xml.Serialization.XmlEnumAttribute(Name="JSON_FIELD_USERNAME")]
    [System.Xml.Serialization.SoapEnumAttribute(Name="JSON_FIELD_USERNAME")]
      JSON_FIELD_USERNAME,

    /// <summary>
    ///   JSON field &quot;email&quot; is not correct.
    ///   &lt;br&gt;
    ///   Email address must pass validation by javax.mail.internet.InternetAddress
    /// </summary>
    [System.Xml.Serialization.XmlEnumAttribute(Name="JSON_FIELD_EMAIL")]
    [System.Xml.Serialization.SoapEnumAttribute(Name="JSON_FIELD_EMAIL")]
      JSON_FIELD_EMAIL,

    /// <summary>
    ///   JSON field &quot;password&quot; is not correct.
    ///   &lt;br&gt;
    ///   Please consult Configuration setting: PASSWORD_PATTERN 
    /// </summary>
    [System.Xml.Serialization.XmlEnumAttribute(Name="JSON_FIELD_PASSWORD")]
    [System.Xml.Serialization.SoapEnumAttribute(Name="JSON_FIELD_PASSWORD")]
      JSON_FIELD_PASSWORD,

    /// <summary>
    ///   Can not create resource, because it already exists.
    ///   &lt;br&gt;
    ///   POST another resource or use PUT to edit existing resource.
    /// </summary>
    [System.Xml.Serialization.XmlEnumAttribute(Name="RESOURCE_EXISTS")]
    [System.Xml.Serialization.SoapEnumAttribute(Name="RESOURCE_EXISTS")]
      RESOURCE_EXISTS,

    /// <summary>
    ///   Requested resource was not found.
    ///   &lt;br&gt;
    ///   Could not find requested resource, maybe you want to POST to create it?
    /// </summary>
    [System.Xml.Serialization.XmlEnumAttribute(Name="RESOURCE_NOT_EXISTS")]
    [System.Xml.Serialization.SoapEnumAttribute(Name="RESOURCE_NOT_EXISTS")]
      RESOURCE_NOT_EXISTS
  }

}
namespace Se.Stolpjakten.Api.Rest.Error {

  /// <remarks>
  ///  (no documentation provided)
  /// </remarks>
  /// <summary>
  ///  (no documentation provided)
  /// </summary>
  [System.SerializableAttribute()]
  [System.Xml.Serialization.XmlTypeAttribute(Namespace="",TypeName="forbidden")]
  [System.Xml.Serialization.SoapTypeAttribute(TypeName="forbidden")]
  [System.Xml.Serialization.XmlRootAttribute(Namespace="",ElementName="forbidden")]
  public partial class Forbidden : Se.Stolpjakten.Api.Rest.Error.BaseError {

  }
}  
namespace Se.Stolpjakten.Api.Rest.Error {

  /// <remarks>
  ///  (no documentation provided)
  /// </remarks>
  /// <summary>
  ///  (no documentation provided)
  /// </summary>
  [System.SerializableAttribute()]
  [System.Xml.Serialization.XmlTypeAttribute(Namespace="",TypeName="internalServerError")]
  [System.Xml.Serialization.SoapTypeAttribute(TypeName="internalServerError")]
  [System.Xml.Serialization.XmlRootAttribute(Namespace="",ElementName="serverError")]
  public partial class InternalServerError : Se.Stolpjakten.Api.Rest.Error.BaseError {

    private string _identifier;
    /// <summary>
    ///  (no documentation provided)
    /// </summary>
    [System.Xml.Serialization.XmlElementAttribute(ElementName="identifier",Namespace="")]
    [System.Xml.Serialization.SoapElementAttribute(ElementName="identifier")]
    public string Identifier {
      get {
        return this._identifier;
      }
      set {
        this._identifier = value;
      }
    }
  }
}  
namespace Se.Stolpjakten.Api.Rest.Error {

  /// <remarks>
  ///  (no documentation provided)
  /// </remarks>
  /// <summary>
  ///  (no documentation provided)
  /// </summary>
  [System.SerializableAttribute()]
  [System.Xml.Serialization.XmlTypeAttribute(Namespace="",TypeName="notFound")]
  [System.Xml.Serialization.SoapTypeAttribute(TypeName="notFound")]
  [System.Xml.Serialization.XmlRootAttribute(Namespace="",ElementName="notFound")]
  public partial class NotFound : Se.Stolpjakten.Api.Rest.Error.BaseError {

  }
}  
namespace Se.Stolpjakten.Api.Rest.Error {

  /// <remarks>
  ///  (no documentation provided)
  /// </remarks>
  /// <summary>
  ///  (no documentation provided)
  /// </summary>
  [System.SerializableAttribute()]
  [System.Xml.Serialization.XmlTypeAttribute(Namespace="",TypeName="unauthorized")]
  [System.Xml.Serialization.SoapTypeAttribute(TypeName="unauthorized")]
  [System.Xml.Serialization.XmlRootAttribute(Namespace="",ElementName="unauthorized")]
  public partial class Unauthorized : Se.Stolpjakten.Api.Rest.Error.BaseError {

  }
}  
