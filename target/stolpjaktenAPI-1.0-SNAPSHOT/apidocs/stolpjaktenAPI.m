#import "stolpjaktenAPI.h"
#ifndef DEF_STOLPJAKTENAPINS0ErrorCode_M
#define DEF_STOLPJAKTENAPINS0ErrorCode_M

/**
 * Reads a ErrorCode from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The ErrorCode, or NULL if unable to be read.
 */
static enum STOLPJAKTENAPINS0ErrorCode *xmlTextReaderReadSTOLPJAKTENAPINS0ErrorCodeType(xmlTextReaderPtr reader)
{
  xmlChar *enumValue = xmlTextReaderReadEntireNodeValue(reader);
  enum STOLPJAKTENAPINS0ErrorCode *value = calloc(1, sizeof(enum STOLPJAKTENAPINS0ErrorCode));
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
    NSLog(@"Attempt to read enum value failed: %s doesn't match an enum value.", enumValue);
#endif
  }
#if DEBUG_ENUNCIATE
  else {
    NSLog(@"Attempt to read enum value failed: NULL value.");
  }
#endif

  return NULL;
}

/**
 * Utility method for getting the enum value for a string.
 *
 * @param _errorCode The string to format.
 * @return The enum value or NULL on error.
 */
enum STOLPJAKTENAPINS0ErrorCode *formatStringToSTOLPJAKTENAPINS0ErrorCodeType(NSString *_errorCode)
{
  enum STOLPJAKTENAPINS0ErrorCode *value = calloc(1, sizeof(enum STOLPJAKTENAPINS0ErrorCode));
  if ([@"JSON_SYNTAX" isEqualToString:_errorCode]) {
    *value = STOLPJAKTENAPI_NS0_ERRORCODE_JSON_SYNTAX;
  }
  else if ([@"JSON_SEMATIC" isEqualToString:_errorCode]) {
    *value = STOLPJAKTENAPI_NS0_ERRORCODE_JSON_SEMATIC;
  }
  else if ([@"JSON_FIELD_USERNAME" isEqualToString:_errorCode]) {
    *value = STOLPJAKTENAPI_NS0_ERRORCODE_JSON_FIELD_USERNAME;
  }
  else if ([@"JSON_FIELD_EMAIL" isEqualToString:_errorCode]) {
    *value = STOLPJAKTENAPI_NS0_ERRORCODE_JSON_FIELD_EMAIL;
  }
  else if ([@"JSON_FIELD_PASSWORD" isEqualToString:_errorCode]) {
    *value = STOLPJAKTENAPI_NS0_ERRORCODE_JSON_FIELD_PASSWORD;
  }
  else if ([@"RESOURCE_EXISTS" isEqualToString:_errorCode]) {
    *value = STOLPJAKTENAPI_NS0_ERRORCODE_RESOURCE_EXISTS;
  }
  else if ([@"RESOURCE_NOT_EXISTS" isEqualToString:_errorCode]) {
    *value = STOLPJAKTENAPI_NS0_ERRORCODE_RESOURCE_NOT_EXISTS;
  }
  else{
#if DEBUG_ENUNCIATE
  NSLog(@"Attempt to read enum value failed: %s doesn't match an enum value.", [_errorCode UTF8String]);
#endif
    value = NULL;
  }
  return value;
}

/**
 * Writes a ErrorCode to XML.
 *
 * @param writer The XML writer.
 * @param _errorCode The ErrorCode to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteSTOLPJAKTENAPINS0ErrorCodeType(xmlTextWriterPtr writer, enum STOLPJAKTENAPINS0ErrorCode *_errorCode)
{
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
  NSLog(@"Unable to write enum value (no valid value found).");
#endif
  return -1;
}

/**
 * Utility method for getting the string value of ErrorCode.
 *
 * @param _errorCode The ErrorCode to format.
 * @return The string value or NULL on error.
 */
