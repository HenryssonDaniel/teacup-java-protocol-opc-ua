package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.SIGNATURE;

import java.util.logging.Level;
import java.util.logging.Logger;

class SignedSoftwareCertificateImpl implements SignedSoftwareCertificate {
  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(
          SignedSoftwareCertificateImpl.class);
  private final byte[] certificateData;
  private final byte[] signature;

  SignedSoftwareCertificateImpl(byte[] certificateData, byte... signature) {
    this.certificateData = certificateData.clone();
    this.signature = signature.clone();
  }

  @Override
  public byte[] getCertificateData() {
    LOGGER.log(Level.FINE, "Get certificate data");
    return certificateData.clone();
  }

  @Override
  public byte[] getSignature() {
    LOGGER.log(Level.FINE, SIGNATURE);
    return signature.clone();
  }
}
