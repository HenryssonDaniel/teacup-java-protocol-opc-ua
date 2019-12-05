package io.github.henryssondaniel.teacup.protocol.opcua.client;

import java.time.Instant;

interface RequestHeaderSetter extends RequestHeader {
  void setAdditionalHeader(ExtensionObject additionalHeader);

  void setAuditEntryId(String auditEntryId);

  void setAuthenticationToken(NodeId authenticationToken);

  void setRequestHandle(int requestHandle);

  void setReturnDiagnostics(int returnDiagnostics);

  void setTimeoutHint(int timeoutHint);

  void setTimestamp(Instant timestamp);
}
