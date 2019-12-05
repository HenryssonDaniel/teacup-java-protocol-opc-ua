package io.github.henryssondaniel.teacup.protocol.opcua.client;

import java.util.UUID;

class NodeIdImpl implements NodeId {
  private final Object identifier;
  private final short namespaceIndex;

  NodeIdImpl(byte[] identifier, short namespaceIndex) {
    this((Object) identifier, namespaceIndex);
  }

  NodeIdImpl(int identifier, short namespaceIndex) {
    this((Object) identifier, namespaceIndex);
  }

  NodeIdImpl(String identifier, short namespaceIndex) {
    this((Object) identifier, namespaceIndex);
  }

  NodeIdImpl(UUID identifier, short namespaceIndex) {
    this((Object) identifier, namespaceIndex);
  }

  private NodeIdImpl(Object identifier, short namespaceIndex) {
    this.identifier = identifier;
    this.namespaceIndex = namespaceIndex;
  }

  @Override
  public Object getIdentifier() {
    return identifier;
  }

  @Override
  public short getNamespaceIndex() {
    return namespaceIndex;
  }
}
