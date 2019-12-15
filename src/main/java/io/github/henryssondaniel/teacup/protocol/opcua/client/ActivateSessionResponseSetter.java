package io.github.henryssondaniel.teacup.protocol.opcua.client;

interface ActivateSessionResponseSetter extends ActivateSessionResponse {
  void setBinaryEncodingId(NodeId binaryEncodingId);

  void setDiagnosticInfos(DiagnosticInfo... diagnosticInfos);

  void setResponseHeader(ResponseHeader responseHeader);

  void setResults(StatusCode... results);

  void setServerNonce(byte... serverNonce);

  void setTypeId(NodeId typeId);

  void setXmlEncodingId(NodeId xmlEncodingId);
}
