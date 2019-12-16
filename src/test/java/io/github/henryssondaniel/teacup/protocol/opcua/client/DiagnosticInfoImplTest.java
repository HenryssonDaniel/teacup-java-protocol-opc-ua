package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.ADDITIONAL_INFO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoInteractions;

import org.junit.jupiter.api.Test;

class DiagnosticInfoImplTest {
  private final DiagnosticInfoSetter diagnosticInfoSetter = new DiagnosticInfoImpl();

  @Test
  void getAdditionalInfo() {
    assertThat(diagnosticInfoSetter.getAdditionalInfo()).isNull();
  }

  @Test
  void getInnerDiagnosticInfo() {
    assertThat(diagnosticInfoSetter.getInnerDiagnosticInfo()).isNull();
  }

  @Test
  void getInnerStatusCode() {
    assertThat(diagnosticInfoSetter.getInnerStatusCode()).isNull();
  }

  @Test
  void getLocale() {
    assertThat(diagnosticInfoSetter.getLocale()).isZero();
  }

  @Test
  void getLocalizedText() {
    assertThat(diagnosticInfoSetter.getLocalizedText()).isZero();
  }

  @Test
  void getNamespaceUri() {
    assertThat(diagnosticInfoSetter.getNamespaceUri()).isZero();
  }

  @Test
  void getSymbolicId() {
    assertThat(diagnosticInfoSetter.getSymbolicId()).isZero();
  }

  @Test
  void setAndGetAdditionalInfo() {
    diagnosticInfoSetter.setAdditionalInfo(ADDITIONAL_INFO);
    assertThat(diagnosticInfoSetter.getAdditionalInfo()).isEqualTo(ADDITIONAL_INFO);
  }

  @Test
  void setAndGetInnerDiagnosticInfo() {
    var diagnosticInfo = mock(DiagnosticInfo.class);

    diagnosticInfoSetter.setInnerDiagnosticInfo(diagnosticInfo);
    assertThat(diagnosticInfoSetter.getInnerDiagnosticInfo()).isSameAs(diagnosticInfo);

    verifyNoInteractions(diagnosticInfo);
  }

  @Test
  void setAndGetInnerStatusCode() {
    var statusCode = mock(StatusCode.class);

    diagnosticInfoSetter.setInnerStatusCode(statusCode);
    assertThat(diagnosticInfoSetter.getInnerStatusCode()).isSameAs(statusCode);

    verifyNoInteractions(statusCode);
  }

  @Test
  void setAndGetLocale() {
    diagnosticInfoSetter.setLocale(1);
    assertThat(diagnosticInfoSetter.getLocale()).isOne();
  }

  @Test
  void setAndGetLocalizedText() {
    diagnosticInfoSetter.setLocalizedText(1);
    assertThat(diagnosticInfoSetter.getLocalizedText()).isOne();
  }

  @Test
  void setAndGetNamespaceUri() {
    diagnosticInfoSetter.setNamespaceUri(1);
    assertThat(diagnosticInfoSetter.getNamespaceUri()).isOne();
  }

  @Test
  void setAndGetSymbolicId() {
    diagnosticInfoSetter.setSymbolicId(1);
    assertThat(diagnosticInfoSetter.getSymbolicId()).isOne();
  }
}
