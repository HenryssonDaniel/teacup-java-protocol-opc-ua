package io.github.henryssondaniel.teacup.protocol.opcua.client;

import org.eclipse.milo.opcua.stack.core.serialization.UaMessage;

interface Converter<T extends UaMessage> {
  T convert();

  void log();
}
