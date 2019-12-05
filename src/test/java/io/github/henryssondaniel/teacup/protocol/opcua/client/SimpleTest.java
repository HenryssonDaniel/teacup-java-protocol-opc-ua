package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import io.github.henryssondaniel.teacup.protocol.opcua.Client;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.stack.core.serialization.UaRequestMessage;
import org.eclipse.milo.opcua.stack.core.serialization.UaResponseMessage;
import org.junit.jupiter.api.Test;

class SimpleTest {
  private final OpcUaClient opcUaClient = mock(OpcUaClient.class);
  private final Client client = new Simple(opcUaClient);

  @Test
  void connect() throws ExecutionException, InterruptedException {
    when(opcUaClient.connect()).thenReturn(CompletableFuture.supplyAsync(() -> opcUaClient));

    assertThat(client.connect().get()).isSameAs(client);

    verify(opcUaClient).connect();
    verifyNoMoreInteractions(opcUaClient);
  }

  @Test
  void disconnect() throws ExecutionException, InterruptedException {
    when(opcUaClient.disconnect()).thenReturn(CompletableFuture.supplyAsync(() -> opcUaClient));

    assertThat(client.disconnect().get()).isSameAs(client);

    verify(opcUaClient).disconnect();
    verifyNoMoreInteractions(opcUaClient);
  }

  @Test
  void runWhenActivateSessionRequest()
      throws DefaultException, ExecutionException, InterruptedException {
    var uaResponseMessage = mock(UaResponseMessage.class);
    when(opcUaClient.sendRequest(any(UaRequestMessage.class)))
        .thenReturn(CompletableFuture.completedFuture(uaResponseMessage));

    Request request = mock(ActivateSessionRequest.class);

    assertThat(client.sendRequest(request).get()).isNotNull();

    verify(opcUaClient).sendRequest(any(UaRequestMessage.class));
    verifyNoMoreInteractions(opcUaClient);
  }

  @Test
  void runWhenNotSupported() {
    var request = mock(Request.class);
    assertThatExceptionOfType(DefaultException.class).isThrownBy(() -> client.sendRequest(request));
    verifyNoInteractions(opcUaClient);
  }
}
