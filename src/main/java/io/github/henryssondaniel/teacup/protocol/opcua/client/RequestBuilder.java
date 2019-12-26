package io.github.henryssondaniel.teacup.protocol.opcua.client;

import io.github.henryssondaniel.teacup.protocol.Builder;

/**
 * Request builder.
 *
 * @param <T> the request
 * @param <U> the request builder
 * @since 1.0
 */
public interface RequestBuilder<T extends Request, U extends RequestBuilder<T, U>>
    extends Builder<T> {
  /**
   * Sets the request header.
   *
   * @param requestHeader the request header
   * @return the request builder
   */
  U setRequestHeader(RequestHeader requestHeader);
}
