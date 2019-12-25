package io.github.henryssondaniel.teacup.protocol.opcua.client;

/**
 * Request.
 *
 * @since 1.0
 */
@FunctionalInterface
public interface Request {
  /**
   * Returns the request header.
   *
   * @return the request header
   */
  RequestHeader getRequestHeader();
}
