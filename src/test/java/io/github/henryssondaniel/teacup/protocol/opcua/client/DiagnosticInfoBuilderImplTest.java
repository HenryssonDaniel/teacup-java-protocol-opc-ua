package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.ADDITIONAL_INFO;
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

class DiagnosticInfoBuilderImplTest {
  @InjectMocks
  private final DiagnosticInfoBuilder diagnosticInfoBuilder = new DiagnosticInfoBuilderImpl();

  @Mock private DiagnosticInfoSetter diagnosticInfoSetter;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void build() {
    assertThat(diagnosticInfoBuilder.build()).isSameAs(diagnosticInfoSetter);
    verifyNoInteractions(diagnosticInfoSetter);
  }

  @Test
  void setAdditionalInfo() {
    assertThat(diagnosticInfoBuilder.setAdditionalInfo(ADDITIONAL_INFO))
        .isSameAs(diagnosticInfoBuilder);

    verify(diagnosticInfoSetter).setAdditionalInfo(ADDITIONAL_INFO);
    verifyNoMoreInteractions(diagnosticInfoSetter);
  }

  @Test
  void setInnerDiagnosticInfo() {
    var diagnosticInfo = mock(DiagnosticInfo.class);

    assertThat(diagnosticInfoBuilder.setInnerDiagnosticInfo(diagnosticInfo))
        .isSameAs(diagnosticInfoBuilder);

    verifyNoInteractions(diagnosticInfo);

    verify(diagnosticInfoSetter).setInnerDiagnosticInfo(diagnosticInfo);
    verifyNoMoreInteractions(diagnosticInfoSetter);
  }

  @Test
  void setInnerStatusCode() {
    var statusCode = mock(StatusCode.class);

    assertThat(diagnosticInfoBuilder.setInnerStatusCode(statusCode))
        .isSameAs(diagnosticInfoBuilder);

    verify(diagnosticInfoSetter).setInnerStatusCode(statusCode);
    verifyNoMoreInteractions(diagnosticInfoSetter);

    verifyNoInteractions(statusCode);
  }

  @Test
  void setLocale() {
    var locale = 1;

    assertThat(diagnosticInfoBuilder.setLocale(locale)).isSameAs(diagnosticInfoBuilder);

    verify(diagnosticInfoSetter).setLocale(locale);
    verifyNoMoreInteractions(diagnosticInfoSetter);
  }

  @Test
  void setLocalizedText() {
    var localizedText = 1;

    assertThat(diagnosticInfoBuilder.setLocalizedText(localizedText))
        .isSameAs(diagnosticInfoBuilder);

    verify(diagnosticInfoSetter).setLocalizedText(localizedText);
    verifyNoMoreInteractions(diagnosticInfoSetter);
  }

  @Test
  void setNamespaceUri() {
    var namespaceUri = 1;

    assertThat(diagnosticInfoBuilder.setNamespaceUri(namespaceUri)).isSameAs(diagnosticInfoBuilder);

    verify(diagnosticInfoSetter).setNamespaceUri(namespaceUri);
    verifyNoMoreInteractions(diagnosticInfoSetter);
  }

  @Test
  void setSymbolicId() {
    var symbolicId = 1;

    assertThat(diagnosticInfoBuilder.setSymbolicId(symbolicId)).isSameAs(diagnosticInfoBuilder);

    verify(diagnosticInfoSetter).setSymbolicId(symbolicId);
    verifyNoMoreInteractions(diagnosticInfoSetter);
  }
}
