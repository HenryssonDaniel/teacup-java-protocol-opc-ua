package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.LOCALE_ID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

class ActivateSessionRequestImplTest {
  private final ActivateSessionRequestSetter activateSessionRequestSetter =
      new ActivateSessionRequestImpl();

  private final SignatureData signatureData = mock(SignatureData.class);

  @Test
  void getClientSignature() {
    assertThat(activateSessionRequestSetter.getClientSignature()).isNull();
  }

  @Test
  void getClientSoftwareCertificates() {
    assertThat(activateSessionRequestSetter.getClientSoftwareCertificates()).isNull();
  }

  @Test
  void getLocaleIds() {
    assertThat(activateSessionRequestSetter.getLocaleIds()).isNull();
  }

  @Test
  void getRequestHeader() {
    assertThat(activateSessionRequestSetter.getRequestHeader()).isNull();
  }

  @Test
  void getUserIdentityToken() {
    assertThat(activateSessionRequestSetter.getUserIdentityToken()).isNull();
  }

  @Test
  void getUserTokenSignature() {
    assertThat(activateSessionRequestSetter.getUserTokenSignature()).isNull();
  }

  @Test
  void setAndGetClientSignature() {
    activateSessionRequestSetter.setClientSignature(signatureData);
    assertThat(activateSessionRequestSetter.getClientSignature()).isSameAs(signatureData);
  }

  @Test
  void setAndGetClientSoftwareCertificates() {
    var signedSoftwareCertificate = mock(SignedSoftwareCertificate.class);
    activateSessionRequestSetter.setClientSoftwareCertificates(signedSoftwareCertificate);
    assertThat(activateSessionRequestSetter.getClientSoftwareCertificates())
        .containsExactly(signedSoftwareCertificate);
  }

  @Test
  void setAndGetLocaleIds() {
    activateSessionRequestSetter.setLocaleIds(LOCALE_ID);
    assertThat(activateSessionRequestSetter.getLocaleIds()).containsExactly(LOCALE_ID);
  }

  @Test
  void setAndGetRequestHeader() {
    var requestHeader = mock(RequestHeader.class);
    activateSessionRequestSetter.setRequestHeader(requestHeader);
    assertThat(activateSessionRequestSetter.getRequestHeader()).isSameAs(requestHeader);
  }

  @Test
  void setAndGetUserIdentityToken() {
    var extensionObject = mock(ExtensionObject.class);
    activateSessionRequestSetter.setUserIdentityToken(extensionObject);
    assertThat(activateSessionRequestSetter.getUserIdentityToken()).isSameAs(extensionObject);
  }

  @Test
  void setAndGetUserTokenSignature() {
    activateSessionRequestSetter.setUserTokenSignature(signatureData);
    assertThat(activateSessionRequestSetter.getUserTokenSignature()).isSameAs(signatureData);
  }
}
