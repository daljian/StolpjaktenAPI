#include <enunciate-common.c>
#ifndef DEF_stolpjaktenAPI_ns0_badRequest_H
#define DEF_stolpjaktenAPI_ns0_badRequest_H

/**
 * 
 *  Payload for bad request (400) responses.
 *  <br>
 *  Please see error code and description for details about the specific error.
 */
struct stolpjaktenAPI_ns0_badRequest {


  /**
   * (no documentation provided)
   */
  xmlChar *description;

  /**
   * (no documentation provided)
   */
  enum stolpjaktenAPI_ns0_errorCode *errorCode;
};

/**
 * Reads a BadRequest element from XML. The element to be read is "badRequest", and
 * it is assumed that the reader is pointing to the XML document (not the element).
 *
 * @param reader The XML reader.
 * @return The BadRequest, or NULL in case of error.
 */
struct stolpjaktenAPI_ns0_badRequest *xml_read_stolpjaktenAPI_ns0_badRequest(xmlTextReaderPtr reader);

/**
 * Writes a BadRequest to XML under element name "badRequest".
 *
 * @param writer The XML writer.
 * @param _badRequest The BadRequest to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
int xml_write_stolpjaktenAPI_ns0_badRequest(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_badRequest *_badRequest);

/**
 * Frees a BadRequest.
 *
 * @param _badRequest The BadRequest to free.
 */
void free_stolpjaktenAPI_ns0_badRequest(struct stolpjaktenAPI_ns0_badRequest *_badRequest);

/**
 * Reads a BadRequest element from XML. The element to be read is "badRequest", and
 * it is assumed that the reader is already pointing to the element.
 *
 * @param reader The XML reader.
 * @return The BadRequest, or NULL in case of error.
 */
struct stolpjaktenAPI_ns0_badRequest *xmlTextReaderReadNs0BadRequestElement(xmlTextReaderPtr reader);

/**
 * Writes a BadRequest to XML under element name "badRequest".
 * Does NOT write the namespace prefixes.
 *
 * @param writer The XML writer.
 * @param _badRequest The BadRequest to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs0BadRequestElement(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_badRequest *_badRequest);

/**
 * Writes a BadRequest to XML under element name "badRequest".
 *
 * @param writer The XML writer.
 * @param _badRequest The BadRequest to write.
 * @param writeNamespaces Whether to write the namespace prefixes.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs0BadRequestElementNS(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_badRequest *_badRequest, int writeNamespaces);

/**
 * Frees the children of a BadRequest.
 *
 * @param _badRequest The BadRequest whose children are to be free.
 */
static void freeNs0BadRequestElement(struct stolpjaktenAPI_ns0_badRequest *_badRequest);

/**
 * Reads a BadRequest from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The BadRequest, or NULL in case of error.
 */
static struct stolpjaktenAPI_ns0_badRequest *xmlTextReaderReadNs0BadRequestType(xmlTextReaderPtr reader);

/**
 * Writes a BadRequest to XML.
 *
 * @param writer The XML writer.
 * @param _badRequest The BadRequest to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs0BadRequestType(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_badRequest *_badRequest);

/**
 * Frees the elements of a BadRequest.
 *
 * @param _badRequest The BadRequest to free.
 */
static void freeNs0BadRequestType(struct stolpjaktenAPI_ns0_badRequest *_badRequest);

#endif /* DEF_stolpjaktenAPI_ns0_badRequest_H */
#ifndef DEF_stolpjaktenAPI_ns0_errorCode_H
#define DEF_stolpjaktenAPI_ns0_errorCode_H

/**
 * 
 *  Enumeration of error codes that can occur in BadRequest responses.
 */
enum stolpjaktenAPI_ns0_errorCode {

  /**
   *  JSON is not syntactically  correct.
   *  <br>
   *  Please make sure to use JSON lib to create your payload.
   */
  STOLPJAKTENAPI_NS0_ERRORCODE_JSON_SYNTAX,

  /**
   *  JSON is not semantically correct.
   *  <br>
   *  Please consult API documentation to assert you follow the correct format.
   */
  STOLPJAKTENAPI_NS0_ERRORCODE_JSON_SEMATIC,

  /**
   *  JSON field "userName" is not correct.
   *  <br>
   *  Please consult Configuration setting: USERNAME_PATTERN 
   */
  STOLPJAKTENAPI_NS0_ERRORCODE_JSON_FIELD_USERNAME,

  /**
   *  JSON field "email" is not correct.
   *  <br>
   *  Email address must pass validation by javax.mail.internet.InternetAddress
   */
  STOLPJAKTENAPI_NS0_ERRORCODE_JSON_FIELD_EMAIL,

  /**
   *  JSON field "password" is not correct.
   *  <br>
   *  Please consult Configuration setting: PASSWORD_PATTERN 
   */
  STOLPJAKTENAPI_NS0_ERRORCODE_JSON_FIELD_PASSWORD,

  /**
   *  Can not create resource, because it already exists.
   *  <br>
   *  POST another resource or use PUT to edit existing resource.
   */
  STOLPJAKTENAPI_NS0_ERRORCODE_RESOURCE_EXISTS,

  /**
   *  Requested resource was not found.
   *  <br>
   *  Could not find requested resource, maybe you want to POST to create it?
   */
  STOLPJAKTENAPI_NS0_ERRORCODE_RESOURCE_NOT_EXISTS
};

/**
 * Reads a ErrorCode from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The ErrorCode, or NULL if unable to be read.
 */
static enum stolpjaktenAPI_ns0_errorCode *xmlTextReaderReadNs0ErrorCodeType(xmlTextReaderPtr reader);

/**
 * Writes a ErrorCode to XML.
 *
 * @param writer The XML writer.
 * @param _errorCode The ErrorCode to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs0ErrorCodeType(xmlTextWriterPtr writer, enum stolpjaktenAPI_ns0_errorCode *_errorCode);

/**
 * Frees a ErrorCode.
 *
 * @param _errorCode The ErrorCode to free.
 */
static void freeNs0ErrorCodeType(enum stolpjaktenAPI_ns0_errorCode *_errorCode);

#endif
#ifndef DEF_stolpjaktenAPI_ns0_forbidden_H
#define DEF_stolpjaktenAPI_ns0_forbidden_H

/**
 * 
 *  Payload for forbidden (403) responses.
 *  <br>
 *  Please see error code and description for details about the specific error.
 */
struct stolpjaktenAPI_ns0_forbidden {


  /**
   * (no documentation provided)
   */
  xmlChar *description;
};

/**
 * Reads a Forbidden element from XML. The element to be read is "forbidden", and
 * it is assumed that the reader is pointing to the XML document (not the element).
 *
 * @param reader The XML reader.
 * @return The Forbidden, or NULL in case of error.
 */
struct stolpjaktenAPI_ns0_forbidden *xml_read_stolpjaktenAPI_ns0_forbidden(xmlTextReaderPtr reader);

/**
 * Writes a Forbidden to XML under element name "forbidden".
 *
 * @param writer The XML writer.
 * @param _forbidden The Forbidden to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
int xml_write_stolpjaktenAPI_ns0_forbidden(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_forbidden *_forbidden);

/**
 * Frees a Forbidden.
 *
 * @param _forbidden The Forbidden to free.
 */
void free_stolpjaktenAPI_ns0_forbidden(struct stolpjaktenAPI_ns0_forbidden *_forbidden);

/**
 * Reads a Forbidden element from XML. The element to be read is "forbidden", and
 * it is assumed that the reader is already pointing to the element.
 *
 * @param reader The XML reader.
 * @return The Forbidden, or NULL in case of error.
 */
