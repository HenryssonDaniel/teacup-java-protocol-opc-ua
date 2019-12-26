package io.github.henryssondaniel.teacup.protocol.opcua.client;

class ResponseImpl implements ResponseSetter {
  private ResponseHeader responseHeader;

  @Override
  public ResponseHeader getResponseHeader() {
    return responseHeader;
  }

  @Override
  public void setResponseHeader(ResponseHeader responseHeader) {
    this.responseHeader = responseHeader;
  }
}
