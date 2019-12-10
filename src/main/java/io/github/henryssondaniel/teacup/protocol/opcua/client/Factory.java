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

  private static final String EXTENSION_OBJECT = "Create extension object";
  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(Factory.class);

  /**
   * Creates a new activate session request builder.
   *
   * @return the activate session request builder
   */
  public static ActivateSessionRequestBuilder createActivateSessionRequestBuilder() {
    LOGGER.log(Level.FINE, "Create activate session request builder");
    return new ActivateSessionRequestBuilderImpl();
  }

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

  /**
   * Creates a new extension object.
   *
   * @param body the body
   * @param encodingId the encodig ID
   * @return the extension object
   */
  public static ExtensionObject createExtensionObject(byte[] body, NodeId encodingId) {
    LOGGER.log(Level.FINE, EXTENSION_OBJECT);
    return new ExtensionObjectImpl(body, encodingId);
  }

  /**
   * Creates a new extension object.
   *
   * @param body the body
   * @param encodingId the encodig ID
   * @return the extension object
   */
  public static ExtensionObject createExtensionObject(String body, NodeId encodingId) {
    LOGGER.log(Level.FINE, EXTENSION_OBJECT);
    return new ExtensionObjectImpl(body, encodingId);
  }
}
