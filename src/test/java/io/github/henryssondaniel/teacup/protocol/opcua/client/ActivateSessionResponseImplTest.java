package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

class ActivateSessionResponseImplTest {
  private final ActivateSessionResponseSetter activateSessionResponseSetter =
      new ActivateSessionResponseImpl();
  private final NodeId nodeId = mock(NodeId.class);

  @Test
  void getBinaryEncodingId() {
    assertThat(activateSessionResponseSetter.getBinaryEncodingId()).isNull();
  }

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
  void getTypeId() {
    assertThat(activateSessionResponseSetter.getTypeId()).isNull();
  }

  @Test
  void getXmlEncodingId() {
    assertThat(activateSessionResponseSetter.getXmlEncodingId()).isNull();
  }

  @Test
  void setAndGetBinaryEncodingId() {
    activateSessionResponseSetter.setBinaryEncodingId(nodeId);
    assertThat(activateSessionResponseSetter.getBinaryEncodingId()).isSameAs(nodeId);
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

  @Test
  void setAndGetTypeId() {
    activateSessionResponseSetter.setTypeId(nodeId);
    assertThat(activateSessionResponseSetter.getTypeId()).isSameAs(nodeId);
  }

  @Test
  void setAndGetXmlEncodingId() {
    activateSessionResponseSetter.setXmlEncodingId(nodeId);
    assertThat(activateSessionResponseSetter.getXmlEncodingId()).isSameAs(nodeId);
  }
}