struct stolpjaktenAPI_ns0_forbidden *xmlTextReaderReadNs0ForbiddenElement(xmlTextReaderPtr reader);

/**
 * Writes a Forbidden to XML under element name "forbidden".
 * Does NOT write the namespace prefixes.
 *
 * @param writer The XML writer.
 * @param _forbidden The Forbidden to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs0ForbiddenElement(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_forbidden *_forbidden);

/**
 * Writes a Forbidden to XML under element name "forbidden".
 *
 * @param writer The XML writer.
 * @param _forbidden The Forbidden to write.
 * @param writeNamespaces Whether to write the namespace prefixes.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs0ForbiddenElementNS(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_forbidden *_forbidden, int writeNamespaces);

/**
 * Frees the children of a Forbidden.
 *
 * @param _forbidden The Forbidden whose children are to be free.
 */
static void freeNs0ForbiddenElement(struct stolpjaktenAPI_ns0_forbidden *_forbidden);

/**
 * Reads a Forbidden from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The Forbidden, or NULL in case of error.
 */
static struct stolpjaktenAPI_ns0_forbidden *xmlTextReaderReadNs0ForbiddenType(xmlTextReaderPtr reader);

/**
 * Writes a Forbidden to XML.
 *
 * @param writer The XML writer.
 * @param _forbidden The Forbidden to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs0ForbiddenType(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_forbidden *_forbidden);

/**
 * Frees the elements of a Forbidden.
 *
 * @param _forbidden The Forbidden to free.
 */
static void freeNs0ForbiddenType(struct stolpjaktenAPI_ns0_forbidden *_forbidden);

#endif /* DEF_stolpjaktenAPI_ns0_forbidden_H */
#ifndef DEF_stolpjaktenAPI_ns0_internalServerError_H
#define DEF_stolpjaktenAPI_ns0_internalServerError_H

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
struct stolpjaktenAPI_ns0_internalServerError {


  /**
   * (no documentation provided)
   */
  xmlChar *description;

  /**
   * (no documentation provided)
   */
  xmlChar *identifier;
};

/**
 * Reads a InternalServerError element from XML. The element to be read is "serverError", and
 * it is assumed that the reader is pointing to the XML document (not the element).
 *
 * @param reader The XML reader.
 * @return The InternalServerError, or NULL in case of error.
 */
struct stolpjaktenAPI_ns0_internalServerError *xml_read_stolpjaktenAPI_ns0_internalServerError(xmlTextReaderPtr reader);

/**
 * Writes a InternalServerError to XML under element name "serverError".
 *
 * @param writer The XML writer.
 * @param _internalServerError The InternalServerError to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
int xml_write_stolpjaktenAPI_ns0_internalServerError(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_internalServerError *_internalServerError);

/**
 * Frees a InternalServerError.
 *
 * @param _internalServerError The InternalServerError to free.
 */
void free_stolpjaktenAPI_ns0_internalServerError(struct stolpjaktenAPI_ns0_internalServerError *_internalServerError);

/**
 * Reads a InternalServerError element from XML. The element to be read is "serverError", and
 * it is assumed that the reader is already pointing to the element.
 *
 * @param reader The XML reader.
 * @return The InternalServerError, or NULL in case of error.
 */
struct stolpjaktenAPI_ns0_internalServerError *xmlTextReaderReadNs0ServerErrorElement(xmlTextReaderPtr reader);

/**
 * Writes a InternalServerError to XML under element name "serverError".
 * Does NOT write the namespace prefixes.
 *
 * @param writer The XML writer.
 * @param _internalServerError The InternalServerError to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs0ServerErrorElement(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_internalServerError *_internalServerError);

/**
 * Writes a InternalServerError to XML under element name "serverError".
 *
 * @param writer The XML writer.
 * @param _internalServerError The InternalServerError to write.
 * @param writeNamespaces Whether to write the namespace prefixes.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs0ServerErrorElementNS(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_internalServerError *_internalServerError, int writeNamespaces);

/**
 * Frees the children of a InternalServerError.
 *
 * @param _internalServerError The InternalServerError whose children are to be free.
 */
static void freeNs0ServerErrorElement(struct stolpjaktenAPI_ns0_internalServerError *_internalServerError);

/**
 * Reads a InternalServerError from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The InternalServerError, or NULL in case of error.
 */
static struct stolpjaktenAPI_ns0_internalServerError *xmlTextReaderReadNs0InternalServerErrorType(xmlTextReaderPtr reader);

/**
 * Writes a InternalServerError to XML.
 *
 * @param writer The XML writer.
 * @param _internalServerError The InternalServerError to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs0InternalServerErrorType(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_internalServerError *_internalServerError);

/**
 * Frees the elements of a InternalServerError.
 *
 * @param _internalServerError The InternalServerError to free.
 */
static void freeNs0InternalServerErrorType(struct stolpjaktenAPI_ns0_internalServerError *_internalServerError);

#endif /* DEF_stolpjaktenAPI_ns0_internalServerError_H */
#ifndef DEF_stolpjaktenAPI_ns0_notFound_H
#define DEF_stolpjaktenAPI_ns0_notFound_H

/**
 * 
 *  Payload for not found (404) responses.
 *  <br>
 *  Please see description for details about the specific error.
 */
struct stolpjaktenAPI_ns0_notFound {


  /**
   * (no documentation provided)
   */
  xmlChar *description;
};

/**
 * Reads a NotFound element from XML. The element to be read is "notFound", and
 * it is assumed that the reader is pointing to the XML document (not the element).
 *
 * @param reader The XML reader.
 * @return The NotFound, or NULL in case of error.
 */
struct stolpjaktenAPI_ns0_notFound *xml_read_stolpjaktenAPI_ns0_notFound(xmlTextReaderPtr reader);

/**
 * Writes a NotFound to XML under element name "notFound".
 *
 * @param writer The XML writer.
 * @param _notFound The NotFound to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
int xml_write_stolpjaktenAPI_ns0_notFound(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_notFound *_notFound);

/**
 * Frees a NotFound.
 *
 * @param _notFound The NotFound to free.
 */
void free_stolpjaktenAPI_ns0_notFound(struct stolpjaktenAPI_ns0_notFound *_notFound);

/**
 * Reads a NotFound element from XML. The element to be read is "notFound", and
 * it is assumed that the reader is already pointing to the element.
 *
 * @param reader The XML reader.
 * @return The NotFound, or NULL in case of error.
 */
struct stolpjaktenAPI_ns0_notFound *xmlTextReaderReadNs0NotFoundElement(xmlTextReaderPtr reader);

/**
 * Writes a NotFound to XML under element name "notFound".
 * Does NOT write the namespace prefixes.
 *
 * @param writer The XML writer.
 * @param _notFound The NotFound to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs0NotFoundElement(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_notFound *_notFound);

/**
 * Writes a NotFound to XML under element name "notFound".
 *
 * @param writer The XML writer.
 * @param _notFound The NotFound to write.
 * @param writeNamespaces Whether to write the namespace prefixes.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs0NotFoundElementNS(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_notFound *_notFound, int writeNamespaces);

/**
 * Frees the children of a NotFound.
 *
 * @param _notFound The NotFound whose children are to be free.
 */
static void freeNs0NotFoundElement(struct stolpjaktenAPI_ns0_notFound *_notFound);

/**
 * Reads a NotFound from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The NotFound, or NULL in case of error.
 */
static struct stolpjaktenAPI_ns0_notFound *xmlTextReaderReadNs0NotFoundType(xmlTextReaderPtr reader);

