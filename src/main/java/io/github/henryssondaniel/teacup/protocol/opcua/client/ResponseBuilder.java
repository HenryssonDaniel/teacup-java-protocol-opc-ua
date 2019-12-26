package io.github.henryssondaniel.teacup.protocol.opcua.client;

import io.github.henryssondaniel.teacup.protocol.Builder;

/**
 * Response builder.
 *
 * @param <T> the response
 * @param <U> the response builder
 * @since 1.0
 */
public interface ResponseBuilder<T extends Response, U extends ResponseBuilder<T, U>>
    extends Builder<T> {
  /**
   * Sets the response header.
   *
   * @param responseHeader the response header
   * @return the activate session response builder
   */
  U setResponseHeader(ResponseHeader responseHeader);
}
