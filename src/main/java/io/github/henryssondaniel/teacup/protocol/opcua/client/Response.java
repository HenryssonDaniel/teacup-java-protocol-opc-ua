package io.github.henryssondaniel.teacup.protocol.opcua.client;

/**
 * Response.
 *
 * @since 1.0
 */
@FunctionalInterface
public interface Response {
  /**
   * Returns the response header.
   *
   * @return the response header
   */
  ResponseHeader getResponseHeader();
}