/**
 * Writes a NotFound to XML.
 *
 * @param writer The XML writer.
 * @param _notFound The NotFound to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs0NotFoundType(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_notFound *_notFound);

/**
 * Frees the elements of a NotFound.
 *
 * @param _notFound The NotFound to free.
 */
static void freeNs0NotFoundType(struct stolpjaktenAPI_ns0_notFound *_notFound);

#endif /* DEF_stolpjaktenAPI_ns0_notFound_H */
#ifndef DEF_stolpjaktenAPI_ns0_unauthorized_H
#define DEF_stolpjaktenAPI_ns0_unauthorized_H

/**
 * 
 *  Payload for unauthorized (401) responses.
 *  <br>
 *  Please see description for details about the specific error.
 */
struct stolpjaktenAPI_ns0_unauthorized {


  /**
   * (no documentation provided)
   */
  xmlChar *description;
};

/**
 * Reads a Unauthorized element from XML. The element to be read is "unauthorized", and
 * it is assumed that the reader is pointing to the XML document (not the element).
 *
 * @param reader The XML reader.
 * @return The Unauthorized, or NULL in case of error.
 */
struct stolpjaktenAPI_ns0_unauthorized *xml_read_stolpjaktenAPI_ns0_unauthorized(xmlTextReaderPtr reader);

/**
 * Writes a Unauthorized to XML under element name "unauthorized".
 *
 * @param writer The XML writer.
 * @param _unauthorized The Unauthorized to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
int xml_write_stolpjaktenAPI_ns0_unauthorized(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_unauthorized *_unauthorized);

/**
 * Frees a Unauthorized.
 *
 * @param _unauthorized The Unauthorized to free.
 */
void free_stolpjaktenAPI_ns0_unauthorized(struct stolpjaktenAPI_ns0_unauthorized *_unauthorized);

/**
 * Reads a Unauthorized element from XML. The element to be read is "unauthorized", and
 * it is assumed that the reader is already pointing to the element.
 *
 * @param reader The XML reader.
 * @return The Unauthorized, or NULL in case of error.
 */
struct stolpjaktenAPI_ns0_unauthorized *xmlTextReaderReadNs0UnauthorizedElement(xmlTextReaderPtr reader);

/**
 * Writes a Unauthorized to XML under element name "unauthorized".
 * Does NOT write the namespace prefixes.
 *
 * @param writer The XML writer.
 * @param _unauthorized The Unauthorized to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs0UnauthorizedElement(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_unauthorized *_unauthorized);

/**
 * Writes a Unauthorized to XML under element name "unauthorized".
 *
 * @param writer The XML writer.
 * @param _unauthorized The Unauthorized to write.
 * @param writeNamespaces Whether to write the namespace prefixes.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs0UnauthorizedElementNS(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_unauthorized *_unauthorized, int writeNamespaces);

/**
 * Frees the children of a Unauthorized.
 *
 * @param _unauthorized The Unauthorized whose children are to be free.
 */
static void freeNs0UnauthorizedElement(struct stolpjaktenAPI_ns0_unauthorized *_unauthorized);

/**
 * Reads a Unauthorized from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The Unauthorized, or NULL in case of error.
 */
static struct stolpjaktenAPI_ns0_unauthorized *xmlTextReaderReadNs0UnauthorizedType(xmlTextReaderPtr reader);

/**
 * Writes a Unauthorized to XML.
 *
 * @param writer The XML writer.
 * @param _unauthorized The Unauthorized to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs0UnauthorizedType(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_unauthorized *_unauthorized);

/**
 * Frees the elements of a Unauthorized.
 *
 * @param _unauthorized The Unauthorized to free.
 */
static void freeNs0UnauthorizedType(struct stolpjaktenAPI_ns0_unauthorized *_unauthorized);

#endif /* DEF_stolpjaktenAPI_ns0_unauthorized_H */
#ifndef DEF_stolpjaktenAPI_ns0_badRequest_M
#define DEF_stolpjaktenAPI_ns0_badRequest_M

/**
 * Reads a BadRequest element from XML. The element to be read is "badRequest", and
 * it is assumed that the reader is pointing to the XML document (not the element).
 *
 * @param reader The XML reader.
 * @return The BadRequest, or NULL in case of error.
 */
struct stolpjaktenAPI_ns0_badRequest *xml_read_stolpjaktenAPI_ns0_badRequest(xmlTextReaderPtr reader) {
  int status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
  return xmlTextReaderReadNs0BadRequestElement(reader);
}

/**
 * Writes a BadRequest to XML under element name "badRequest".
 *
 * @param writer The XML writer.
 * @param _badRequest The BadRequest to write.
 * @return 1 if successful, 0 otherwise.
 */
int xml_write_stolpjaktenAPI_ns0_badRequest(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_badRequest *_badRequest) {
  return xmlTextWriterWriteNs0BadRequestElementNS(writer, _badRequest, 1);
}

/**
 * Frees a BadRequest.
 *
 * @param _badRequest The BadRequest to free.
 */
void free_stolpjaktenAPI_ns0_badRequest(struct stolpjaktenAPI_ns0_badRequest *_badRequest) {
  freeNs0BadRequestType(_badRequest);
  free(_badRequest);
}

/**
 * Reads a BadRequest element from XML. The element to be read is "badRequest", and
 * it is assumed that the reader is pointing to that element.
 *
 * @param reader The XML reader.
 * @return The BadRequest, or NULL in case of error.
 */
struct stolpjaktenAPI_ns0_badRequest *xmlTextReaderReadNs0BadRequestElement(xmlTextReaderPtr reader) {
  struct stolpjaktenAPI_ns0_badRequest *_badRequest = NULL;

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "badRequest", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Attempting to read root element {}badRequest.\n");
#endif
    _badRequest = xmlTextReaderReadNs0BadRequestType(reader);
  }
#if DEBUG_ENUNCIATE
  if (_badRequest == NULL) {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      printf("attempt to read {}badRequest failed. current element: {}%s\n",  xmlTextReaderConstLocalName(reader));
    }
    else {
      printf("attempt to read {}badRequest failed. current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader));
    }
  }
#endif

  return _badRequest;
}

/**
 * Writes a BadRequest to XML under element name "badRequest".
 * Does NOT write the namespace prefixes.
 *
 * @param writer The XML writer.
 * @param _badRequest The BadRequest to write.
 * @return 1 if successful, 0 otherwise.
 */
static int xmlTextWriterWriteNs0BadRequestElement(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_badRequest *_badRequest) {
  return xmlTextWriterWriteNs0BadRequestElementNS(writer, _badRequest, 0);
}

/**
 * Writes a BadRequest to XML under element name "badRequest".
 *
 * @param writer The XML writer.
 * @param _badRequest The BadRequest to write.
 * @param writeNamespaces Whether to write the namespace prefixes.
 * @return 1 if successful, 0 otherwise.
 */
static int xmlTextWriterWriteNs0BadRequestElementNS(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_badRequest *_badRequest, int writeNamespaces) {
  int totalBytes = 0;
  int status;

  status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "badRequest", NULL);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to write start element {}badRequest. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

#if DEBUG_ENUNCIATE > 1
  printf("writing type {}badRequest for root element {}badRequest...\n");
#endif
  status = xmlTextWriterWriteNs0BadRequestType(writer, _badRequest);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to write type for start element {}badRequest. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

  status = xmlTextWriterEndElement(writer);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to end element {}badRequest. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

  return totalBytes;
}

/**
 * Frees the children of a BadRequest.
 *
 * @param _badRequest The BadRequest whose children are to be free.
 */
static void freeNs0BadRequestElement(struct stolpjaktenAPI_ns0_badRequest *_badRequest) {
  freeNs0BadRequestType(_badRequest);
}

