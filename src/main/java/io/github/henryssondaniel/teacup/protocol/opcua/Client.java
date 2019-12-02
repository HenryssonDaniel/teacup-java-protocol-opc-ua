package io.github.henryssondaniel.teacup.protocol.opcua;

import java.util.concurrent.CompletableFuture;

/**
 * An OPC UA client.
 *
 * @since 1.0
 */
public interface Client {
  /**
   * Connect.
   *
   * @return the completable future
   */
  CompletableFuture<Client> connect();

  /**
   * Disconnect.
   *
   * @return the completable future
   */
  CompletableFuture<Client> disconnect();
}
