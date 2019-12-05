package io.github.henryssondaniel.teacup.protocol.opcua.client;

/**
 * Signature data.
 *
 * @since 1.0
 */
public interface SignatureData {
  /**
   * Returns the algorithm.
   *
   * @return the algorithm
   */
  String getAlgorithm();

  /**
   * Returns the signature.
   *
   * @return the signature
   */
  byte[] getSignature();
}
