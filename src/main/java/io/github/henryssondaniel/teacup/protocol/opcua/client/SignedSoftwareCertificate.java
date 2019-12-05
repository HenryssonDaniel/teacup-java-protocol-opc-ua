package io.github.henryssondaniel.teacup.protocol.opcua.client;

/**
 * Signed software certificate.
 *
 * @since 1.0
 */
public interface SignedSoftwareCertificate {
  /**
   * Returns the certificate data.
   *
   * @return the certificate data
   */
  byte[] getCertificateData();

  /**
   * Returns the signature.
   *
   * @return the signature
   */
  byte[] getSignature();
}
