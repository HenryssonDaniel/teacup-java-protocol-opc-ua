package io.github.henryssondaniel.teacup.protocol.opcua.client;

interface ResponseSetter extends Response {
  void setResponseHeader(ResponseHeader responseHeader);
}
