package io.github.henryssondaniel.teacup.protocol.opcua;

import io.github.henryssondaniel.teacup.protocol.opcua.client.DefaultException;
import io.github.henryssondaniel.teacup.protocol.opcua.client.Request;
import io.github.henryssondaniel.teacup.protocol.opcua.client.Response;
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

  CompletableFuture<Response> sendRequest(Request request) throws DefaultException;
}
