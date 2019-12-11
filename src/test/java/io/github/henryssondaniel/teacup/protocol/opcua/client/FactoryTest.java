package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.IDENTIFIER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoInteractions;

import java.util.UUID;
import org.junit.jupiter.api.Test;

class FactoryTest {
  private static final String URI = "http://opcfoundation.org/UA-Profile/Transport/https-ua";
  private final NodeId nodeId = mock(NodeId.class);

  @Test
  void createActivateSessionRequestBuilder() {
    assertThat(Factory.createActivateSessionRequestBuilder())
        .isExactlyInstanceOf(ActivateSessionRequestBuilderImpl.class);
  }

  @Test
  void createClient() throws DefaultException {
    assertThat(Factory.createClient(URI + "binary")).isExactlyInstanceOf(Simple.class);
  }

  @Test
  void createClientWhenException() {
    assertThatExceptionOfType(DefaultException.class)
        .isThrownBy(() -> Factory.createClient(URI + "soapxml"));
  }

  @Test
  void createExtensionObjectWhenByte() {
    assertThat(Factory.createExtensionObject(new byte[] {1, 2}, nodeId))
        .isExactlyInstanceOf(ExtensionObjectImpl.class);
    verifyNoInteractions(nodeId);
  }

  @Test
  void createExtensionObjectWhenString() {
    assertThat(Factory.createExtensionObject("test", nodeId))
        .isExactlyInstanceOf(ExtensionObjectImpl.class);
    verifyNoInteractions(nodeId);
  }

  @Test
  void createNodeIdWhenByteArray() {
    assertThat(Factory.createNodeId(new byte[] {1, 2}, (short) 1))
        .isExactlyInstanceOf(NodeIdImpl.class);
  }

  @Test
  void createNodeIdWhenInteger() {
    assertThat(Factory.createNodeId(1, (short) 1)).isExactlyInstanceOf(NodeIdImpl.class);
  }

  @Test
  void createNodeIdWhenString() {
    assertThat(Factory.createNodeId(IDENTIFIER, (short) 1)).isExactlyInstanceOf(NodeIdImpl.class);
  }

  @Test
  void createNodeIdWhenUuid() {
    assertThat(Factory.createNodeId(UUID.randomUUID(), (short) 1))
        .isExactlyInstanceOf(NodeIdImpl.class);
  }

  @Test
  void createRequestHeaderBuilder() {
    assertThat(Factory.createRequestHeaderBuilder())
        .isExactlyInstanceOf(RequestHeaderBuilderImpl.class);
  }
}
