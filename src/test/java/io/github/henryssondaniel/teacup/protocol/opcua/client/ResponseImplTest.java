package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

class ResponseImplTest {
  private final ResponseSetter responseSetter = new ResponseImpl();

  @Test
  void getResponseHeader() {
    assertThat(responseSetter.getResponseHeader()).isNull();
  }

  @Test
  void setAndGetResponseHeader() {
    var responseHeader = mock(ResponseHeader.class);
    responseSetter.setResponseHeader(responseHeader);
    assertThat(responseSetter.getResponseHeader()).isSameAs(responseHeader);
  }
}
