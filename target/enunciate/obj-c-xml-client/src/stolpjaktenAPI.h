#import "enunciate-common.h"
#ifndef DEF_STOLPJAKTENAPINS0ErrorCode_H
#define DEF_STOLPJAKTENAPINS0ErrorCode_H

/**
 * 
 *  Enumeration of error codes that can occur in BadRequest responses.
 */
enum STOLPJAKTENAPINS0ErrorCode
{

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
static enum STOLPJAKTENAPINS0ErrorCode *xmlTextReaderReadSTOLPJAKTENAPINS0ErrorCodeType(xmlTextReaderPtr reader);

/**
 * Writes a ErrorCode to XML.
 *
 * @param writer The XML writer.
 * @param _errorCode The ErrorCode to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteSTOLPJAKTENAPINS0ErrorCodeType(xmlTextWriterPtr writer, enum STOLPJAKTENAPINS0ErrorCode *_errorCode);

/**
 * Utility method for getting the enum value for a string.
 *
 * @param _errorCode The string to format.
 * @return The enum value or NULL on error.
 */
static enum STOLPJAKTENAPINS0ErrorCode *formatStringToSTOLPJAKTENAPINS0ErrorCodeType(NSString *_errorCode);

/**
 * Utility method for getting the string value of ErrorCode.
 *
 * @param _errorCode The ErrorCode to format.
 * @return The string value or NULL on error.
 */
static NSString *formatSTOLPJAKTENAPINS0ErrorCodeTypeToString(enum STOLPJAKTENAPINS0ErrorCode *_errorCode);
#endif /* DEF_STOLPJAKTENAPINS0ErrorCode_H */

@class STOLPJAKTENAPINS0BaseError;
@class STOLPJAKTENAPINS0Unauthorized;
@class STOLPJAKTENAPINS0NotFound;
@class STOLPJAKTENAPINS0InternalServerError;
@class STOLPJAKTENAPINS0Forbidden;
@class STOLPJAKTENAPINS0BadRequest;

#ifndef DEF_STOLPJAKTENAPINS0BaseError_H
#define DEF_STOLPJAKTENAPINS0BaseError_H

/**
 * 
 *  Base class for all errors.
 *  <br>
 *  All errors contains a description text.
 * 
 */
@interface STOLPJAKTENAPINS0BaseError : NSObject <EnunciateXML>
{
  @private
    NSString *_description;
}

/**
 * (no documentation provided)
 */
- (NSString *) description;

/**
 * (no documentation provided)
 */
- (void) setDescription: (NSString *) newDescription;
@end /* interface STOLPJAKTENAPINS0BaseError */

#endif /* DEF_STOLPJAKTENAPINS0BaseError_H */
#ifndef DEF_STOLPJAKTENAPINS0Unauthorized_H
#define DEF_STOLPJAKTENAPINS0Unauthorized_H

/**
 * 
 *  Payload for unauthorized (401) responses.
 *  <br>
 *  Please see description for details about the specific error.
 */
@interface STOLPJAKTENAPINS0Unauthorized : STOLPJAKTENAPINS0BaseError <EnunciateXML>
{
  @private
}
@end /* interface STOLPJAKTENAPINS0Unauthorized */

#endif /* DEF_STOLPJAKTENAPINS0Unauthorized_H */
#ifndef DEF_STOLPJAKTENAPINS0NotFound_H
#define DEF_STOLPJAKTENAPINS0NotFound_H

/**
 * 
 *  Payload for not found (404) responses.
 *  <br>
 *  Please see description for details about the specific error.
 */
@interface STOLPJAKTENAPINS0NotFound : STOLPJAKTENAPINS0BaseError <EnunciateXML>
{
  @private
}
@end /* interface STOLPJAKTENAPINS0NotFound */

#endif /* DEF_STOLPJAKTENAPINS0NotFound_H */
#ifndef DEF_STOLPJAKTENAPINS0InternalServerError_H
#define DEF_STOLPJAKTENAPINS0InternalServerError_H

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
@interface STOLPJAKTENAPINS0InternalServerError : STOLPJAKTENAPINS0BaseError <EnunciateXML>
{
  @private
    NSString *_identifier;
}

/**
 * (no documentation provided)
 */
- (NSString *) identifier;

/**
 * (no documentation provided)
 */
- (void) setIdentifier: (NSString *) newIdentifier;
@end /* interface STOLPJAKTENAPINS0InternalServerError */

#endif /* DEF_STOLPJAKTENAPINS0InternalServerError_H */
#ifndef DEF_STOLPJAKTENAPINS0Forbidden_H
#define DEF_STOLPJAKTENAPINS0Forbidden_H

/**
 * 
 *  Payload for forbidden (403) responses.
 *  <br>
 *  Please see error code and description for details about the specific error.
 */
@interface STOLPJAKTENAPINS0Forbidden : STOLPJAKTENAPINS0BaseError <EnunciateXML>
{
  @private
}
@end /* interface STOLPJAKTENAPINS0Forbidden */

#endif /* DEF_STOLPJAKTENAPINS0Forbidden_H */
#ifndef DEF_STOLPJAKTENAPINS0BadRequest_H
#define DEF_STOLPJAKTENAPINS0BadRequest_H

/**
 * 
 *  Payload for bad request (400) responses.
 *  <br>
 *  Please see error code and description for details about the specific error.
 */
@interface STOLPJAKTENAPINS0BadRequest : STOLPJAKTENAPINS0BaseError <EnunciateXML>
{
  @private
    enum STOLPJAKTENAPINS0ErrorCode *_errorCode;
}

/**
 * (no documentation provided)
 */
- (enum STOLPJAKTENAPINS0ErrorCode *) errorCode;

/**
 * (no documentation provided)
 */
- (void) setErrorCode: (enum STOLPJAKTENAPINS0ErrorCode *) newErrorCode;
@end /* interface STOLPJAKTENAPINS0BadRequest */

#endif /* DEF_STOLPJAKTENAPINS0BadRequest_H */
