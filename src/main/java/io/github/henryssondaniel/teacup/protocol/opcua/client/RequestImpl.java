package io.github.henryssondaniel.teacup.protocol.opcua.client;

class RequestImpl implements RequestSetter {
  private RequestHeader requestHeader;

  @Override
  public RequestHeader getRequestHeader() {
    return requestHeader;
  }

  @Override
  public void setRequestHeader(RequestHeader requestHeader) {
    this.requestHeader = requestHeader;
  }
}
