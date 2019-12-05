package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.nio.charset.Charset;
import org.junit.jupiter.api.Test;

class ExtensionObjectImplTest {
  private static final String TEST = "test";
  private static final byte[] BYTES = TEST.getBytes(Charset.defaultCharset());

  private final NodeId nodeId = mock(NodeId.class);

  @Test
  void getBody() {
    assertThat(createExtensionObject().getBody()).isEqualTo(TEST);
  }

  @Test
  void getBodyWhenByte() {
    assertThat(createExtensionObjectByte().getBody()).isEqualTo(BYTES);
  }

  @Test
  void getEncodingId() {
    assertThat(createExtensionObject().getEncodingId()).isSameAs(nodeId);
  }

  @Test
  void getEncodingIdWhenByte() {
    assertThat(createExtensionObjectByte().getEncodingId()).isSameAs(nodeId);
  }

  private ExtensionObject createExtensionObject() {
    return new ExtensionObjectImpl(TEST, nodeId);
  }

  private ExtensionObject createExtensionObjectByte() {
    return new ExtensionObjectImpl(BYTES, nodeId);
  }
}
