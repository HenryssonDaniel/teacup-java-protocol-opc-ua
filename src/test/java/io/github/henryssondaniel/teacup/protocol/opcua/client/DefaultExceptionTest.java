package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

class DefaultExceptionTest {
  private static final String MESSAGE = "test";

  private final Throwable throwable = mock(Throwable.class);
  private final Throwable exception = new DefaultException(MESSAGE, throwable);

  @Test
  void getCause() {
    assertThat(exception.getCause()).isSameAs(throwable);
  }

  @Test
  void getMessage() {
    assertThat(exception.getMessage()).isEqualTo(MESSAGE);
  }
}
