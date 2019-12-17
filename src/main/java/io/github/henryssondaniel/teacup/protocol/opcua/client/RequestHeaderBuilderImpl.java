package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.BUILD;
import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.SET_ADDITIONAL_HEADER;
import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.SET_REQUEST_HANDLE;
import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.SET_TIMESTAMP;

import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

class RequestHeaderBuilderImpl implements RequestHeaderBuilder {
  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(
          RequestHeaderBuilderImpl.class);
  private RequestHeaderSetter requestHeaderSetter = new RequestHeaderImpl();

  @Override
  public RequestHeader build() {
    LOGGER.log(Level.FINE, BUILD);

    var headerSetter = requestHeaderSetter;
    requestHeaderSetter = new RequestHeaderImpl();

    return headerSetter;
  }

  @Override
  public RequestHeaderBuilder setAdditionalHeader(ExtensionObject additionalHeader) {
    LOGGER.log(Level.FINE, SET_ADDITIONAL_HEADER);
    requestHeaderSetter.setAdditionalHeader(additionalHeader);
    return this;
  }

  @Override
  public RequestHeaderBuilder setAuditEntryId(String auditEntryId) {
    LOGGER.log(Level.FINE, "Set audit entry ID");
    requestHeaderSetter.setAuditEntryId(auditEntryId);
    return this;
  }

  @Override
  public RequestHeaderBuilder setAuthenticationToken(NodeId authenticationToken) {
    LOGGER.log(Level.FINE, "Set authentication token");
    requestHeaderSetter.setAuthenticationToken(authenticationToken);
    return this;
  }

  @Override
  public RequestHeaderBuilder setRequestHandle(int requestHandle) {
    LOGGER.log(Level.FINE, SET_REQUEST_HANDLE);
    requestHeaderSetter.setRequestHandle(requestHandle);
    return this;
  }

  @Override
  public RequestHeaderBuilder setReturnDiagnostics(int returnDiagnostics) {
    LOGGER.log(Level.FINE, "Set return diagnostics");
    requestHeaderSetter.setReturnDiagnostics(returnDiagnostics);
    return this;
  }

  @Override
  public RequestHeaderBuilder setTimeoutHint(int timeoutHint) {
    LOGGER.log(Level.FINE, "Set timeout hint");
    requestHeaderSetter.setTimeoutHint(timeoutHint);
    return this;
  }

  @Override
  public RequestHeaderBuilder setTimestamp(Instant timestamp) {
    LOGGER.log(Level.FINE, SET_TIMESTAMP);
    requestHeaderSetter.setTimestamp(timestamp);
    return this;
  }
}
