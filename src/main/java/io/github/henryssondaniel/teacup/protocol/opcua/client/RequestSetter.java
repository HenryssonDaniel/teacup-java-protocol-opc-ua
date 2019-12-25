package io.github.henryssondaniel.teacup.protocol.opcua.client;

interface RequestSetter extends Request {
  void setRequestHeader(RequestHeader requestHeader);
}
