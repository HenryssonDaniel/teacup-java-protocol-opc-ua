package io.github.henryssondaniel.teacup.protocol.opcua.client;

import io.github.henryssondaniel.teacup.protocol.DefaultBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class ResponseBuilderImpl<
        T extends Response, U extends ResponseBuilder<T, U>, V extends ResponseSetter>
    extends DefaultBuilder<T, V> implements ResponseBuilder<T, U> {
  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(ResponseBuilderImpl.class);

  ResponseBuilderImpl(V implementation) {
    super(implementation);
  }

  @Override
  @SuppressWarnings("unchecked")
  public U setResponseHeader(ResponseHeader responseHeader) {
    LOGGER.log(Level.FINE, "Set response header");
    getImplementation().setResponseHeader(responseHeader);
    return (U) this;
  }
}
