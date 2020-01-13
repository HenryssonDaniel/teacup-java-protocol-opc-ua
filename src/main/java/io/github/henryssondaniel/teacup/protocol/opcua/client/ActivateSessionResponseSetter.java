package io.github.henryssondaniel.teacup.protocol.opcua.client;

interface ActivateSessionResponseSetter extends ActivateSessionResponse, ResponseSetter {
  void setDiagnosticInfos(DiagnosticInfo... diagnosticInfos);

  void setResults(long... results);

  void setServerNonce(byte... serverNonce);
}
