package io.github.henryssondaniel.teacup.protocol.opcua.client;

class DiagnosticInfoImpl implements DiagnosticInfoSetter {
  private String additionalInfo;
  private DiagnosticInfo innerDiagnosticInfo;
  private StatusCode innerStatusCode;
  private int locale;
  private int localizedText;
  private int namespaceUri;
  private int symbolicId;

  @Override
  public String getAdditionalInfo() {
    return additionalInfo;
  }

  @Override
  public DiagnosticInfo getInnerDiagnosticInfo() {
    return innerDiagnosticInfo;
  }

  @Override
  public StatusCode getInnerStatusCode() {
    return innerStatusCode;
  }

  @Override
  public int getLocale() {
    return locale;
  }

  @Override
  public int getLocalizedText() {
    return localizedText;
  }

  @Override
  public int getNamespaceUri() {
    return namespaceUri;
  }

  @Override
  public int getSymbolicId() {
    return symbolicId;
  }

  @Override
  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  @Override
  public void setInnerDiagnosticInfo(DiagnosticInfo innerDiagnosticInfo) {
    this.innerDiagnosticInfo = innerDiagnosticInfo;
  }

  @Override
  public void setInnerStatusCode(StatusCode innerStatusCode) {
    this.innerStatusCode = innerStatusCode;
  }

  @Override
  public void setLocale(int locale) {
    this.locale = locale;
  }

  @Override
  public void setLocalizedText(int localizedText) {
    this.localizedText = localizedText;
  }

  @Override
  public void setNamespaceUri(int namespaceUri) {
    this.namespaceUri = namespaceUri;
  }

  @Override
  public void setSymbolicId(int symbolicId) {
    this.symbolicId = symbolicId;
  }
}
