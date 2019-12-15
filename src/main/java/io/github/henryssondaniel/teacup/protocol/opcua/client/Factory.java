package io.github.henryssondaniel.teacup.protocol.opcua.client;

import io.github.henryssondaniel.teacup.protocol.opcua.Client;
import java.util.UUID;
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

  public static final String NODE_ID = "Create node ID";
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
   * @param encodingId the encoding ID
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
   * @param encodingId the encoding ID
   * @return the extension object
   */
  public static ExtensionObject createExtensionObject(String body, NodeId encodingId) {
    LOGGER.log(Level.FINE, EXTENSION_OBJECT);
    return new ExtensionObjectImpl(body, encodingId);
  }

  /**
   * Creates a new node ID.
   *
   * @param identifier the identifier
   * @param namespaceIndex the namespace index
   * @return the node ID
   */
  public static NodeId createNodeId(String identifier, short namespaceIndex) {
    LOGGER.log(Level.FINE, NODE_ID);
    return new NodeIdImpl(identifier, namespaceIndex);
  }

  /**
   * Creates a new node ID.
   *
   * @param identifier the identifier
   * @param namespaceIndex the namespace index
   * @return the node ID
   */
  public static NodeId createNodeId(int identifier, short namespaceIndex) {
    LOGGER.log(Level.FINE, NODE_ID);
    return new NodeIdImpl(identifier, namespaceIndex);
  }

  /**
   * Creates a new node ID.
   *
   * @param identifier the identifier
   * @param namespaceIndex the namespace index
   * @return the node ID
   */
  public static NodeId createNodeId(byte[] identifier, short namespaceIndex) {
    LOGGER.log(Level.FINE, NODE_ID);
    return new NodeIdImpl(identifier, namespaceIndex);
  }

  /**
   * Creates a new node ID.
   *
   * @param identifier the identifier
   * @param namespaceIndex the namespace index
   * @return the node ID
   */
  public static NodeId createNodeId(UUID identifier, short namespaceIndex) {
    LOGGER.log(Level.FINE, NODE_ID);
    return new NodeIdImpl(identifier, namespaceIndex);
  }

  /**
   * Creates a new request header builder.
   *
   * @return the request header builder
   */
  public static RequestHeaderBuilder createRequestHeaderBuilder() {
    LOGGER.log(Level.FINE, "Create request header builder");
    return new RequestHeaderBuilderImpl();
  }

  /**
   * Creates a new signature data.
   *
   * @param algorithm the algorithm
   * @param signature the signature
   * @return the signature data
   */
  public static SignatureData createSignatureData(String algorithm, byte... signature) {
    LOGGER.log(Level.FINE, "Create signature data");
    return new SignatureDataImpl(algorithm, signature);
  }

  /**
   * Creates a new signed software certificate.
   *
   * @param certificateData the certificate data
   * @param signature the signature
   * @return the signature data
   */
  public static SignedSoftwareCertificate createSignedSoftwareCertificate(
      byte[] certificateData, byte... signature) {
    LOGGER.log(Level.FINE, "Create signed software certificate");
    return new SignedSoftwareCertificateImpl(certificateData, signature);
  }
}
