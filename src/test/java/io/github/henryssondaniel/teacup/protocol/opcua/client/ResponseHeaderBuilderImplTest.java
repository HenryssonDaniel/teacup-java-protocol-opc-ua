package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.STRING_TABLE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.time.Instant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ResponseHeaderBuilderImplTest {
  private final NodeId nodeId = mock(NodeId.class);

  @InjectMocks
  private final ResponseHeaderBuilder responseHeaderBuilder = new ResponseHeaderBuilderImpl();

  @Mock private ResponseHeaderSetter responseHeaderSetter;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void build() {
    assertThat(responseHeaderBuilder.build()).isSameAs(responseHeaderSetter);
    verifyNoInteractions(responseHeaderSetter);
  }

  @Test
  void setAdditionalHeader() {
    var extensionObject = mock(ExtensionObject.class);
    assertThat(responseHeaderBuilder.setAdditionalHeader(extensionObject))
        .isSameAs(responseHeaderBuilder);

    verifyNoInteractions(extensionObject);

    verify(responseHeaderSetter).setAdditionalHeader(extensionObject);
    verifyNoMoreInteractions(responseHeaderSetter);
  }

  @Test
  void setBinaryEncodingId() {
    assertThat(responseHeaderBuilder.setBinaryEncodingId(nodeId)).isSameAs(responseHeaderBuilder);

    verifyNoInteractions(nodeId);

    verify(responseHeaderSetter).setBinaryEncodingId(nodeId);
    verifyNoMoreInteractions(responseHeaderSetter);
  }

  @Test
  void setClientSignature() {
    var extensionObject = mock(ExtensionObject.class);
    assertThat(responseHeaderBuilder.setAdditionalHeader(extensionObject))
        .isSameAs(responseHeaderBuilder);

    verify(responseHeaderSetter).setAdditionalHeader(extensionObject);
    verifyNoMoreInteractions(responseHeaderSetter);
  }

  @Test
  void setRequestHandle() {
    assertThat(responseHeaderBuilder.setRequestHandle(1)).isSameAs(responseHeaderBuilder);

    verify(responseHeaderSetter).setRequestHandle(1);
    verifyNoMoreInteractions(responseHeaderSetter);
  }

  @Test
  void setServiceDiagnostics() {
    var diagnosticInfo = mock(DiagnosticInfo.class);
    assertThat(responseHeaderBuilder.setServiceDiagnostics(diagnosticInfo))
        .isSameAs(responseHeaderBuilder);

    verifyNoInteractions(diagnosticInfo);

    verify(responseHeaderSetter).setServiceDiagnostics(diagnosticInfo);
    verifyNoMoreInteractions(responseHeaderSetter);
  }

  @Test
  void setServiceResult() {
    var statusCode = mock(StatusCode.class);
    assertThat(responseHeaderBuilder.setServiceResult(statusCode)).isSameAs(responseHeaderBuilder);

    verify(responseHeaderSetter).setServiceResult(statusCode);
    verifyNoMoreInteractions(responseHeaderSetter);

    verifyNoInteractions(statusCode);
  }

  @Test
  void setStringTable() {
    assertThat(responseHeaderBuilder.setStringTable(STRING_TABLE)).isSameAs(responseHeaderBuilder);

    verify(responseHeaderSetter).setStringTable(STRING_TABLE);
    verifyNoMoreInteractions(responseHeaderSetter);
  }

  @Test
  void setTimestamp() {
    var instant = Instant.now();
    assertThat(responseHeaderBuilder.setTimestamp(instant)).isSameAs(responseHeaderBuilder);

    verify(responseHeaderSetter).setTimestamp(instant);
    verifyNoMoreInteractions(responseHeaderSetter);
  }

  @Test
  void setTypeId() {
    assertThat(responseHeaderBuilder.setTypeId(nodeId)).isSameAs(responseHeaderBuilder);

    verifyNoInteractions(nodeId);

    verify(responseHeaderSetter).setTypeId(nodeId);
    verifyNoMoreInteractions(responseHeaderSetter);
  }

  @Test
  void setXmlEncodingId() {
    assertThat(responseHeaderBuilder.setXmlEncodingId(nodeId)).isSameAs(responseHeaderBuilder);

    verifyNoInteractions(nodeId);

    verify(responseHeaderSetter).setXmlEncodingId(nodeId);
    verifyNoMoreInteractions(responseHeaderSetter);
  }
}
