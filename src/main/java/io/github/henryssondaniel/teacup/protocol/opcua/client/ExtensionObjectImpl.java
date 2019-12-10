package io.github.henryssondaniel.teacup.protocol.opcua.client;

class ExtensionObjectImpl implements ExtensionObject {
  private final Object body;
  private final NodeId encodingId;

  ExtensionObjectImpl(Object body, NodeId encodingId) {
    this.body = body;
    this.encodingId = encodingId;
  }

  @Override
  public Object getBody() {
    return body;
  }

  @Override
  public NodeId getEncodingId() {
    return encodingId;
  }
}
