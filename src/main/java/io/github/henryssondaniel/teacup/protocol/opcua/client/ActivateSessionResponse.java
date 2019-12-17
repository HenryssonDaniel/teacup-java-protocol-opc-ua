package io.github.henryssondaniel.teacup.protocol.opcua.client;

/**
 * Activate session response.
 *
 * @since 1.0
 */
public interface ActivateSessionResponse extends Response {
  /**
   * Returns the binary encoding ID.
   *
   * @return the binary encoding ID
   */
  NodeId getBinaryEncodingId();

  /**
   * Returns the diagnostic info's.
   *
   * @return the diagnostic info's
   */
  DiagnosticInfo[] getDiagnosticInfos();

  /**
   * Returns the response header.
   *
   * @return the response header
   */
  ResponseHeader getResponseHeader();

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

  /**
   * Returns the type ID.
   *
   * @return the type ID
   */
  NodeId getTypeId();

  /**
   * Returns the XML encoding ID.
   *
   * @return the XML encoding ID
   */
  NodeId getXmlEncodingId();
}