static NSString *formatSTOLPJAKTENAPINS0ErrorCodeTypeToString(enum STOLPJAKTENAPINS0ErrorCode *_errorCode)
{
  switch (*_errorCode) {
    case STOLPJAKTENAPI_NS0_ERRORCODE_JSON_SYNTAX:
      return @"JSON_SYNTAX";
    case STOLPJAKTENAPI_NS0_ERRORCODE_JSON_SEMATIC:
      return @"JSON_SEMATIC";
    case STOLPJAKTENAPI_NS0_ERRORCODE_JSON_FIELD_USERNAME:
      return @"JSON_FIELD_USERNAME";
    case STOLPJAKTENAPI_NS0_ERRORCODE_JSON_FIELD_EMAIL:
      return @"JSON_FIELD_EMAIL";
    case STOLPJAKTENAPI_NS0_ERRORCODE_JSON_FIELD_PASSWORD:
      return @"JSON_FIELD_PASSWORD";
    case STOLPJAKTENAPI_NS0_ERRORCODE_RESOURCE_EXISTS:
      return @"RESOURCE_EXISTS";
    case STOLPJAKTENAPI_NS0_ERRORCODE_RESOURCE_NOT_EXISTS:
      return @"RESOURCE_NOT_EXISTS";
    default:
      return NULL;
  }

  return NULL;
}
#endif /* DEF_STOLPJAKTENAPINS0ErrorCode_M */
#ifndef DEF_STOLPJAKTENAPINS0BaseError_M
#define DEF_STOLPJAKTENAPINS0BaseError_M

/**
 * 
 *  Base class for all errors.
 *  <br>
 *  All errors contains a description text.
 * 
 */
@implementation STOLPJAKTENAPINS0BaseError

/**
 * (no documentation provided)
 */
- (NSString *) description
{
  return _description;
}

/**
 * (no documentation provided)
 */
- (void) setDescription: (NSString *) newDescription
{
  [newDescription retain];
  [_description release];
  _description = newDescription;
}

