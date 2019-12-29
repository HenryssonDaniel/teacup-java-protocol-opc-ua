package io.github.henryssondaniel.teacup.protocol.opcua.client;

interface Converter<T> {
  T convert();

  void log();
}
