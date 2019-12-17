package io.github.henryssondaniel.teacup.protocol.opcua.client;

interface DiagnosticInfoSetter extends DiagnosticInfo {
  void setAdditionalInfo(String additionalInfo);

  void setInnerDiagnosticInfo(DiagnosticInfo innerDiagnosticInfo);

  void setInnerStatusCode(long innerStatusCode);

  void setLocale(int locale);

  void setLocalizedText(int localizedText);

  void setNamespaceUri(int namespaceUri);

  void setSymbolicId(int symbolicId);
}