/**
 * Reads a BadRequest from XML. The reader is assumed to be at the start element.
 *
 * @return the BadRequest, or NULL in case of error.
 */
static struct stolpjaktenAPI_ns0_badRequest *xmlTextReaderReadNs0BadRequestType(xmlTextReaderPtr reader) {
  int status, depth;
  void *_child_accessor;
  struct stolpjaktenAPI_ns0_badRequest *_badRequest = calloc(1, sizeof(struct stolpjaktenAPI_ns0_badRequest));



  if (xmlTextReaderIsEmptyElement(reader) == 0) {
    depth = xmlTextReaderDepth(reader);//track the depth.
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);

    while (xmlTextReaderDepth(reader) > depth) {
      if (status < 1) {
        //panic: XML read error.
#if DEBUG_ENUNCIATE
        printf("Failure to advance to next child element.\n");
#endif
        freeNs0BadRequestType(_badRequest);
        free(_badRequest);
        return NULL;
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "description", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}description of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
        _child_accessor = xmlTextReaderReadXsStringType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}description of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs0BadRequestType(_badRequest);
          free(_badRequest);
          return NULL;
        }

        _badRequest->description = ((xmlChar*)_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "errorCode", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}errorCode of type {}errorCode.\n");
#endif
        _child_accessor = xmlTextReaderReadNs0ErrorCodeType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}errorCode of type {}errorCode.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs0BadRequestType(_badRequest);
          free(_badRequest);
          return NULL;
        }

        _badRequest->errorCode = ((enum stolpjaktenAPI_ns0_errorCode*)_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else {
#if DEBUG_ENUNCIATE > 1
        if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
          printf("unknown child element {}%s for type {}badRequest.  Skipping...\n",  xmlTextReaderConstLocalName(reader));
        }
        else {
          printf("unknown child element {%s}%s for type {}badRequest. Skipping...\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader));
        }
#endif
        status = xmlTextReaderSkipElement(reader);
      }
    }
  }

  return _badRequest;
}

/**
 * Writes a BadRequest to XML.
 *
 * @param writer The XML writer.
 * @param _badRequest The BadRequest to write.
 * @return The total bytes written, or -1 on error;
 */
static int xmlTextWriterWriteNs0BadRequestType(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_badRequest *_badRequest) {
  int status, totalBytes = 0, i;
  xmlChar *binaryData;
  if (_badRequest->description != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "description", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}description. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {http://www.w3.org/2001/XMLSchema}string for element {}description...\n");
#endif
    status = xmlTextWriterWriteXsStringType(writer, (_badRequest->description));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {http://www.w3.org/2001/XMLSchema}string for element {}description. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}description. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }
  if (_badRequest->errorCode != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "errorCode", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}errorCode. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {}errorCode for element {}errorCode...\n");
#endif
    status = xmlTextWriterWriteNs0ErrorCodeType(writer, (_badRequest->errorCode));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {}errorCode for element {}errorCode. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}errorCode. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }

  return totalBytes;
}

/**
 * Frees the elements of a BadRequest.
 *
 * @param _badRequest The BadRequest to free.
 */
static void freeNs0BadRequestType(struct stolpjaktenAPI_ns0_badRequest *_badRequest) {
  int i;
  if (_badRequest->description != NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Freeing type of accessor description of type stolpjaktenAPI_ns0_badRequest...\n");
#endif
    freeXsStringType(_badRequest->description);
#if DEBUG_ENUNCIATE > 1
    printf("Freeing accessor description of type stolpjaktenAPI_ns0_badRequest...\n");
#endif
    free(_badRequest->description);
  }
  if (_badRequest->errorCode != NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Freeing type of accessor errorCode of type stolpjaktenAPI_ns0_badRequest...\n");
#endif
    freeNs0ErrorCodeType(_badRequest->errorCode);
#if DEBUG_ENUNCIATE > 1
    printf("Freeing accessor errorCode of type stolpjaktenAPI_ns0_badRequest...\n");
#endif
    free(_badRequest->errorCode);
  }
}
#endif /* DEF_stolpjaktenAPI_ns0_badRequest_M */
#ifndef DEF_stolpjaktenAPI_ns0_errorCode_M
#define DEF_stolpjaktenAPI_ns0_errorCode_M

/**
 * Reads a ErrorCode from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The ErrorCode, or NULL if unable to be read.
 */
static enum stolpjaktenAPI_ns0_errorCode *xmlTextReaderReadNs0ErrorCodeType(xmlTextReaderPtr reader) {
  xmlChar *enumValue = xmlTextReaderReadEntireNodeValue(reader);
  enum stolpjaktenAPI_ns0_errorCode *value = calloc(1, sizeof(enum stolpjaktenAPI_ns0_errorCode));
  if (enumValue != NULL) {
    if (xmlStrcmp(enumValue, BAD_CAST "JSON_SYNTAX") == 0) {
      *value = STOLPJAKTENAPI_NS0_ERRORCODE_JSON_SYNTAX;
      free(enumValue);
      return value;
    }
    if (xmlStrcmp(enumValue, BAD_CAST "JSON_SEMATIC") == 0) {
      *value = STOLPJAKTENAPI_NS0_ERRORCODE_JSON_SEMATIC;
      free(enumValue);
      return value;
    }
    if (xmlStrcmp(enumValue, BAD_CAST "JSON_FIELD_USERNAME") == 0) {
      *value = STOLPJAKTENAPI_NS0_ERRORCODE_JSON_FIELD_USERNAME;
      free(enumValue);
      return value;
    }
    if (xmlStrcmp(enumValue, BAD_CAST "JSON_FIELD_EMAIL") == 0) {
      *value = STOLPJAKTENAPI_NS0_ERRORCODE_JSON_FIELD_EMAIL;
      free(enumValue);
      return value;
    }
    if (xmlStrcmp(enumValue, BAD_CAST "JSON_FIELD_PASSWORD") == 0) {
      *value = STOLPJAKTENAPI_NS0_ERRORCODE_JSON_FIELD_PASSWORD;
      free(enumValue);
      return value;
    }
    if (xmlStrcmp(enumValue, BAD_CAST "RESOURCE_EXISTS") == 0) {
      *value = STOLPJAKTENAPI_NS0_ERRORCODE_RESOURCE_EXISTS;
      free(enumValue);
      return value;
    }
    if (xmlStrcmp(enumValue, BAD_CAST "RESOURCE_NOT_EXISTS") == 0) {
      *value = STOLPJAKTENAPI_NS0_ERRORCODE_RESOURCE_NOT_EXISTS;
      free(enumValue);
      return value;
    }
#if DEBUG_ENUNCIATE
    printf("Attempt to read enum value failed: %s doesn't match an enum value.\n", enumValue);
#endif
  }
#if DEBUG_ENUNCIATE
  else {
    printf("Attempt to read enum value failed: NULL value.\n");
  }
#endif

  return NULL;
}

