package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class RequestBuilderImplTest {
  @InjectMocks
  private final ActivateSessionRequestBuilder activateSessionRequestBuilder =
      new ActivateSessionRequestBuilderImpl();

  @Mock private ActivateSessionRequestSetter activateSessionRequestSetter;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void setRequestHeader() {
    var requestHeader = mock(RequestHeader.class);

    assertThat(activateSessionRequestBuilder.setRequestHeader(requestHeader))
        .isSameAs(activateSessionRequestBuilder);

    verify(activateSessionRequestSetter).setRequestHeader(requestHeader);
    verifyNoMoreInteractions(activateSessionRequestSetter);
  }
}
