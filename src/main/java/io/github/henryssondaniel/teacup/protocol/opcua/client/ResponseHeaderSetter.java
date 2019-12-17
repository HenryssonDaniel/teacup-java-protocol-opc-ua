package io.github.henryssondaniel.teacup.protocol.opcua.client;

import java.time.Instant;

interface ResponseHeaderSetter extends ResponseHeader {
  void setAdditionalHeader(ExtensionObject additionalHeader);

  void setBinaryEncodingId(NodeId binaryEncodingId);

  void setRequestHandle(int requestHandle);

  void setServiceDiagnostics(DiagnosticInfo serviceDiagnostics);

  void setServiceResult(long serviceResult);

  void setStringTable(String... stringTable);

  void setTimestamp(Instant timestamp);

  void setTypeId(NodeId typeId);

  void setXmlEncodingId(NodeId xmlEncodingId);
}
