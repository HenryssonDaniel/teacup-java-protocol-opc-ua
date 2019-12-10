package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

class ExtensionObjectImplTest {
  private static final String TEST = "test";

  private final NodeId nodeId = mock(NodeId.class);
  private final ExtensionObject extensionObject = new ExtensionObjectImpl(TEST, nodeId);

  @Test
  void getBody() {
    assertThat(extensionObject.getBody()).isEqualTo(TEST);
  }

  @Test
  void getEncodingId() {
    assertThat(extensionObject.getEncodingId()).isSameAs(nodeId);
  }
}
