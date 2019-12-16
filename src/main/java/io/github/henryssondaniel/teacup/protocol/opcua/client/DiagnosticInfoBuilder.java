package io.github.henryssondaniel.teacup.protocol.opcua.client;

import io.github.henryssondaniel.teacup.protocol.Builder;

/**
 * Diagnostic info builder.
 *
 * @since 1.0
 */
public interface DiagnosticInfoBuilder extends Builder<DiagnosticInfo> {
  /**
   * Sets the additional info.
   *
   * @param additionalInfo the additional info
   * @return the diagnostic info builder
   */
  DiagnosticInfoBuilder setAdditionalInfo(String additionalInfo);

  /**
   * Sets the inner diagnostic info.
   *
   * @param innerDiagnosticInfo the inner diagnostic info
   * @return the diagnostic info builder
   */
  DiagnosticInfoBuilder setInnerDiagnosticInfo(DiagnosticInfo innerDiagnosticInfo);

  /**
   * Sets the inner status code.
   *
   * @param innerStatusCode the inner status code
   * @return the diagnostic info builder
   */
  DiagnosticInfoBuilder setInnerStatusCode(StatusCode innerStatusCode);

  /**
   * Sets the locale.
   *
   * @param locale the locale
   * @return the diagnostic info builder
   */
  DiagnosticInfoBuilder setLocale(int locale);

  /**
   * Sets the localized text.
   *
   * @param localizedText the localized text
   * @return the diagnostic info builder
   */
  DiagnosticInfoBuilder setLocalizedText(int localizedText);

  /**
   * Sets the namespace URI.
   *
   * @param namespaceUri the namespace URI
   * @return the diagnostic info builder
   */
  DiagnosticInfoBuilder setNamespaceUri(int namespaceUri);

  /**
   * Sets the symbolic ID.
   *
   * @param symbolicId the symbolic ID
   * @return the diagnostic info builder
   */
  DiagnosticInfoBuilder setSymbolicId(int symbolicId);
}
