package io.github.henryssondaniel.teacup.protocol.opcua.client;

import java.time.Instant;

class RequestHeaderImpl implements RequestHeaderSetter {
  private ExtensionObject additionalHeader;
  private String auditEntryId;
  private NodeId authenticationToken;
  private int requestHandle;
  private int returnDiagnostics;
  private int timeoutHint;
  private Instant timestamp;

  @Override
  public ExtensionObject getAdditionalHeader() {
    return additionalHeader;
  }

  @Override
  public String getAuditEntryId() {
    return auditEntryId;
  }

  @Override
  public NodeId getAuthenticationToken() {
    return authenticationToken;
  }

  @Override
  public int getRequestHandle() {
    return requestHandle;
  }

  @Override
  public int getReturnDiagnostics() {
    return returnDiagnostics;
  }

  @Override
  public int getTimeoutHint() {
    return timeoutHint;
  }

  @Override
  public Instant getTimestamp() {
    return timestamp;
  }

  @Override
  public void setAdditionalHeader(ExtensionObject additionalHeader) {
    this.additionalHeader = additionalHeader;
  }

  @Override
  public void setAuditEntryId(String auditEntryId) {
    this.auditEntryId = auditEntryId;
  }

  @Override
  public void setAuthenticationToken(NodeId authenticationToken) {
    this.authenticationToken = authenticationToken;
  }

  @Override
  public void setRequestHandle(int requestHandle) {
    this.requestHandle = requestHandle;
  }

  @Override
  public void setReturnDiagnostics(int returnDiagnostics) {
    this.returnDiagnostics = returnDiagnostics;
  }

  @Override
  public void setTimeoutHint(int timeoutHint) {
    this.timeoutHint = timeoutHint;
  }

  @Override
  public void setTimestamp(Instant timestamp) {
    this.timestamp = timestamp;
  }
}
