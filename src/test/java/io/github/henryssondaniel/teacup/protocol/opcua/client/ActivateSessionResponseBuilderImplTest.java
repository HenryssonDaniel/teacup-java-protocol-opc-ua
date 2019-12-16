package io.github.henryssondaniel.teacup.protocol.opcua.client;

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

class ActivateSessionResponseBuilderImplTest {
  @InjectMocks
  private final ActivateSessionResponseBuilder activateSessionResponseBuilder =
      new ActivateSessionResponseBuilderImpl();

  private final NodeId nodeId = mock(NodeId.class);

  @Mock private ActivateSessionResponseSetter activateSessionResponseSetter;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void build() {
    assertThat(activateSessionResponseBuilder.build()).isSameAs(activateSessionResponseSetter);
    verifyNoInteractions(activateSessionResponseSetter);
  }

  @Test
  void setBinaryEncodingId() {
    assertThat(activateSessionResponseBuilder.setBinaryEncodingId(nodeId))
        .isSameAs(activateSessionResponseBuilder);

    verify(activateSessionResponseSetter).setBinaryEncodingId(nodeId);
    verifyNoMoreInteractions(activateSessionResponseSetter);

    verifyNoInteractions(nodeId);
  }

  @Test
  void setDiagnosticInfos() {
    var diagnosticInfo = mock(DiagnosticInfo.class);

    assertThat(activateSessionResponseBuilder.setDiagnosticInfos(diagnosticInfo))
        .isSameAs(activateSessionResponseBuilder);

    verify(activateSessionResponseSetter).setDiagnosticInfos(diagnosticInfo);
    verifyNoMoreInteractions(activateSessionResponseSetter);

    verifyNoInteractions(diagnosticInfo);
  }

  @Test
  void setResponseHeader() {
    var responseHeader = mock(ResponseHeader.class);

    assertThat(activateSessionResponseBuilder.setResponseHeader(responseHeader))
        .isSameAs(activateSessionResponseBuilder);

    verify(activateSessionResponseSetter).setResponseHeader(responseHeader);
    verifyNoMoreInteractions(activateSessionResponseSetter);

    verifyNoInteractions(responseHeader);
  }

  @Test
  void setResults() {
    var statusCode = mock(StatusCode.class);

    assertThat(activateSessionResponseBuilder.setResults(statusCode))
        .isSameAs(activateSessionResponseBuilder);

    verify(activateSessionResponseSetter).setResults(statusCode);
    verifyNoMoreInteractions(activateSessionResponseSetter);

    verifyNoInteractions(statusCode);
  }

  @Test
  void setServerNonce() {
    var serverNonce = (byte) 1;
    assertThat(activateSessionResponseBuilder.setServerNonce(serverNonce))
        .isSameAs(activateSessionResponseBuilder);

    verify(activateSessionResponseSetter).setServerNonce(serverNonce);
    verifyNoMoreInteractions(activateSessionResponseSetter);
  }

  @Test
  void setTypeId() {
    assertThat(activateSessionResponseBuilder.setTypeId(nodeId))
        .isSameAs(activateSessionResponseBuilder);

    verify(activateSessionResponseSetter).setTypeId(nodeId);
    verifyNoMoreInteractions(activateSessionResponseSetter);

    verifyNoInteractions(nodeId);
  }

  @Test
  void setXmlEncodingId() {
    assertThat(activateSessionResponseBuilder.setXmlEncodingId(nodeId))
        .isSameAs(activateSessionResponseBuilder);

    verify(activateSessionResponseSetter).setXmlEncodingId(nodeId);
    verifyNoMoreInteractions(activateSessionResponseSetter);

    verifyNoInteractions(nodeId);
  }
}
