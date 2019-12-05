package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

class DefaultExceptionTest {
  private static final String MESSAGE = "test";
  private final Throwable throwable = mock(Throwable.class);

  @Test
  void getCause() {
    assertThat(new DefaultException(MESSAGE).getCause()).isNull();
  }

  @Test
  void getCauseWithThrowable() {
    assertThat(new DefaultException(MESSAGE, throwable).getCause()).isSameAs(throwable);
  }

  @Test
  void getMessage() {
    assertThat(new DefaultException(MESSAGE).getMessage()).isEqualTo(MESSAGE);
  }

  @Test
  void getMessageWithThrowable() {
    assertThat(new DefaultException(MESSAGE, throwable).getMessage()).isEqualTo(MESSAGE);
  }
}
