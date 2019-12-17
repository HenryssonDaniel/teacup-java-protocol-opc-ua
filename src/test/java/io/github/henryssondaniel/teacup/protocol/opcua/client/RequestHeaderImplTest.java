package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.AUDIT_ENTRY_ID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoInteractions;

import java.time.Instant;
import org.junit.jupiter.api.Test;

class RequestHeaderImplTest {
  private final RequestHeaderSetter requestHeaderSetter = new RequestHeaderImpl();

  @Test
  void getAdditionalHeader() {
    assertThat(requestHeaderSetter.getAdditionalHeader()).isNull();
  }

  @Test
  void getAuditEntryId() {
    assertThat(requestHeaderSetter.getAuditEntryId()).isNull();
  }

  @Test
  void getAuthenticationToken() {
    assertThat(requestHeaderSetter.getAuthenticationToken()).isNull();
  }

  @Test
  void getRequestHandle() {
    assertThat(requestHeaderSetter.getRequestHandle()).isZero();
  }

  @Test
  void getReturnDiagnostics() {
    assertThat(requestHeaderSetter.getReturnDiagnostics()).isZero();
  }

  @Test
  void getTimeoutHint() {
    assertThat(requestHeaderSetter.getTimeoutHint()).isZero();
  }

  @Test
  void getTimestamp() {
    assertThat(requestHeaderSetter.getTimestamp()).isNull();
  }

  @Test
  void setAndGetAdditionalHeader() {
    var extensionObject = mock(ExtensionObject.class);

    requestHeaderSetter.setAdditionalHeader(extensionObject);

    assertThat(requestHeaderSetter.getAdditionalHeader()).isSameAs(extensionObject);
    verifyNoInteractions(extensionObject);
  }

  @Test
  void setAndGetAuditEntryId() {
    requestHeaderSetter.setAuditEntryId(AUDIT_ENTRY_ID);
    assertThat(requestHeaderSetter.getAuditEntryId()).isEqualTo(AUDIT_ENTRY_ID);
  }

  @Test
  void setAndGetAuthenticationToken() {
    var nodeId = mock(NodeId.class);
    requestHeaderSetter.setAuthenticationToken(nodeId);
    assertThat(requestHeaderSetter.getAuthenticationToken()).isSameAs(nodeId);
  }

  @Test
  void setAndGetRequestHandle() {
    requestHeaderSetter.setRequestHandle(1);
    assertThat(requestHeaderSetter.getRequestHandle()).isOne();
  }

  @Test
  void setAndGetReturnDiagnostics() {
    requestHeaderSetter.setReturnDiagnostics(1);
    assertThat(requestHeaderSetter.getReturnDiagnostics()).isOne();
  }

  @Test
  void setAndGetTimeoutHint() {
    requestHeaderSetter.setTimeoutHint(1);
    assertThat(requestHeaderSetter.getTimeoutHint()).isOne();
  }

  @Test
  void setAndGetTimestamp() {
    var instant = Instant.now();
    requestHeaderSetter.setTimestamp(instant);
    assertThat(requestHeaderSetter.getTimestamp()).isSameAs(instant);
  }
}
