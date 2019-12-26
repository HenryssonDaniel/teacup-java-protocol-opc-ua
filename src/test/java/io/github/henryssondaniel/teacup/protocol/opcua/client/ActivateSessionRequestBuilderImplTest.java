package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.LOCALE_ID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ActivateSessionRequestBuilderImplTest {
  @InjectMocks
  private final ActivateSessionRequestBuilder activateSessionRequestBuilder =
      new ActivateSessionRequestBuilderImpl();

  private final SignatureData signatureData = mock(SignatureData.class);

  @Mock private ActivateSessionRequestSetter implementation;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void createImplementation() {
    assertThat(new ActivateSessionRequestBuilderImpl().createImplementation())
        .isExactlyInstanceOf(ActivateSessionRequestImpl.class);
  }

  @Test
  void setClientSignature() {
    assertThat(activateSessionRequestBuilder.setClientSignature(signatureData))
        .isSameAs(activateSessionRequestBuilder);

    verify(implementation).setClientSignature(signatureData);
    verifyNoMoreInteractions(implementation);
  }

  @Test
  void setClientSoftwareCertificates() {
    var signedSoftwareCertificate = mock(SignedSoftwareCertificate.class);

    assertThat(
            activateSessionRequestBuilder.setClientSoftwareCertificates(signedSoftwareCertificate))
        .isSameAs(activateSessionRequestBuilder);

    verify(implementation).setClientSoftwareCertificates(signedSoftwareCertificate);
    verifyNoMoreInteractions(implementation);
  }

  @Test
  void setLocaleIds() {
    assertThat(activateSessionRequestBuilder.setLocaleIds(LOCALE_ID))
        .isSameAs(activateSessionRequestBuilder);

    verify(implementation).setLocaleIds(LOCALE_ID);
    verifyNoMoreInteractions(implementation);
  }

  @Test
  void setUserIdentityToken() {
    var extensionObject = mock(ExtensionObject.class);

    assertThat(activateSessionRequestBuilder.setUserIdentityToken(extensionObject))
        .isSameAs(activateSessionRequestBuilder);

    verify(implementation).setUserIdentityToken(extensionObject);
    verifyNoMoreInteractions(implementation);
  }

  @Test
  void setUserTokenSignature() {
    assertThat(activateSessionRequestBuilder.setUserTokenSignature(signatureData))
        .isSameAs(activateSessionRequestBuilder);

    verify(implementation).setUserTokenSignature(signatureData);
    verifyNoMoreInteractions(implementation);
  }
}
