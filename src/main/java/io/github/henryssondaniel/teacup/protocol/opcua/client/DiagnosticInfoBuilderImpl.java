package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.BUILD;

import java.util.logging.Level;
import java.util.logging.Logger;

class DiagnosticInfoBuilderImpl implements DiagnosticInfoBuilder {
  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(
          DiagnosticInfoBuilderImpl.class);
  private DiagnosticInfoSetter diagnosticInfoSetter = new DiagnosticInfoImpl();

  @Override
  public DiagnosticInfo build() {
    LOGGER.log(Level.FINE, BUILD);

    var diagnosticInfo = diagnosticInfoSetter;
    diagnosticInfoSetter = new DiagnosticInfoImpl();

    return diagnosticInfo;
  }

  @Override
  public DiagnosticInfoBuilder setAdditionalInfo(String additionalInfo) {
    LOGGER.log(Level.FINE, "Set additional info");
    diagnosticInfoSetter.setAdditionalInfo(additionalInfo);
    return this;
  }

  @Override
  public DiagnosticInfoBuilder setInnerDiagnosticInfo(DiagnosticInfo innerDiagnosticInfo) {
    LOGGER.log(Level.FINE, "Set inner diagnostic info");
    diagnosticInfoSetter.setInnerDiagnosticInfo(innerDiagnosticInfo);
    return this;
  }

  @Override
  public DiagnosticInfoBuilder setInnerStatusCode(StatusCode innerStatusCode) {
    LOGGER.log(Level.FINE, "Set inner status code");
    diagnosticInfoSetter.setInnerStatusCode(innerStatusCode);
    return this;
  }

  @Override
  public DiagnosticInfoBuilder setLocale(int locale) {
    LOGGER.log(Level.FINE, "Set locale");
    diagnosticInfoSetter.setLocale(locale);
    return this;
  }

  @Override
  public DiagnosticInfoBuilder setLocalizedText(int localizedText) {
    LOGGER.log(Level.FINE, "Set localized text");
    diagnosticInfoSetter.setLocalizedText(localizedText);
    return this;
  }

  @Override
  public DiagnosticInfoBuilder setNamespaceUri(int namespaceUri) {
    LOGGER.log(Level.FINE, "Set namespace URI");
    diagnosticInfoSetter.setNamespaceUri(namespaceUri);
    return this;
  }

  @Override
  public DiagnosticInfoBuilder setSymbolicId(int symbolicId) {
    LOGGER.log(Level.FINE, "Set symbolic ID");
    diagnosticInfoSetter.setSymbolicId(symbolicId);
    return this;
  }
}
