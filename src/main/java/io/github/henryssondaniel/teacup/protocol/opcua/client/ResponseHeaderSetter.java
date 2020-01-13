package io.github.henryssondaniel.teacup.protocol.opcua.client;

import java.time.Instant;

interface ResponseHeaderSetter extends ResponseHeader {
  void setAdditionalHeader(ExtensionObject additionalHeader);

  void setRequestHandle(int requestHandle);

  void setServiceDiagnostics(DiagnosticInfo serviceDiagnostics);

  void setServiceResult(long serviceResult);

  void setStringTable(String... stringTable);

  void setTimestamp(Instant timestamp);
}
