package io.github.henryssondaniel.teacup.protocol.opcua.client;

import io.github.henryssondaniel.teacup.protocol.DefaultBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class RequestBuilderImpl<
        T extends Request, U extends RequestBuilder<T, U>, V extends RequestSetter>
    extends DefaultBuilder<T, V> implements RequestBuilder<T, U> {
  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(RequestBuilderImpl.class);

  RequestBuilderImpl(V implementation) {
    super(implementation);
  }

  @Override
  @SuppressWarnings("unchecked")
  public U setRequestHeader(RequestHeader requestHeader) {
    LOGGER.log(Level.FINE, "Set request header");
    getImplementation().setRequestHeader(requestHeader);
    return (U) this;
  }
}
