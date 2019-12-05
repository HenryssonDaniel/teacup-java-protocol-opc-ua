package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SignedSoftwareCertificateImplTest {
  private final byte[] certificateData = {1, 2};
  private final byte[] signature = {3, 4};
  private final SignedSoftwareCertificate signedSoftwareCertificate =
      new SignedSoftwareCertificateImpl(certificateData, signature);

  @Test
  void getCertificateData() {
    assertThat(signedSoftwareCertificate.getCertificateData()).isEqualTo(certificateData);
  }

  @Test
  void getSignature() {
    assertThat(signedSoftwareCertificate.getSignature()).isEqualTo(signature);
  }
}
