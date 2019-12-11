package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NodeIdImplTest {
  private static final short NAMESPACE_INDEX = 1;
  private static final String TEST = "test";

  @Test
  void getIdentifier() {
    assertThat(new NodeIdImpl(TEST, NAMESPACE_INDEX).getIdentifier()).isEqualTo(TEST);
  }

  @Test
  void getNamespaceIndex() {
    assertThat(new NodeIdImpl(TEST, NAMESPACE_INDEX).getNamespaceIndex())
        .isEqualTo(NAMESPACE_INDEX);
  }
}
