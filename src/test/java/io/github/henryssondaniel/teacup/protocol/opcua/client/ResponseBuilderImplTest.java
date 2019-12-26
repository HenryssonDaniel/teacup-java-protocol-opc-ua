package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ResponseBuilderImplTest {
  @InjectMocks
  private final ActivateSessionResponseBuilder activateSessionResponseBuilder =
      new ActivateSessionResponseBuilderImpl();

  @Mock private ActivateSessionResponseSetter implementation;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void setResponseHeader() {
    var responseHeader = mock(ResponseHeader.class);

    assertThat(activateSessionResponseBuilder.setResponseHeader(responseHeader))
        .isSameAs(activateSessionResponseBuilder);

    verify(implementation).setResponseHeader(responseHeader);
    verifyNoMoreInteractions(implementation);

    verifyNoInteractions(responseHeader);
  }
}
