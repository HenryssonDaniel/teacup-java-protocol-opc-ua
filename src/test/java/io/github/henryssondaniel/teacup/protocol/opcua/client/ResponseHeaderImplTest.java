package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.STRING_TABLE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoInteractions;

import java.time.Instant;
import org.junit.jupiter.api.Test;

class ResponseHeaderImplTest {
  private final NodeId nodeId = mock(NodeId.class);
  private final ResponseHeaderSetter responseHeaderSetter = new ResponseHeaderImpl();

  @Test
  void getAdditionalHeader() {
    assertThat(responseHeaderSetter.getAdditionalHeader()).isNull();
  }

  @Test
  void getBinaryEncodingId() {
    assertThat(responseHeaderSetter.getBinaryEncodingId()).isNull();
  }

  @Test
  void getRequestHandle() {
    assertThat(responseHeaderSetter.getRequestHandle()).isZero();
  }

  @Test
  void getServiceDiagnostics() {
    assertThat(responseHeaderSetter.getServiceDiagnostics()).isNull();
  }

  @Test
  void getServiceResult() {
    assertThat(responseHeaderSetter.getServiceResult()).isNull();
  }

  @Test
  void getStringTable() {
    assertThat(responseHeaderSetter.getStringTable()).isNull();
  }

  @Test
  void getTimestamp() {
    assertThat(responseHeaderSetter.getTimestamp()).isNull();
  }

  @Test
  void getTypeId() {
    assertThat(responseHeaderSetter.getTypeId()).isNull();
  }

  @Test
  void getXmlEncodingId() {
    assertThat(responseHeaderSetter.getXmlEncodingId()).isNull();
  }

  @Test
  void setAndGetAdditionalHeader() {
    var extensionObject = mock(ExtensionObject.class);

    responseHeaderSetter.setAdditionalHeader(extensionObject);

    verifyNoInteractions(extensionObject);

    assertThat(responseHeaderSetter.getAdditionalHeader()).isSameAs(extensionObject);
    verifyNoInteractions(extensionObject);
  }

  @Test
  void setAndGetBinaryEncodingId() {
    responseHeaderSetter.setBinaryEncodingId(nodeId);
    assertThat(responseHeaderSetter.getBinaryEncodingId()).isSameAs(nodeId);
    verifyNoInteractions(nodeId);
  }

  @Test
  void setAndGetRequestHandle() {
    responseHeaderSetter.setRequestHandle(1);
    assertThat(responseHeaderSetter.getRequestHandle()).isOne();
  }

  @Test
  void setAndGetServiceDiagnostics() {
    var diagnosticInfo = mock(DiagnosticInfo.class);

    responseHeaderSetter.setServiceDiagnostics(diagnosticInfo);
    assertThat(responseHeaderSetter.getServiceDiagnostics()).isSameAs(diagnosticInfo);

    verifyNoInteractions(diagnosticInfo);
  }

  @Test
  void setAndGetServiceResult() {
    var statusCode = mock(StatusCode.class);

    responseHeaderSetter.setServiceResult(statusCode);
    assertThat(responseHeaderSetter.getServiceResult()).isSameAs(statusCode);

    verifyNoInteractions(statusCode);
  }

  @Test
  void setAndGetStringTable() {
    responseHeaderSetter.setStringTable(STRING_TABLE);
    assertThat(responseHeaderSetter.getStringTable()).containsExactly(STRING_TABLE);
  }

  @Test
  void setAndGetTimestamp() {
    var instant = Instant.now();
    responseHeaderSetter.setTimestamp(instant);
    assertThat(responseHeaderSetter.getTimestamp()).isSameAs(instant);
  }

  @Test
  void setAndGetTypeId() {
    responseHeaderSetter.setTypeId(nodeId);
    assertThat(responseHeaderSetter.getTypeId()).isSameAs(nodeId);
    verifyNoInteractions(nodeId);
  }

  @Test
  void setAndGetXmlEncodingId() {
    responseHeaderSetter.setXmlEncodingId(nodeId);
    assertThat(responseHeaderSetter.getXmlEncodingId()).isSameAs(nodeId);
    verifyNoInteractions(nodeId);
  }
}
