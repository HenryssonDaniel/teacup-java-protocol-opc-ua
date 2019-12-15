package io.github.henryssondaniel.teacup.protocol.opcua.client;

/**
 * Diagnostic info.
 *
 * @since 1.0
 */
public interface DiagnosticInfo {
  /**
   * Returns the additional info.
   *
   * @return the additional info
   */
  String getAdditionalInfo();

  /**
   * Returns the inner diagnostic info.
   *
   * @return the inner diagnostic info
   */
  DiagnosticInfo getInnerDiagnosticInfo();

  /**
   * Returns the inner status code.
   *
   * @return the inner status code
   */
  StatusCode getInnerStatusCode();

  /**
   * Returns the locale.
   *
   * @return the locale
   */
  int getLocale();

  /**
   * Returns the localized text.
   *
   * @return the localized text
   */
  int getLocalizedText();

  /**
   * Returns the namespace URI
   *
   * @return the namespace URI
   */
  int getNamespaceUri();

  /**
   * Returns the symbolic ID.
   *
   * @return the symbolic ID
   */
  int getSymbolicId();
}
