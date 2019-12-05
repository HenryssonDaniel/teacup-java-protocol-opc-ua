package io.github.henryssondaniel.teacup.protocol.opcua.client;

/**
 * Extension object.
 *
 * @since 1.0
 */
public interface ExtensionObject {
  /**
   * Returns the body.
   *
   * @return the body
   */
  Object getBody();

  /**
   * Returns the encoding ID.
   *
   * @return the encoding ID
   */
  NodeId getEncodingId();
}
