package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

class RequestImplTest {
  private final RequestSetter requestSetter = new RequestImpl();

  @Test
  void getRequestHeader() {
    assertThat(requestSetter.getRequestHeader()).isNull();
  }

  @Test
  void setAndGetRequestHeader() {
    var requestHeader = mock(RequestHeader.class);
    requestSetter.setRequestHeader(requestHeader);
    assertThat(requestSetter.getRequestHeader()).isSameAs(requestHeader);
  }
}
