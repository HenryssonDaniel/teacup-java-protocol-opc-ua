package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoInteractions;

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
}
