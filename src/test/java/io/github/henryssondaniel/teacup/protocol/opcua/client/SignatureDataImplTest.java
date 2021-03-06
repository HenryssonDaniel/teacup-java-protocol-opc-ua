package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.ALGORITHM;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SignatureDataImplTest {
  private final byte[] signature = {1, 2};
  private final SignatureData signatureData = new SignatureDataImpl(ALGORITHM, signature);

  @Test
  void getAlgorithm() {
    assertThat(signatureData.getAlgorithm()).isEqualTo(ALGORITHM);
  }

  @Test
  void getSignature() {
    assertThat(signatureData.getSignature()).isEqualTo(signature);
  }
}
