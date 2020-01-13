package io.github.henryssondaniel.teacup.protocol.opcua.client;

/**
 * Activate session response.
 *
 * @since 1.0
 */
public interface ActivateSessionResponse extends Response {
  /**
   * Returns the diagnostic info's.
   *
   * @return the diagnostic info's
   */
  DiagnosticInfo[] getDiagnosticInfos();

  /**
   * Returns the results.
   *
   * @return the results
   */
  long[] getResults();

  /**
   * Returns the server nonce.
   *
   * @return the server nonce
   */
  byte[] getServerNonce();
}
