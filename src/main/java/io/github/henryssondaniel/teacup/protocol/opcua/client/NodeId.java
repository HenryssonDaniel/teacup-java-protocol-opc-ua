package io.github.henryssondaniel.teacup.protocol.opcua.client;

/**
 * Node ID.
 *
 * @since 1.0
 */
public interface NodeId {
  /**
   * Returns the identifier.
   *
   * @return the identifier
   */
  Object getIdentifier();

  /**
   * Returns the namespace index.
   *
   * @return the namespace index
   */
  short getNamespaceIndex();
}
