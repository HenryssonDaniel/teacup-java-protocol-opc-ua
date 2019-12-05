package io.github.henryssondaniel.teacup.protocol.opcua.client;

import org.eclipse.milo.opcua.stack.core.serialization.UaRequestMessage;

interface RequestConverter {
  UaRequestMessage convert();

  void log();
}
