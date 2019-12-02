package io.github.henryssondaniel.teacup.protocol.opcua.client;

import io.github.henryssondaniel.teacup.protocol.opcua.Client;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.milo.opcua.sdk.client.api.UaClient;

class Simple implements Client {
  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(Simple.class);

  private final UaClient uaClient;

  Simple(UaClient uaClient) {
    this.uaClient = uaClient;
  }

  @Override
  public CompletableFuture<Client> connect() {
    LOGGER.log(Level.FINE, "Connect");
    return uaClient.connect().thenApply(client -> this);
  }

  @Override
  public CompletableFuture<Client> disconnect() {
    LOGGER.log(Level.FINE, "Disconnect");
    return uaClient.disconnect().thenApply(client -> this);
  }
}