/**
 * Writes a ErrorCode to XML.
 *
 * @param writer The XML writer.
 * @param _errorCode The ErrorCode to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs0ErrorCodeType(xmlTextWriterPtr writer, enum stolpjaktenAPI_ns0_errorCode *_errorCode) {
  switch (*_errorCode) {
    case STOLPJAKTENAPI_NS0_ERRORCODE_JSON_SYNTAX:
      return xmlTextWriterWriteString(writer, BAD_CAST "JSON_SYNTAX");
    case STOLPJAKTENAPI_NS0_ERRORCODE_JSON_SEMATIC:
      return xmlTextWriterWriteString(writer, BAD_CAST "JSON_SEMATIC");
    case STOLPJAKTENAPI_NS0_ERRORCODE_JSON_FIELD_USERNAME:
      return xmlTextWriterWriteString(writer, BAD_CAST "JSON_FIELD_USERNAME");
    case STOLPJAKTENAPI_NS0_ERRORCODE_JSON_FIELD_EMAIL:
      return xmlTextWriterWriteString(writer, BAD_CAST "JSON_FIELD_EMAIL");
    case STOLPJAKTENAPI_NS0_ERRORCODE_JSON_FIELD_PASSWORD:
      return xmlTextWriterWriteString(writer, BAD_CAST "JSON_FIELD_PASSWORD");
    case STOLPJAKTENAPI_NS0_ERRORCODE_RESOURCE_EXISTS:
      return xmlTextWriterWriteString(writer, BAD_CAST "RESOURCE_EXISTS");
    case STOLPJAKTENAPI_NS0_ERRORCODE_RESOURCE_NOT_EXISTS:
      return xmlTextWriterWriteString(writer, BAD_CAST "RESOURCE_NOT_EXISTS");
  }

#if DEBUG_ENUNCIATE
  printf("Unable to write enum value (no valid value found).\n");
#endif
  return -1;
}

/**
 * Frees a ErrorCode.
 *
 * @param _errorCode The ErrorCode to free.
 */
static void freeNs0ErrorCodeType(enum stolpjaktenAPI_ns0_errorCode *_errorCode) {
  //no-op
}
#endif /* DEF_stolpjaktenAPI_ns0_errorCode_M */
#ifndef DEF_stolpjaktenAPI_ns0_forbidden_M
#define DEF_stolpjaktenAPI_ns0_forbidden_M

/**
 * Reads a Forbidden element from XML. The element to be read is "forbidden", and
 * it is assumed that the reader is pointing to the XML document (not the element).
 *
 * @param reader The XML reader.
 * @return The Forbidden, or NULL in case of error.
 */
struct stolpjaktenAPI_ns0_forbidden *xml_read_stolpjaktenAPI_ns0_forbidden(xmlTextReaderPtr reader) {
  int status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
  return xmlTextReaderReadNs0ForbiddenElement(reader);
}

/**
 * Writes a Forbidden to XML under element name "forbidden".
 *
 * @param writer The XML writer.
 * @param _forbidden The Forbidden to write.
 * @return 1 if successful, 0 otherwise.
 */
int xml_write_stolpjaktenAPI_ns0_forbidden(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_forbidden *_forbidden) {
  return xmlTextWriterWriteNs0ForbiddenElementNS(writer, _forbidden, 1);
}

/**
 * Frees a Forbidden.
 *
 * @param _forbidden The Forbidden to free.
 */
void free_stolpjaktenAPI_ns0_forbidden(struct stolpjaktenAPI_ns0_forbidden *_forbidden) {
  freeNs0ForbiddenType(_forbidden);
  free(_forbidden);
}

/**
 * Reads a Forbidden element from XML. The element to be read is "forbidden", and
 * it is assumed that the reader is pointing to that element.
 *
 * @param reader The XML reader.
 * @return The Forbidden, or NULL in case of error.
 */
struct stolpjaktenAPI_ns0_forbidden *xmlTextReaderReadNs0ForbiddenElement(xmlTextReaderPtr reader) {
  struct stolpjaktenAPI_ns0_forbidden *_forbidden = NULL;

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "forbidden", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Attempting to read root element {}forbidden.\n");
#endif
    _forbidden = xmlTextReaderReadNs0ForbiddenType(reader);
  }
#if DEBUG_ENUNCIATE
  if (_forbidden == NULL) {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      printf("attempt to read {}forbidden failed. current element: {}%s\n",  xmlTextReaderConstLocalName(reader));
    }
    else {
      printf("attempt to read {}forbidden failed. current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader));
    }
  }
#endif

  return _forbidden;
}

/**
 * Writes a Forbidden to XML under element name "forbidden".
 * Does NOT write the namespace prefixes.
 *
 * @param writer The XML writer.
 * @param _forbidden The Forbidden to write.
 * @return 1 if successful, 0 otherwise.
 */
static int xmlTextWriterWriteNs0ForbiddenElement(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_forbidden *_forbidden) {
  return xmlTextWriterWriteNs0ForbiddenElementNS(writer, _forbidden, 0);
}

/**
 * Writes a Forbidden to XML under element name "forbidden".
 *
 * @param writer The XML writer.
 * @param _forbidden The Forbidden to write.
 * @param writeNamespaces Whether to write the namespace prefixes.
 * @return 1 if successful, 0 otherwise.
 */
static int xmlTextWriterWriteNs0ForbiddenElementNS(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_forbidden *_forbidden, int writeNamespaces) {
  int totalBytes = 0;
  int status;

  status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "forbidden", NULL);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to write start element {}forbidden. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

#if DEBUG_ENUNCIATE > 1
  printf("writing type {}forbidden for root element {}forbidden...\n");
#endif
  status = xmlTextWriterWriteNs0ForbiddenType(writer, _forbidden);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to write type for start element {}forbidden. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

  status = xmlTextWriterEndElement(writer);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to end element {}forbidden. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

  return totalBytes;
}

/**
 * Frees the children of a Forbidden.
 *
 * @param _forbidden The Forbidden whose children are to be free.
 */
static void freeNs0ForbiddenElement(struct stolpjaktenAPI_ns0_forbidden *_forbidden) {
  freeNs0ForbiddenType(_forbidden);
}

/**
 * Reads a Forbidden from XML. The reader is assumed to be at the start element.
 *
 * @return the Forbidden, or NULL in case of error.
 */
static struct stolpjaktenAPI_ns0_forbidden *xmlTextReaderReadNs0ForbiddenType(xmlTextReaderPtr reader) {
  int status, depth;
  void *_child_accessor;
  struct stolpjaktenAPI_ns0_forbidden *_forbidden = calloc(1, sizeof(struct stolpjaktenAPI_ns0_forbidden));



  if (xmlTextReaderIsEmptyElement(reader) == 0) {
    depth = xmlTextReaderDepth(reader);//track the depth.
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);

    while (xmlTextReaderDepth(reader) > depth) {
      if (status < 1) {
        //panic: XML read error.
#if DEBUG_ENUNCIATE
        printf("Failure to advance to next child element.\n");
#endif
        freeNs0ForbiddenType(_forbidden);
        free(_forbidden);
        return NULL;
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "description", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}description of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
        _child_accessor = xmlTextReaderReadXsStringType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}description of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs0ForbiddenType(_forbidden);
          free(_forbidden);
          return NULL;
        }

        _forbidden->description = ((xmlChar*)_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else {
#if DEBUG_ENUNCIATE > 1
        if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
          printf("unknown child element {}%s for type {}forbidden.  Skipping...\n",  xmlTextReaderConstLocalName(reader));
        }
        else {
          printf("unknown child element {%s}%s for type {}forbidden. Skipping...\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader));
        }
#endif
        status = xmlTextReaderSkipElement(reader);
      }
    }
  }

  return _forbidden;
}

/**
 * Writes a Forbidden to XML.
 *
 * @param writer The XML writer.
 * @param _forbidden The Forbidden to write.
 * @return The total bytes written, or -1 on error;
 */
