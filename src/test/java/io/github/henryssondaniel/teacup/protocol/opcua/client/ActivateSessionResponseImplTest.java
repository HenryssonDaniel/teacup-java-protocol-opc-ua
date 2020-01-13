package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

class ActivateSessionResponseImplTest {
  private final ActivateSessionResponseSetter activateSessionResponseSetter =
      new ActivateSessionResponseImpl();

  @Test
  void getDiagnosticInfos() {
    assertThat(activateSessionResponseSetter.getDiagnosticInfos()).isNull();
  }

  @Test
  void getResults() {
    assertThat(activateSessionResponseSetter.getResults()).isNull();
  }

  @Test
  void getServerNonce() {
    assertThat(activateSessionResponseSetter.getServerNonce()).isNull();
  }

  @Test
  void setAndGetDiagnosticInfos() {
    var diagnosticInfo = mock(DiagnosticInfo.class);
    activateSessionResponseSetter.setDiagnosticInfos(diagnosticInfo);
    assertThat(activateSessionResponseSetter.getDiagnosticInfos()).containsExactly(diagnosticInfo);
  }

  @Test
  void setAndGetResults() {
    var statusCode = 1;
    activateSessionResponseSetter.setResults(statusCode);
    assertThat(activateSessionResponseSetter.getResults()).containsExactly(statusCode);
  }

  @Test
  void setAndGetServerNonce() {
    var nonce = (byte) 1;
    activateSessionResponseSetter.setServerNonce(nonce);
    assertThat(activateSessionResponseSetter.getServerNonce()).containsExactly(nonce);
  }
}
