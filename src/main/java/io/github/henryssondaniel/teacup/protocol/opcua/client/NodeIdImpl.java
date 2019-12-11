package io.github.henryssondaniel.teacup.protocol.opcua.client;

class NodeIdImpl implements NodeId {
  private final Object identifier;
  private final short namespaceIndex;

  NodeIdImpl(Object identifier, short namespaceIndex) {
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
