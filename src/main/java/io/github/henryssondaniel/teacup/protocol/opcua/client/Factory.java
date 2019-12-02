package io.github.henryssondaniel.teacup.protocol.opcua.client;

import io.github.henryssondaniel.teacup.protocol.opcua.Client;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfigBuilder;
import org.eclipse.milo.opcua.stack.core.UaException;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;

/**
 * Factory class for the client package.
 *
 * @since 1.0
 */
public enum Factory {
  ;

  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(Factory.class);

  /**
   * Creates a new {@link Client}.
   *
   * @param transportProfileUri the transport profile URI
   * @return the client the client
   * @throws DefaultException If an exception occur while creating the client
   * @since 1.0
   */
  public static Client createClient(String transportProfileUri) throws DefaultException {
    LOGGER.log(Level.FINE, "Creating a new client");

    try {
      return new Simple(
          OpcUaClient.create(
              new OpcUaClientConfigBuilder()
                  .setEndpoint(
                      new EndpointDescription(
                          null, null, null, null, null, null, transportProfileUri, null))
                  .build()));
    } catch (UaException uaException) {
      throw new DefaultException("Could not create the client", uaException);
    }
  }
}
