package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.github.henryssondaniel.teacup.protocol.opcua.Client;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.junit.jupiter.api.Test;

class SimpleTest {
  private final OpcUaClient opcUaClient = mock(OpcUaClient.class);
  private final Client client = new Simple(opcUaClient);

  @Test
  void connect() throws ExecutionException, InterruptedException {
    when(opcUaClient.connect()).thenReturn(CompletableFuture.supplyAsync(() -> opcUaClient));
    assertThat(client.connect().get()).isSameAs(client);
  }

  @Test
  void disconnect() throws ExecutionException, InterruptedException {
    when(opcUaClient.disconnect()).thenReturn(CompletableFuture.supplyAsync(() -> opcUaClient));
    assertThat(client.disconnect().get()).isSameAs(client);
  }
}
