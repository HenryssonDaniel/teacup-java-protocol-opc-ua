package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.BUILD;
import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.SET_ADDITIONAL_HEADER;
import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.SET_BINARY_ENCODING_ID;
import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.SET_REQUEST_HANDLE;
import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.SET_STRING_TABLE;
import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.SET_TIMESTAMP;
import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.SET_XML_ENCODING_ID;

import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

class ResponseHeaderBuilderImpl implements ResponseHeaderBuilder {
  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(
          ResponseHeaderBuilderImpl.class);
  private ResponseHeaderSetter responseHeaderSetter = new ResponseHeaderImpl();

  @Override
  public ResponseHeader build() {
    LOGGER.log(Level.FINE, BUILD);

    var responseHeader = responseHeaderSetter;
    responseHeaderSetter = new ResponseHeaderImpl();

    return responseHeader;
  }

  @Override
  public ResponseHeaderBuilder setAdditionalHeader(ExtensionObject additionalHeader) {
    LOGGER.log(Level.FINE, SET_ADDITIONAL_HEADER);

    responseHeaderSetter.setAdditionalHeader(additionalHeader);
    return this;
  }

  @Override
  public ResponseHeaderBuilder setBinaryEncodingId(NodeId binaryEncodingId) {
    LOGGER.log(Level.FINE, SET_BINARY_ENCODING_ID);

    responseHeaderSetter.setBinaryEncodingId(binaryEncodingId);
    return this;
  }

  @Override
  public ResponseHeaderBuilder setRequestHandle(int requestHandle) {
    LOGGER.log(Level.FINE, SET_REQUEST_HANDLE);

    responseHeaderSetter.setRequestHandle(requestHandle);
    return this;
  }

  @Override
  public ResponseHeaderBuilder setServiceDiagnostics(DiagnosticInfo serviceDiagnostics) {
    LOGGER.log(Level.FINE, "Set service diagnostics");

    responseHeaderSetter.setServiceDiagnostics(serviceDiagnostics);
    return this;
  }

  @Override
  public ResponseHeaderBuilder setServiceResult(long serviceResult) {
    LOGGER.log(Level.FINE, "Set service result");

    responseHeaderSetter.setServiceResult(serviceResult);
    return this;
  }

  @Override
  public ResponseHeaderBuilder setStringTable(String... stringTable) {
    LOGGER.log(Level.FINE, SET_STRING_TABLE);

    responseHeaderSetter.setStringTable(stringTable);
    return this;
  }

  @Override
  public ResponseHeaderBuilder setTimestamp(Instant timestamp) {
    LOGGER.log(Level.FINE, SET_TIMESTAMP);

    responseHeaderSetter.setTimestamp(timestamp);
    return this;
  }

  @Override
  public ResponseHeaderBuilder setTypeId(NodeId typeId) {
    LOGGER.log(Level.FINE, "Set type ID");

    responseHeaderSetter.setTypeId(typeId);
    return this;
  }

  @Override
  public ResponseHeaderBuilder setXmlEncodingId(NodeId xmlEncodingId) {
    LOGGER.log(Level.FINE, SET_XML_ENCODING_ID);

    responseHeaderSetter.setXmlEncodingId(xmlEncodingId);
    return this;
  }
}
