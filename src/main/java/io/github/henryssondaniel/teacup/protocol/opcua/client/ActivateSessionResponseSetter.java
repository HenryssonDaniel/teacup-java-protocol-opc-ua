package io.github.henryssondaniel.teacup.protocol.opcua.client;

interface ActivateSessionResponseSetter extends ActivateSessionResponse, ResponseSetter {
  void setBinaryEncodingId(NodeId binaryEncodingId);

  void setDiagnosticInfos(DiagnosticInfo... diagnosticInfos);

  void setResults(long... results);

  void setServerNonce(byte... serverNonce);

  void setTypeId(NodeId typeId);

  void setXmlEncodingId(NodeId xmlEncodingId);
}
