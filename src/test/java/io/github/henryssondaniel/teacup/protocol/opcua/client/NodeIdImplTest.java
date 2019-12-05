package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.charset.Charset;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class NodeIdImplTest {
  private static final int INTEGER = 1;
  private static final short NAMESPACE_INDEX = 1;
  private static final String TEST = "test";
  private static final byte[] BYTES = TEST.getBytes(Charset.defaultCharset());
  private static final UUID UUID = java.util.UUID.randomUUID();

  @Test
  void getIdentifierWhenByte() {
    assertThat(new NodeIdImpl(BYTES, NAMESPACE_INDEX).getIdentifier()).isSameAs(BYTES);
  }

  @Test
  void getIdentifierWhenInteger() {
    assertThat(new NodeIdImpl(INTEGER, NAMESPACE_INDEX).getIdentifier()).isSameAs(INTEGER);
  }

  @Test
  void getIdentifierWhenString() {
    assertThat(new NodeIdImpl(TEST, NAMESPACE_INDEX).getIdentifier()).isEqualTo(TEST);
  }

  @Test
  void getIdentifierWhenUuid() {
    assertThat(new NodeIdImpl(UUID, NAMESPACE_INDEX).getIdentifier()).isSameAs(UUID);
  }

  @Test
  void getNamespaceIndexWhenByte() {
    assertThat(new NodeIdImpl(BYTES, NAMESPACE_INDEX).getNamespaceIndex())
        .isEqualTo(NAMESPACE_INDEX);
  }

  @Test
  void getNamespaceIndexWhenInteger() {
    assertThat(new NodeIdImpl(INTEGER, NAMESPACE_INDEX).getNamespaceIndex())
        .isEqualTo(NAMESPACE_INDEX);
  }

  @Test
  void getNamespaceIndexWhenString() {
    assertThat(new NodeIdImpl(TEST, NAMESPACE_INDEX).getNamespaceIndex())
        .isEqualTo(NAMESPACE_INDEX);
  }

  @Test
  void getNamespaceIndexWhenUuid() {
    assertThat(new NodeIdImpl(UUID, NAMESPACE_INDEX).getNamespaceIndex())
        .isEqualTo(NAMESPACE_INDEX);
  }
}
