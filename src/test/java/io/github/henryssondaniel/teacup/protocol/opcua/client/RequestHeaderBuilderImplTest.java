package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.AUDIT_ENTRY_ID;
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

class RequestHeaderBuilderImplTest {
  @InjectMocks
  private final RequestHeaderBuilder requestHeaderBuilder = new RequestHeaderBuilderImpl();

  @Mock private RequestHeaderSetter requestHeaderSetter;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void build() {
    assertThat(requestHeaderBuilder.build()).isSameAs(requestHeaderSetter);
    verifyNoInteractions(requestHeaderSetter);
  }

  @Test
  void setAuditEntryId() {
    assertThat(requestHeaderBuilder.setAuditEntryId(AUDIT_ENTRY_ID)).isSameAs(requestHeaderBuilder);

    verify(requestHeaderSetter).setAuditEntryId(AUDIT_ENTRY_ID);
    verifyNoMoreInteractions(requestHeaderSetter);
  }

  @Test
  void setAuthenticationToken() {
    var nodeId = mock(NodeId.class);
    assertThat(requestHeaderBuilder.setAuthenticationToken(nodeId)).isSameAs(requestHeaderBuilder);

    verify(requestHeaderSetter).setAuthenticationToken(nodeId);
    verifyNoMoreInteractions(requestHeaderSetter);
  }

  @Test
  void setClientSignature() {
    var extensionObject = mock(ExtensionObject.class);
    assertThat(requestHeaderBuilder.setAdditionalHeader(extensionObject))
        .isSameAs(requestHeaderBuilder);

    verify(requestHeaderSetter).setAdditionalHeader(extensionObject);
    verifyNoMoreInteractions(requestHeaderSetter);
  }

  @Test
  void setRequestHandle() {
    assertThat(requestHeaderBuilder.setRequestHandle(1)).isSameAs(requestHeaderBuilder);

    verify(requestHeaderSetter).setRequestHandle(1);
    verifyNoMoreInteractions(requestHeaderSetter);
  }

  @Test
  void setReturnDiagnostics() {
    assertThat(requestHeaderBuilder.setReturnDiagnostics(1)).isSameAs(requestHeaderBuilder);

    verify(requestHeaderSetter).setReturnDiagnostics(1);
    verifyNoMoreInteractions(requestHeaderSetter);
  }

  @Test
  void setTimeoutHint() {
    assertThat(requestHeaderBuilder.setTimeoutHint(1)).isSameAs(requestHeaderBuilder);

    verify(requestHeaderSetter).setTimeoutHint(1);
    verifyNoMoreInteractions(requestHeaderSetter);
  }

  @Test
  void setTimestamp() {
    var instant = Instant.now();
    assertThat(requestHeaderBuilder.setTimestamp(instant)).isSameAs(requestHeaderBuilder);

    verify(requestHeaderSetter).setTimestamp(instant);
    verifyNoMoreInteractions(requestHeaderSetter);
  }
}
