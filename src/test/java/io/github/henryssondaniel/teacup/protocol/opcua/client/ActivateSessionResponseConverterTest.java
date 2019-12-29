package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.ADDITIONAL_INFO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.nio.charset.Charset;
import org.eclipse.milo.opcua.stack.core.types.builtin.ByteString;
import org.eclipse.milo.opcua.stack.core.types.builtin.DateTime;
import org.eclipse.milo.opcua.stack.core.types.builtin.DiagnosticInfo;
import org.eclipse.milo.opcua.stack.core.types.builtin.ExtensionObject;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.StatusCode;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.structured.ActivateSessionResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.ResponseHeader;
import org.junit.jupiter.api.Test;

class ActivateSessionResponseConverterTest {
  private final ActivateSessionResponse activateSessionResponse =
      mock(ActivateSessionResponse.class);
  private final Converter<?> converter =
      new ActivateSessionResponseConverter(activateSessionResponse);
  private final NodeId nodeId = new NodeId(0, 0);
  private final ResponseHeader responseHeader = mock(ResponseHeader.class);
  private final StatusCode statusCode = new StatusCode(1);
  private final DiagnosticInfo diagnosticInfo =
      new DiagnosticInfo(
          0,
          0,
          0,
          0,
          ADDITIONAL_INFO,
          statusCode,
          new DiagnosticInfo(0, 0, 0, 0, ADDITIONAL_INFO, statusCode, null));

  @Test
  void convert() {
    assertThat(converter.convert()).isExactlyInstanceOf(ActivateSessionResponseImpl.class);
    verifyResponse();
    verifyNoInteractions(responseHeader);
  }

  @Test
  void convertFull() {
    when(responseHeader.getAdditionalHeader())
        .thenReturn(
            new ExtensionObject(new ByteString("".getBytes(Charset.defaultCharset())), nodeId));
    when(responseHeader.getBinaryEncodingId()).thenReturn(nodeId);
    when(responseHeader.getRequestHandle()).thenReturn(UInteger.valueOf(1));
    when(responseHeader.getServiceDiagnostics()).thenReturn(diagnosticInfo);
    when(responseHeader.getServiceResult()).thenReturn(statusCode);
    when(responseHeader.getTimestamp()).thenReturn(new DateTime());
    when(responseHeader.getTypeId()).thenReturn(nodeId);
    when(responseHeader.getXmlEncodingId()).thenReturn(nodeId);

    setResponse();
    assertThat(converter.convert()).isExactlyInstanceOf(ActivateSessionResponseImpl.class);
    verifyResponseWithHeader();
  }

  @Test
  void convertWithoutResponseHeader() {
    setResponse();
    assertThat(converter.convert()).isExactlyInstanceOf(ActivateSessionResponseImpl.class);
    verifyResponseWithHeader();
  }

  @Test
  void log() {
    converter.log();
    verifyNoInteractions(activateSessionResponse);
  }

  private void setResponse() {
    when(activateSessionResponse.getBinaryEncodingId()).thenReturn(nodeId);
    when(activateSessionResponse.getDiagnosticInfos())
        .thenReturn(new DiagnosticInfo[] {diagnosticInfo});
    when(activateSessionResponse.getResponseHeader()).thenReturn(responseHeader);
    when(activateSessionResponse.getResults()).thenReturn(new StatusCode[] {statusCode});
    when(activateSessionResponse.getServerNonce())
        .thenReturn(new ByteString("".getBytes(Charset.defaultCharset())));
    when(activateSessionResponse.getTypeId()).thenReturn(nodeId);
    when(activateSessionResponse.getXmlEncodingId()).thenReturn(nodeId);
  }

  private void verifyResponse() {
    verify(activateSessionResponse).getBinaryEncodingId();
    verify(activateSessionResponse).getDiagnosticInfos();
    verify(activateSessionResponse).getResponseHeader();
    verify(activateSessionResponse).getResults();
    verify(activateSessionResponse).getServerNonce();
    verify(activateSessionResponse).getTypeId();
    verify(activateSessionResponse).getXmlEncodingId();
    verifyNoMoreInteractions(activateSessionResponse);
  }

  private void verifyResponseWithHeader() {
    verifyResponse();

    verify(responseHeader).getAdditionalHeader();
    verify(responseHeader).getBinaryEncodingId();
    verify(responseHeader).getRequestHandle();
    verify(responseHeader).getServiceDiagnostics();
    verify(responseHeader).getServiceResult();
    verify(responseHeader).getStringTable();
    verify(responseHeader).getTimestamp();
    verify(responseHeader).getTypeId();
    verify(responseHeader).getXmlEncodingId();
    verifyNoMoreInteractions(responseHeader);
  }
}
