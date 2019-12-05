package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.LOCALE_ID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
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

  @Mock private ActivateSessionRequestSetter activateSessionRequestSetter;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void build() {
    assertThat(activateSessionRequestBuilder.build()).isSameAs(activateSessionRequestSetter);
    verifyNoInteractions(activateSessionRequestSetter);
  }

  @Test
  void setClientSignature() {
    assertThat(activateSessionRequestBuilder.setClientSignature(signatureData))
        .isSameAs(activateSessionRequestBuilder);

    verify(activateSessionRequestSetter).setClientSignature(signatureData);
    verifyNoMoreInteractions(activateSessionRequestSetter);
  }

  @Test
  void setClientSoftwareCertificates() {
    var signedSoftwareCertificate = mock(SignedSoftwareCertificate.class);

    assertThat(
            activateSessionRequestBuilder.setClientSoftwareCertificates(signedSoftwareCertificate))
        .isSameAs(activateSessionRequestBuilder);

    verify(activateSessionRequestSetter).setClientSoftwareCertificates(signedSoftwareCertificate);
    verifyNoMoreInteractions(activateSessionRequestSetter);
  }

  @Test
  void setLocaleIds() {
    assertThat(activateSessionRequestBuilder.setLocaleIds(LOCALE_ID))
        .isSameAs(activateSessionRequestBuilder);

    verify(activateSessionRequestSetter).setLocaleIds(LOCALE_ID);
    verifyNoMoreInteractions(activateSessionRequestSetter);
  }

  @Test
  void setRequestHeader() {
    var requestHeader = mock(RequestHeader.class);

    assertThat(activateSessionRequestBuilder.setRequestHeader(requestHeader))
        .isSameAs(activateSessionRequestBuilder);

    verify(activateSessionRequestSetter).setRequestHeader(requestHeader);
    verifyNoMoreInteractions(activateSessionRequestSetter);
  }

  @Test
  void setUserIdentityToken() {
    var extensionObject = mock(ExtensionObject.class);

    assertThat(activateSessionRequestBuilder.setUserIdentityToken(extensionObject))
        .isSameAs(activateSessionRequestBuilder);

    verify(activateSessionRequestSetter).setUserIdentityToken(extensionObject);
    verifyNoMoreInteractions(activateSessionRequestSetter);
  }

  @Test
  void setUserTokenSignature() {
    assertThat(activateSessionRequestBuilder.setUserTokenSignature(signatureData))
        .isSameAs(activateSessionRequestBuilder);

    verify(activateSessionRequestSetter).setUserTokenSignature(signatureData);
    verifyNoMoreInteractions(activateSessionRequestSetter);
  }
}