- (void) dealloc
{
  [self setDescription: nil];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  STOLPJAKTENAPINS0BaseError *_sTOLPJAKTENAPINS0BaseError;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _sTOLPJAKTENAPINS0BaseError = (STOLPJAKTENAPINS0BaseError *) [STOLPJAKTENAPINS0BaseError readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _sTOLPJAKTENAPINS0BaseError;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation STOLPJAKTENAPINS0BaseError */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface STOLPJAKTENAPINS0BaseError (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface STOLPJAKTENAPINS0BaseError (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation STOLPJAKTENAPINS0BaseError (JAXB)

/**
 * Read an instance of STOLPJAKTENAPINS0BaseError from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of STOLPJAKTENAPINS0BaseError defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  STOLPJAKTENAPINS0BaseError *_sTOLPJAKTENAPINS0BaseError = [[STOLPJAKTENAPINS0BaseError alloc] init];
  NS_DURING
  {
    [_sTOLPJAKTENAPINS0BaseError initWithReader: reader];
  }
  NS_HANDLER
  {
    _sTOLPJAKTENAPINS0BaseError = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_sTOLPJAKTENAPINS0BaseError autorelease];
  return _sTOLPJAKTENAPINS0BaseError;
}

/**
 * Initialize this instance of STOLPJAKTENAPINS0BaseError according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of STOLPJAKTENAPINS0BaseError to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a STOLPJAKTENAPINS0BaseError from an XML reader. The element to be read is
 * "baseError".
 *
 * @param reader The XML reader.
 * @return The STOLPJAKTENAPINS0BaseError.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  STOLPJAKTENAPINS0BaseError *_baseError = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element baseError."];
    }
  }

  if (xmlStrcmp(BAD_CAST "baseError", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}baseError.");
#endif
    _baseError = (STOLPJAKTENAPINS0BaseError *)[STOLPJAKTENAPINS0BaseError readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}baseError.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read STOLPJAKTENAPINS0BaseError. Expected element baseError. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read STOLPJAKTENAPINS0BaseError. Expected element baseError. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _baseError;
}

/**
 * Writes this STOLPJAKTENAPINS0BaseError to XML under element name "baseError".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _baseError The BaseError to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this STOLPJAKTENAPINS0BaseError to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "baseError", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}baseError. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}baseError for root element {}baseError...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}baseError for root element {}baseError...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}baseError. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "description", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}description of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}description of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setDescription: __child];
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self description]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "description", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}description."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}description...");
#endif
    [[self description] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}description...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}description."];
    }
  }
}
@end /* implementation STOLPJAKTENAPINS0BaseError (JAXB) */

#endif /* DEF_STOLPJAKTENAPINS0BaseError_M */
#ifndef DEF_STOLPJAKTENAPINS0Unauthorized_M
#define DEF_STOLPJAKTENAPINS0Unauthorized_M

/**
 * 
 *  Payload for unauthorized (401) responses.
 *  <br>
 *  Please see description for details about the specific error.
 */
@implementation STOLPJAKTENAPINS0Unauthorized

- (void) dealloc
{
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  STOLPJAKTENAPINS0Unauthorized *_sTOLPJAKTENAPINS0Unauthorized;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _sTOLPJAKTENAPINS0Unauthorized = (STOLPJAKTENAPINS0Unauthorized *) [STOLPJAKTENAPINS0Unauthorized readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _sTOLPJAKTENAPINS0Unauthorized;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation STOLPJAKTENAPINS0Unauthorized */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface STOLPJAKTENAPINS0Unauthorized (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface STOLPJAKTENAPINS0Unauthorized (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation STOLPJAKTENAPINS0Unauthorized (JAXB)

/**
 * Read an instance of STOLPJAKTENAPINS0Unauthorized from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of STOLPJAKTENAPINS0Unauthorized defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  STOLPJAKTENAPINS0Unauthorized *_sTOLPJAKTENAPINS0Unauthorized = [[STOLPJAKTENAPINS0Unauthorized alloc] init];
  NS_DURING
  {
    [_sTOLPJAKTENAPINS0Unauthorized initWithReader: reader];
  }
  NS_HANDLER
  {
    _sTOLPJAKTENAPINS0Unauthorized = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_sTOLPJAKTENAPINS0Unauthorized autorelease];
  return _sTOLPJAKTENAPINS0Unauthorized;
}

/**
 * Initialize this instance of STOLPJAKTENAPINS0Unauthorized according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of STOLPJAKTENAPINS0Unauthorized to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a STOLPJAKTENAPINS0Unauthorized from an XML reader. The element to be read is
 * "unauthorized".
 *
 * @param reader The XML reader.
 * @return The STOLPJAKTENAPINS0Unauthorized.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  STOLPJAKTENAPINS0Unauthorized *_unauthorized = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element unauthorized."];
    }
  }

  if (xmlStrcmp(BAD_CAST "unauthorized", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}unauthorized.");
#endif
    _unauthorized = (STOLPJAKTENAPINS0Unauthorized *)[STOLPJAKTENAPINS0Unauthorized readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}unauthorized.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read STOLPJAKTENAPINS0Unauthorized. Expected element unauthorized. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read STOLPJAKTENAPINS0Unauthorized. Expected element unauthorized. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _unauthorized;
}

/**
 * Writes this STOLPJAKTENAPINS0Unauthorized to XML under element name "unauthorized".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _unauthorized The Unauthorized to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this STOLPJAKTENAPINS0Unauthorized to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "unauthorized", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}unauthorized. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}unauthorized for root element {}unauthorized...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}unauthorized for root element {}unauthorized...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}unauthorized. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

}
@end /* implementation STOLPJAKTENAPINS0Unauthorized (JAXB) */

#endif /* DEF_STOLPJAKTENAPINS0Unauthorized_M */
#ifndef DEF_STOLPJAKTENAPINS0NotFound_M
#define DEF_STOLPJAKTENAPINS0NotFound_M

/**
 * 
 *  Payload for not found (404) responses.
 *  <br>
 *  Please see description for details about the specific error.
 */
@implementation STOLPJAKTENAPINS0NotFound

- (void) dealloc
{
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  STOLPJAKTENAPINS0NotFound *_sTOLPJAKTENAPINS0NotFound;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _sTOLPJAKTENAPINS0NotFound = (STOLPJAKTENAPINS0NotFound *) [STOLPJAKTENAPINS0NotFound readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _sTOLPJAKTENAPINS0NotFound;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation STOLPJAKTENAPINS0NotFound */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface STOLPJAKTENAPINS0NotFound (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface STOLPJAKTENAPINS0NotFound (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation STOLPJAKTENAPINS0NotFound (JAXB)

/**
 * Read an instance of STOLPJAKTENAPINS0NotFound from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of STOLPJAKTENAPINS0NotFound defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  STOLPJAKTENAPINS0NotFound *_sTOLPJAKTENAPINS0NotFound = [[STOLPJAKTENAPINS0NotFound alloc] init];
  NS_DURING
  {
    [_sTOLPJAKTENAPINS0NotFound initWithReader: reader];
  }
  NS_HANDLER
  {
    _sTOLPJAKTENAPINS0NotFound = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_sTOLPJAKTENAPINS0NotFound autorelease];
  return _sTOLPJAKTENAPINS0NotFound;
}

/**
 * Initialize this instance of STOLPJAKTENAPINS0NotFound according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of STOLPJAKTENAPINS0NotFound to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a STOLPJAKTENAPINS0NotFound from an XML reader. The element to be read is
 * "notFound".
 *
 * @param reader The XML reader.
 * @return The STOLPJAKTENAPINS0NotFound.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  STOLPJAKTENAPINS0NotFound *_notFound = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element notFound."];
    }
  }

  if (xmlStrcmp(BAD_CAST "notFound", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}notFound.");
#endif
    _notFound = (STOLPJAKTENAPINS0NotFound *)[STOLPJAKTENAPINS0NotFound readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}notFound.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read STOLPJAKTENAPINS0NotFound. Expected element notFound. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read STOLPJAKTENAPINS0NotFound. Expected element notFound. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _notFound;
}

/**
 * Writes this STOLPJAKTENAPINS0NotFound to XML under element name "notFound".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _notFound The NotFound to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this STOLPJAKTENAPINS0NotFound to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "notFound", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}notFound. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}notFound for root element {}notFound...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}notFound for root element {}notFound...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}notFound. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

}
@end /* implementation STOLPJAKTENAPINS0NotFound (JAXB) */

#endif /* DEF_STOLPJAKTENAPINS0NotFound_M */
#ifndef DEF_STOLPJAKTENAPINS0InternalServerError_M
#define DEF_STOLPJAKTENAPINS0InternalServerError_M

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
@implementation STOLPJAKTENAPINS0InternalServerError

/**
 * (no documentation provided)
 */
- (NSString *) identifier
{
  return _identifier;
}

/**
 * (no documentation provided)
 */
- (void) setIdentifier: (NSString *) newIdentifier
{
  [newIdentifier retain];
  [_identifier release];
  _identifier = newIdentifier;
}

- (void) dealloc
{
  [self setIdentifier: nil];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  STOLPJAKTENAPINS0InternalServerError *_sTOLPJAKTENAPINS0InternalServerError;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _sTOLPJAKTENAPINS0InternalServerError = (STOLPJAKTENAPINS0InternalServerError *) [STOLPJAKTENAPINS0InternalServerError readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _sTOLPJAKTENAPINS0InternalServerError;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation STOLPJAKTENAPINS0InternalServerError */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface STOLPJAKTENAPINS0InternalServerError (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface STOLPJAKTENAPINS0InternalServerError (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation STOLPJAKTENAPINS0InternalServerError (JAXB)

/**
 * Read an instance of STOLPJAKTENAPINS0InternalServerError from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of STOLPJAKTENAPINS0InternalServerError defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  STOLPJAKTENAPINS0InternalServerError *_sTOLPJAKTENAPINS0InternalServerError = [[STOLPJAKTENAPINS0InternalServerError alloc] init];
  NS_DURING
  {
    [_sTOLPJAKTENAPINS0InternalServerError initWithReader: reader];
  }
  NS_HANDLER
  {
    _sTOLPJAKTENAPINS0InternalServerError = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_sTOLPJAKTENAPINS0InternalServerError autorelease];
  return _sTOLPJAKTENAPINS0InternalServerError;
}

/**
 * Initialize this instance of STOLPJAKTENAPINS0InternalServerError according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of STOLPJAKTENAPINS0InternalServerError to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a STOLPJAKTENAPINS0InternalServerError from an XML reader. The element to be read is
 * "serverError".
 *
 * @param reader The XML reader.
 * @return The STOLPJAKTENAPINS0InternalServerError.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  STOLPJAKTENAPINS0InternalServerError *_internalServerError = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element serverError."];
    }
  }

  if (xmlStrcmp(BAD_CAST "serverError", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}serverError.");
#endif
    _internalServerError = (STOLPJAKTENAPINS0InternalServerError *)[STOLPJAKTENAPINS0InternalServerError readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}serverError.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read STOLPJAKTENAPINS0InternalServerError. Expected element serverError. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read STOLPJAKTENAPINS0InternalServerError. Expected element serverError. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _internalServerError;
}

/**
 * Writes this STOLPJAKTENAPINS0InternalServerError to XML under element name "serverError".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _internalServerError The InternalServerError to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this STOLPJAKTENAPINS0InternalServerError to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "serverError", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}serverError. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}internalServerError for root element {}serverError...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}internalServerError for root element {}serverError...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}serverError. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "identifier", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}identifier of type {http://www.w3.org/2001/XMLSchema}string.");
#endif
    __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}identifier of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    [self setIdentifier: __child];
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self identifier]) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "identifier", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}identifier."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}identifier...");
#endif
    [[self identifier] writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}identifier...");
#endif

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}identifier."];
    }
  }
}
@end /* implementation STOLPJAKTENAPINS0InternalServerError (JAXB) */

#endif /* DEF_STOLPJAKTENAPINS0InternalServerError_M */
#ifndef DEF_STOLPJAKTENAPINS0Forbidden_M
#define DEF_STOLPJAKTENAPINS0Forbidden_M

/**
 * 
 *  Payload for forbidden (403) responses.
 *  <br>
 *  Please see error code and description for details about the specific error.
 */
@implementation STOLPJAKTENAPINS0Forbidden

- (void) dealloc
{
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  STOLPJAKTENAPINS0Forbidden *_sTOLPJAKTENAPINS0Forbidden;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _sTOLPJAKTENAPINS0Forbidden = (STOLPJAKTENAPINS0Forbidden *) [STOLPJAKTENAPINS0Forbidden readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _sTOLPJAKTENAPINS0Forbidden;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation STOLPJAKTENAPINS0Forbidden */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface STOLPJAKTENAPINS0Forbidden (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface STOLPJAKTENAPINS0Forbidden (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation STOLPJAKTENAPINS0Forbidden (JAXB)

/**
 * Read an instance of STOLPJAKTENAPINS0Forbidden from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of STOLPJAKTENAPINS0Forbidden defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  STOLPJAKTENAPINS0Forbidden *_sTOLPJAKTENAPINS0Forbidden = [[STOLPJAKTENAPINS0Forbidden alloc] init];
  NS_DURING
  {
    [_sTOLPJAKTENAPINS0Forbidden initWithReader: reader];
  }
  NS_HANDLER
  {
    _sTOLPJAKTENAPINS0Forbidden = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_sTOLPJAKTENAPINS0Forbidden autorelease];
  return _sTOLPJAKTENAPINS0Forbidden;
}

/**
 * Initialize this instance of STOLPJAKTENAPINS0Forbidden according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of STOLPJAKTENAPINS0Forbidden to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a STOLPJAKTENAPINS0Forbidden from an XML reader. The element to be read is
 * "forbidden".
 *
 * @param reader The XML reader.
 * @return The STOLPJAKTENAPINS0Forbidden.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  STOLPJAKTENAPINS0Forbidden *_forbidden = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element forbidden."];
    }
  }

  if (xmlStrcmp(BAD_CAST "forbidden", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}forbidden.");
#endif
    _forbidden = (STOLPJAKTENAPINS0Forbidden *)[STOLPJAKTENAPINS0Forbidden readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}forbidden.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read STOLPJAKTENAPINS0Forbidden. Expected element forbidden. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read STOLPJAKTENAPINS0Forbidden. Expected element forbidden. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _forbidden;
}

/**
 * Writes this STOLPJAKTENAPINS0Forbidden to XML under element name "forbidden".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _forbidden The Forbidden to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this STOLPJAKTENAPINS0Forbidden to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "forbidden", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}forbidden. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}forbidden for root element {}forbidden...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}forbidden for root element {}forbidden...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}forbidden. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

}
@end /* implementation STOLPJAKTENAPINS0Forbidden (JAXB) */

#endif /* DEF_STOLPJAKTENAPINS0Forbidden_M */
#ifndef DEF_STOLPJAKTENAPINS0BadRequest_M
#define DEF_STOLPJAKTENAPINS0BadRequest_M

/**
 * 
 *  Payload for bad request (400) responses.
 *  <br>
 *  Please see error code and description for details about the specific error.
 */
@implementation STOLPJAKTENAPINS0BadRequest

/**
 * (no documentation provided)
 */
- (enum STOLPJAKTENAPINS0ErrorCode *) errorCode
{
  return _errorCode;
}

/**
 * (no documentation provided)
 */
- (void) setErrorCode: (enum STOLPJAKTENAPINS0ErrorCode *) newErrorCode
{
  if (_errorCode != NULL) {
    free(_errorCode);
  }
  _errorCode = newErrorCode;
}

- (void) dealloc
{
  [self setErrorCode: NULL];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  STOLPJAKTENAPINS0BadRequest *_sTOLPJAKTENAPINS0BadRequest;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _sTOLPJAKTENAPINS0BadRequest = (STOLPJAKTENAPINS0BadRequest *) [STOLPJAKTENAPINS0BadRequest readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _sTOLPJAKTENAPINS0BadRequest;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation STOLPJAKTENAPINS0BadRequest */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface STOLPJAKTENAPINS0BadRequest (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface STOLPJAKTENAPINS0BadRequest (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation STOLPJAKTENAPINS0BadRequest (JAXB)

/**
 * Read an instance of STOLPJAKTENAPINS0BadRequest from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of STOLPJAKTENAPINS0BadRequest defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  STOLPJAKTENAPINS0BadRequest *_sTOLPJAKTENAPINS0BadRequest = [[STOLPJAKTENAPINS0BadRequest alloc] init];
  NS_DURING
  {
    [_sTOLPJAKTENAPINS0BadRequest initWithReader: reader];
  }
  NS_HANDLER
  {
    _sTOLPJAKTENAPINS0BadRequest = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_sTOLPJAKTENAPINS0BadRequest autorelease];
  return _sTOLPJAKTENAPINS0BadRequest;
}

/**
 * Initialize this instance of STOLPJAKTENAPINS0BadRequest according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of STOLPJAKTENAPINS0BadRequest to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a STOLPJAKTENAPINS0BadRequest from an XML reader. The element to be read is
 * "badRequest".
 *
 * @param reader The XML reader.
 * @return The STOLPJAKTENAPINS0BadRequest.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  STOLPJAKTENAPINS0BadRequest *_badRequest = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element badRequest."];
    }
  }

  if (xmlStrcmp(BAD_CAST "badRequest", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}badRequest.");
#endif
    _badRequest = (STOLPJAKTENAPINS0BadRequest *)[STOLPJAKTENAPINS0BadRequest readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}badRequest.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read STOLPJAKTENAPINS0BadRequest. Expected element badRequest. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read STOLPJAKTENAPINS0BadRequest. Expected element badRequest. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _badRequest;
}

/**
 * Writes this STOLPJAKTENAPINS0BadRequest to XML under element name "badRequest".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _badRequest The BadRequest to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this STOLPJAKTENAPINS0BadRequest to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "badRequest", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}badRequest. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}badRequest for root element {}badRequest...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}badRequest for root element {}badRequest...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}badRequest. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "errorCode", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

    _child_accessor = xmlTextReaderReadSTOLPJAKTENAPINS0ErrorCodeType(reader);
    if (_child_accessor == NULL) {
      //panic: unable to return the value for some reason.
      [NSException raise: @"XMLReadError"
                   format: @"Error reading element value."];
    }
    [self setErrorCode: ((enum STOLPJAKTENAPINS0ErrorCode*) _child_accessor)];
    return YES;
  }

  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self errorCode] != NULL) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "errorCode", NULL);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing start child element {}errorCode."];
    }

#if DEBUG_ENUNCIATE > 1
    NSLog(@"writing element {}errorCode...");
#endif
    status = xmlTextWriterWriteSTOLPJAKTENAPINS0ErrorCodeType(writer, [self errorCode]);
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully wrote element {}errorCode...");
#endif
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing child element {}errorCode."];
    }

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
      [NSException raise: @"XMLWriteError"
                   format: @"Error writing end child element {}errorCode."];
    }
  }
}
@end /* implementation STOLPJAKTENAPINS0BadRequest (JAXB) */

#endif /* DEF_STOLPJAKTENAPINS0BadRequest_M */