static int xmlTextWriterWriteNs0ForbiddenType(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_forbidden *_forbidden) {
  int status, totalBytes = 0, i;
  xmlChar *binaryData;
  if (_forbidden->description != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "description", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}description. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {http://www.w3.org/2001/XMLSchema}string for element {}description...\n");
#endif
    status = xmlTextWriterWriteXsStringType(writer, (_forbidden->description));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {http://www.w3.org/2001/XMLSchema}string for element {}description. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}description. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }

  return totalBytes;
}

/**
 * Frees the elements of a Forbidden.
 *
 * @param _forbidden The Forbidden to free.
 */
static void freeNs0ForbiddenType(struct stolpjaktenAPI_ns0_forbidden *_forbidden) {
  int i;
  if (_forbidden->description != NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Freeing type of accessor description of type stolpjaktenAPI_ns0_forbidden...\n");
#endif
    freeXsStringType(_forbidden->description);
#if DEBUG_ENUNCIATE > 1
    printf("Freeing accessor description of type stolpjaktenAPI_ns0_forbidden...\n");
#endif
    free(_forbidden->description);
  }
}
#endif /* DEF_stolpjaktenAPI_ns0_forbidden_M */
#ifndef DEF_stolpjaktenAPI_ns0_internalServerError_M
#define DEF_stolpjaktenAPI_ns0_internalServerError_M

/**
 * Reads a InternalServerError element from XML. The element to be read is "serverError", and
 * it is assumed that the reader is pointing to the XML document (not the element).
 *
 * @param reader The XML reader.
 * @return The InternalServerError, or NULL in case of error.
 */
struct stolpjaktenAPI_ns0_internalServerError *xml_read_stolpjaktenAPI_ns0_internalServerError(xmlTextReaderPtr reader) {
  int status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
  return xmlTextReaderReadNs0ServerErrorElement(reader);
}

/**
 * Writes a InternalServerError to XML under element name "serverError".
 *
 * @param writer The XML writer.
 * @param _internalServerError The InternalServerError to write.
 * @return 1 if successful, 0 otherwise.
 */
int xml_write_stolpjaktenAPI_ns0_internalServerError(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_internalServerError *_internalServerError) {
  return xmlTextWriterWriteNs0ServerErrorElementNS(writer, _internalServerError, 1);
}

/**
 * Frees a InternalServerError.
 *
 * @param _internalServerError The InternalServerError to free.
 */
void free_stolpjaktenAPI_ns0_internalServerError(struct stolpjaktenAPI_ns0_internalServerError *_internalServerError) {
  freeNs0InternalServerErrorType(_internalServerError);
  free(_internalServerError);
}

/**
 * Reads a InternalServerError element from XML. The element to be read is "serverError", and
 * it is assumed that the reader is pointing to that element.
 *
 * @param reader The XML reader.
 * @return The InternalServerError, or NULL in case of error.
 */
struct stolpjaktenAPI_ns0_internalServerError *xmlTextReaderReadNs0ServerErrorElement(xmlTextReaderPtr reader) {
  struct stolpjaktenAPI_ns0_internalServerError *_internalServerError = NULL;

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "serverError", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Attempting to read root element {}serverError.\n");
#endif
    _internalServerError = xmlTextReaderReadNs0InternalServerErrorType(reader);
  }
#if DEBUG_ENUNCIATE
  if (_internalServerError == NULL) {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      printf("attempt to read {}serverError failed. current element: {}%s\n",  xmlTextReaderConstLocalName(reader));
    }
    else {
      printf("attempt to read {}serverError failed. current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader));
    }
  }
#endif

  return _internalServerError;
}

/**
 * Writes a InternalServerError to XML under element name "serverError".
 * Does NOT write the namespace prefixes.
 *
 * @param writer The XML writer.
 * @param _internalServerError The InternalServerError to write.
 * @return 1 if successful, 0 otherwise.
 */
static int xmlTextWriterWriteNs0ServerErrorElement(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_internalServerError *_internalServerError) {
  return xmlTextWriterWriteNs0ServerErrorElementNS(writer, _internalServerError, 0);
}

/**
 * Writes a InternalServerError to XML under element name "serverError".
 *
 * @param writer The XML writer.
 * @param _internalServerError The InternalServerError to write.
 * @param writeNamespaces Whether to write the namespace prefixes.
 * @return 1 if successful, 0 otherwise.
 */
static int xmlTextWriterWriteNs0ServerErrorElementNS(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_internalServerError *_internalServerError, int writeNamespaces) {
  int totalBytes = 0;
  int status;

  status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "serverError", NULL);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to write start element {}serverError. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

#if DEBUG_ENUNCIATE > 1
  printf("writing type {}internalServerError for root element {}serverError...\n");
#endif
  status = xmlTextWriterWriteNs0InternalServerErrorType(writer, _internalServerError);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to write type for start element {}serverError. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

  status = xmlTextWriterEndElement(writer);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to end element {}serverError. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

  return totalBytes;
}

/**
 * Frees the children of a InternalServerError.
 *
 * @param _internalServerError The InternalServerError whose children are to be free.
 */
static void freeNs0ServerErrorElement(struct stolpjaktenAPI_ns0_internalServerError *_internalServerError) {
  freeNs0InternalServerErrorType(_internalServerError);
}

/**
 * Reads a InternalServerError from XML. The reader is assumed to be at the start element.
 *
 * @return the InternalServerError, or NULL in case of error.
 */
static struct stolpjaktenAPI_ns0_internalServerError *xmlTextReaderReadNs0InternalServerErrorType(xmlTextReaderPtr reader) {
  int status, depth;
  void *_child_accessor;
  struct stolpjaktenAPI_ns0_internalServerError *_internalServerError = calloc(1, sizeof(struct stolpjaktenAPI_ns0_internalServerError));



  if (xmlTextReaderIsEmptyElement(reader) == 0) {
    depth = xmlTextReaderDepth(reader);//track the depth.
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);

    while (xmlTextReaderDepth(reader) > depth) {
      if (status < 1) {
        //panic: XML read error.
#if DEBUG_ENUNCIATE
        printf("Failure to advance to next child element.\n");
#endif
        freeNs0InternalServerErrorType(_internalServerError);
        free(_internalServerError);
        return NULL;
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "description", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}description of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
        _child_accessor = xmlTextReaderReadXsStringType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}description of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs0InternalServerErrorType(_internalServerError);
          free(_internalServerError);
          return NULL;
        }

        _internalServerError->description = ((xmlChar*)_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "identifier", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}identifier of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
        _child_accessor = xmlTextReaderReadXsStringType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}identifier of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs0InternalServerErrorType(_internalServerError);
          free(_internalServerError);
          return NULL;
        }

        _internalServerError->identifier = ((xmlChar*)_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else {
#if DEBUG_ENUNCIATE > 1
        if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
          printf("unknown child element {}%s for type {}internalServerError.  Skipping...\n",  xmlTextReaderConstLocalName(reader));
        }
        else {
          printf("unknown child element {%s}%s for type {}internalServerError. Skipping...\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader));
        }
#endif
        status = xmlTextReaderSkipElement(reader);
      }
    }
  }

  return _internalServerError;
}

/**
 * Writes a InternalServerError to XML.
 *
 * @param writer The XML writer.
 * @param _internalServerError The InternalServerError to write.
 * @return The total bytes written, or -1 on error;
 */
