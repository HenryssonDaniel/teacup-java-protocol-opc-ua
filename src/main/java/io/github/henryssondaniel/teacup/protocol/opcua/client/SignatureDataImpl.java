package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.SIGNATURE;

import java.util.logging.Level;
import java.util.logging.Logger;

class SignatureDataImpl implements SignatureData {
  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(SignatureDataImpl.class);

  private final String algorithm;
  private final byte[] signature;

  SignatureDataImpl(String algorithm, byte... signature) {
    this.algorithm = algorithm;
    this.signature = signature.clone();
  }

  @Override
  public String getAlgorithm() {
    return algorithm;
  }

  @Override
  public byte[] getSignature() {
    LOGGER.log(Level.FINE, SIGNATURE);
    return signature.clone();
  }
}
