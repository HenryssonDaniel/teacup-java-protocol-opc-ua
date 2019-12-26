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

  @Mock private ActivateSessionResponseSetter implementation;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void createImplementation() {
    assertThat(new ActivateSessionResponseBuilderImpl().createImplementation())
        .isExactlyInstanceOf(ActivateSessionResponseImpl.class);
  }

  @Test
  void setBinaryEncodingId() {
    assertThat(activateSessionResponseBuilder.setBinaryEncodingId(nodeId))
        .isSameAs(activateSessionResponseBuilder);

    verify(implementation).setBinaryEncodingId(nodeId);
    verifyNoMoreInteractions(implementation);

    verifyNoInteractions(nodeId);
  }

  @Test
  void setDiagnosticInfos() {
    var diagnosticInfo = mock(DiagnosticInfo.class);

    assertThat(activateSessionResponseBuilder.setDiagnosticInfos(diagnosticInfo))
        .isSameAs(activateSessionResponseBuilder);

    verify(implementation).setDiagnosticInfos(diagnosticInfo);
    verifyNoMoreInteractions(implementation);

    verifyNoInteractions(diagnosticInfo);
  }

  @Test
  void setResults() {
    var statusCode = 1;

    assertThat(activateSessionResponseBuilder.setResults(statusCode))
        .isSameAs(activateSessionResponseBuilder);

    verify(implementation).setResults(statusCode);
    verifyNoMoreInteractions(implementation);
  }

  @Test
  void setServerNonce() {
    var serverNonce = (byte) 1;
    assertThat(activateSessionResponseBuilder.setServerNonce(serverNonce))
        .isSameAs(activateSessionResponseBuilder);

    verify(implementation).setServerNonce(serverNonce);
    verifyNoMoreInteractions(implementation);
  }

  @Test
  void setTypeId() {
    assertThat(activateSessionResponseBuilder.setTypeId(nodeId))
        .isSameAs(activateSessionResponseBuilder);

    verify(implementation).setTypeId(nodeId);
    verifyNoMoreInteractions(implementation);

    verifyNoInteractions(nodeId);
  }

  @Test
  void setXmlEncodingId() {
    assertThat(activateSessionResponseBuilder.setXmlEncodingId(nodeId))
        .isSameAs(activateSessionResponseBuilder);

    verify(implementation).setXmlEncodingId(nodeId);
    verifyNoMoreInteractions(implementation);

    verifyNoInteractions(nodeId);
  }
}