static int xmlTextWriterWriteNs0InternalServerErrorType(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_internalServerError *_internalServerError) {
  int status, totalBytes = 0, i;
  xmlChar *binaryData;
  if (_internalServerError->description != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "description", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}description. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {http://www.w3.org/2001/XMLSchema}string for element {}description...\n");
#endif
    status = xmlTextWriterWriteXsStringType(writer, (_internalServerError->description));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {http://www.w3.org/2001/XMLSchema}string for element {}description. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}description. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }
  if (_internalServerError->identifier != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "identifier", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}identifier. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {http://www.w3.org/2001/XMLSchema}string for element {}identifier...\n");
#endif
    status = xmlTextWriterWriteXsStringType(writer, (_internalServerError->identifier));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {http://www.w3.org/2001/XMLSchema}string for element {}identifier. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}identifier. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }

  return totalBytes;
}

/**
 * Frees the elements of a InternalServerError.
 *
 * @param _internalServerError The InternalServerError to free.
 */
static void freeNs0InternalServerErrorType(struct stolpjaktenAPI_ns0_internalServerError *_internalServerError) {
  int i;
  if (_internalServerError->description != NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Freeing type of accessor description of type stolpjaktenAPI_ns0_internalServerError...\n");
#endif
    freeXsStringType(_internalServerError->description);
#if DEBUG_ENUNCIATE > 1
    printf("Freeing accessor description of type stolpjaktenAPI_ns0_internalServerError...\n");
#endif
    free(_internalServerError->description);
  }
  if (_internalServerError->identifier != NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Freeing type of accessor identifier of type stolpjaktenAPI_ns0_internalServerError...\n");
#endif
    freeXsStringType(_internalServerError->identifier);
#if DEBUG_ENUNCIATE > 1
    printf("Freeing accessor identifier of type stolpjaktenAPI_ns0_internalServerError...\n");
#endif
    free(_internalServerError->identifier);
  }
}
#endif /* DEF_stolpjaktenAPI_ns0_internalServerError_M */
#ifndef DEF_stolpjaktenAPI_ns0_notFound_M
#define DEF_stolpjaktenAPI_ns0_notFound_M

/**
 * Reads a NotFound element from XML. The element to be read is "notFound", and
 * it is assumed that the reader is pointing to the XML document (not the element).
 *
 * @param reader The XML reader.
 * @return The NotFound, or NULL in case of error.
 */
struct stolpjaktenAPI_ns0_notFound *xml_read_stolpjaktenAPI_ns0_notFound(xmlTextReaderPtr reader) {
  int status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
  return xmlTextReaderReadNs0NotFoundElement(reader);
}

/**
 * Writes a NotFound to XML under element name "notFound".
 *
 * @param writer The XML writer.
 * @param _notFound The NotFound to write.
 * @return 1 if successful, 0 otherwise.
 */
int xml_write_stolpjaktenAPI_ns0_notFound(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_notFound *_notFound) {
  return xmlTextWriterWriteNs0NotFoundElementNS(writer, _notFound, 1);
}

/**
 * Frees a NotFound.
 *
 * @param _notFound The NotFound to free.
 */
void free_stolpjaktenAPI_ns0_notFound(struct stolpjaktenAPI_ns0_notFound *_notFound) {
  freeNs0NotFoundType(_notFound);
  free(_notFound);
}

/**
 * Reads a NotFound element from XML. The element to be read is "notFound", and
 * it is assumed that the reader is pointing to that element.
 *
 * @param reader The XML reader.
 * @return The NotFound, or NULL in case of error.
 */
struct stolpjaktenAPI_ns0_notFound *xmlTextReaderReadNs0NotFoundElement(xmlTextReaderPtr reader) {
  struct stolpjaktenAPI_ns0_notFound *_notFound = NULL;

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "notFound", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Attempting to read root element {}notFound.\n");
#endif
    _notFound = xmlTextReaderReadNs0NotFoundType(reader);
  }
#if DEBUG_ENUNCIATE
  if (_notFound == NULL) {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      printf("attempt to read {}notFound failed. current element: {}%s\n",  xmlTextReaderConstLocalName(reader));
    }
    else {
      printf("attempt to read {}notFound failed. current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader));
    }
  }
#endif

  return _notFound;
}

/**
 * Writes a NotFound to XML under element name "notFound".
 * Does NOT write the namespace prefixes.
 *
 * @param writer The XML writer.
 * @param _notFound The NotFound to write.
 * @return 1 if successful, 0 otherwise.
 */
static int xmlTextWriterWriteNs0NotFoundElement(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_notFound *_notFound) {
  return xmlTextWriterWriteNs0NotFoundElementNS(writer, _notFound, 0);
}

/**
 * Writes a NotFound to XML under element name "notFound".
 *
 * @param writer The XML writer.
 * @param _notFound The NotFound to write.
 * @param writeNamespaces Whether to write the namespace prefixes.
 * @return 1 if successful, 0 otherwise.
 */
static int xmlTextWriterWriteNs0NotFoundElementNS(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_notFound *_notFound, int writeNamespaces) {
  int totalBytes = 0;
  int status;

  status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "notFound", NULL);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to write start element {}notFound. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

#if DEBUG_ENUNCIATE > 1
  printf("writing type {}notFound for root element {}notFound...\n");
#endif
  status = xmlTextWriterWriteNs0NotFoundType(writer, _notFound);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to write type for start element {}notFound. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

  status = xmlTextWriterEndElement(writer);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to end element {}notFound. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

  return totalBytes;
}

/**
 * Frees the children of a NotFound.
 *
 * @param _notFound The NotFound whose children are to be free.
 */
static void freeNs0NotFoundElement(struct stolpjaktenAPI_ns0_notFound *_notFound) {
  freeNs0NotFoundType(_notFound);
}

/**
 * Reads a NotFound from XML. The reader is assumed to be at the start element.
 *
 * @return the NotFound, or NULL in case of error.
 */
static struct stolpjaktenAPI_ns0_notFound *xmlTextReaderReadNs0NotFoundType(xmlTextReaderPtr reader) {
  int status, depth;
  void *_child_accessor;
  struct stolpjaktenAPI_ns0_notFound *_notFound = calloc(1, sizeof(struct stolpjaktenAPI_ns0_notFound));



  if (xmlTextReaderIsEmptyElement(reader) == 0) {
    depth = xmlTextReaderDepth(reader);//track the depth.
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);

    while (xmlTextReaderDepth(reader) > depth) {
      if (status < 1) {
        //panic: XML read error.
#if DEBUG_ENUNCIATE
        printf("Failure to advance to next child element.\n");
#endif
        freeNs0NotFoundType(_notFound);
        free(_notFound);
        return NULL;
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "description", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}description of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
        _child_accessor = xmlTextReaderReadXsStringType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}description of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs0NotFoundType(_notFound);
          free(_notFound);
          return NULL;
        }

        _notFound->description = ((xmlChar*)_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else {
#if DEBUG_ENUNCIATE > 1
        if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
          printf("unknown child element {}%s for type {}notFound.  Skipping...\n",  xmlTextReaderConstLocalName(reader));
        }
        else {
          printf("unknown child element {%s}%s for type {}notFound. Skipping...\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader));
        }
#endif
        status = xmlTextReaderSkipElement(reader);
      }
    }
  }

  return _notFound;
}

/**
 * Writes a NotFound to XML.
 *
 * @param writer The XML writer.
 * @param _notFound The NotFound to write.
 * @return The total bytes written, or -1 on error;
 */
static int xmlTextWriterWriteNs0NotFoundType(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_notFound *_notFound) {
  int status, totalBytes = 0, i;
  xmlChar *binaryData;
  if (_notFound->description != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "description", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}description. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {http://www.w3.org/2001/XMLSchema}string for element {}description...\n");
#endif
    status = xmlTextWriterWriteXsStringType(writer, (_notFound->description));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {http://www.w3.org/2001/XMLSchema}string for element {}description. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}description. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }

  return totalBytes;
}

/**
 * Frees the elements of a NotFound.
 *
 * @param _notFound The NotFound to free.
 */
static void freeNs0NotFoundType(struct stolpjaktenAPI_ns0_notFound *_notFound) {
  int i;
  if (_notFound->description != NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Freeing type of accessor description of type stolpjaktenAPI_ns0_notFound...\n");
#endif
    freeXsStringType(_notFound->description);
#if DEBUG_ENUNCIATE > 1
    printf("Freeing accessor description of type stolpjaktenAPI_ns0_notFound...\n");
#endif
    free(_notFound->description);
  }
}
#endif /* DEF_stolpjaktenAPI_ns0_notFound_M */
#ifndef DEF_stolpjaktenAPI_ns0_unauthorized_M
#define DEF_stolpjaktenAPI_ns0_unauthorized_M

/**
 * Reads a Unauthorized element from XML. The element to be read is "unauthorized", and
 * it is assumed that the reader is pointing to the XML document (not the element).
 *
 * @param reader The XML reader.
 * @return The Unauthorized, or NULL in case of error.
 */
struct stolpjaktenAPI_ns0_unauthorized *xml_read_stolpjaktenAPI_ns0_unauthorized(xmlTextReaderPtr reader) {
  int status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
  return xmlTextReaderReadNs0UnauthorizedElement(reader);
}

/**
 * Writes a Unauthorized to XML under element name "unauthorized".
 *
 * @param writer The XML writer.
 * @param _unauthorized The Unauthorized to write.
 * @return 1 if successful, 0 otherwise.
 */
int xml_write_stolpjaktenAPI_ns0_unauthorized(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_unauthorized *_unauthorized) {
  return xmlTextWriterWriteNs0UnauthorizedElementNS(writer, _unauthorized, 1);
}

/**
 * Frees a Unauthorized.
 *
 * @param _unauthorized The Unauthorized to free.
 */
void free_stolpjaktenAPI_ns0_unauthorized(struct stolpjaktenAPI_ns0_unauthorized *_unauthorized) {
  freeNs0UnauthorizedType(_unauthorized);
  free(_unauthorized);
}

/**
 * Reads a Unauthorized element from XML. The element to be read is "unauthorized", and
 * it is assumed that the reader is pointing to that element.
 *
 * @param reader The XML reader.
 * @return The Unauthorized, or NULL in case of error.
 */
struct stolpjaktenAPI_ns0_unauthorized *xmlTextReaderReadNs0UnauthorizedElement(xmlTextReaderPtr reader) {
  struct stolpjaktenAPI_ns0_unauthorized *_unauthorized = NULL;

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "unauthorized", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Attempting to read root element {}unauthorized.\n");
#endif
    _unauthorized = xmlTextReaderReadNs0UnauthorizedType(reader);
  }
#if DEBUG_ENUNCIATE
  if (_unauthorized == NULL) {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      printf("attempt to read {}unauthorized failed. current element: {}%s\n",  xmlTextReaderConstLocalName(reader));
    }
    else {
      printf("attempt to read {}unauthorized failed. current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader));
    }
  }
#endif

  return _unauthorized;
}

/**
 * Writes a Unauthorized to XML under element name "unauthorized".
 * Does NOT write the namespace prefixes.
 *
 * @param writer The XML writer.
 * @param _unauthorized The Unauthorized to write.
 * @return 1 if successful, 0 otherwise.
 */
static int xmlTextWriterWriteNs0UnauthorizedElement(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_unauthorized *_unauthorized) {
  return xmlTextWriterWriteNs0UnauthorizedElementNS(writer, _unauthorized, 0);
}

/**
 * Writes a Unauthorized to XML under element name "unauthorized".
 *
 * @param writer The XML writer.
 * @param _unauthorized The Unauthorized to write.
 * @param writeNamespaces Whether to write the namespace prefixes.
 * @return 1 if successful, 0 otherwise.
 */
static int xmlTextWriterWriteNs0UnauthorizedElementNS(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_unauthorized *_unauthorized, int writeNamespaces) {
  int totalBytes = 0;
  int status;

  status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "unauthorized", NULL);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to write start element {}unauthorized. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

#if DEBUG_ENUNCIATE > 1
  printf("writing type {}unauthorized for root element {}unauthorized...\n");
#endif
  status = xmlTextWriterWriteNs0UnauthorizedType(writer, _unauthorized);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to write type for start element {}unauthorized. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

  status = xmlTextWriterEndElement(writer);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to end element {}unauthorized. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

  return totalBytes;
}

/**
 * Frees the children of a Unauthorized.
 *
 * @param _unauthorized The Unauthorized whose children are to be free.
 */
static void freeNs0UnauthorizedElement(struct stolpjaktenAPI_ns0_unauthorized *_unauthorized) {
  freeNs0UnauthorizedType(_unauthorized);
}

/**
 * Reads a Unauthorized from XML. The reader is assumed to be at the start element.
 *
 * @return the Unauthorized, or NULL in case of error.
 */
static struct stolpjaktenAPI_ns0_unauthorized *xmlTextReaderReadNs0UnauthorizedType(xmlTextReaderPtr reader) {
  int status, depth;
  void *_child_accessor;
  struct stolpjaktenAPI_ns0_unauthorized *_unauthorized = calloc(1, sizeof(struct stolpjaktenAPI_ns0_unauthorized));



  if (xmlTextReaderIsEmptyElement(reader) == 0) {
    depth = xmlTextReaderDepth(reader);//track the depth.
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);

    while (xmlTextReaderDepth(reader) > depth) {
      if (status < 1) {
        //panic: XML read error.
#if DEBUG_ENUNCIATE
        printf("Failure to advance to next child element.\n");
#endif
        freeNs0UnauthorizedType(_unauthorized);
        free(_unauthorized);
        return NULL;
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "description", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}description of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
        _child_accessor = xmlTextReaderReadXsStringType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}description of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs0UnauthorizedType(_unauthorized);
          free(_unauthorized);
          return NULL;
        }

        _unauthorized->description = ((xmlChar*)_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else {
#if DEBUG_ENUNCIATE > 1
        if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
          printf("unknown child element {}%s for type {}unauthorized.  Skipping...\n",  xmlTextReaderConstLocalName(reader));
        }
        else {
          printf("unknown child element {%s}%s for type {}unauthorized. Skipping...\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader));
        }
#endif
        status = xmlTextReaderSkipElement(reader);
      }
    }
  }

  return _unauthorized;
}

/**
 * Writes a Unauthorized to XML.
 *
 * @param writer The XML writer.
 * @param _unauthorized The Unauthorized to write.
 * @return The total bytes written, or -1 on error;
 */
static int xmlTextWriterWriteNs0UnauthorizedType(xmlTextWriterPtr writer, struct stolpjaktenAPI_ns0_unauthorized *_unauthorized) {
  int status, totalBytes = 0, i;
  xmlChar *binaryData;
  if (_unauthorized->description != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "description", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}description. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {http://www.w3.org/2001/XMLSchema}string for element {}description...\n");
#endif
    status = xmlTextWriterWriteXsStringType(writer, (_unauthorized->description));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {http://www.w3.org/2001/XMLSchema}string for element {}description. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}description. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }

  return totalBytes;
}

/**
 * Frees the elements of a Unauthorized.
 *
 * @param _unauthorized The Unauthorized to free.
 */
static void freeNs0UnauthorizedType(struct stolpjaktenAPI_ns0_unauthorized *_unauthorized) {
  int i;
  if (_unauthorized->description != NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Freeing type of accessor description of type stolpjaktenAPI_ns0_unauthorized...\n");
#endif
    freeXsStringType(_unauthorized->description);
#if DEBUG_ENUNCIATE > 1
    printf("Freeing accessor description of type stolpjaktenAPI_ns0_unauthorized...\n");
#endif
    free(_unauthorized->description);
  }
}
#endif /* DEF_stolpjaktenAPI_ns0_unauthorized_M */
