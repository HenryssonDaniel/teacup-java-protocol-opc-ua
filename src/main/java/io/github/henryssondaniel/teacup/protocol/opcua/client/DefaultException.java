package io.github.henryssondaniel.teacup.protocol.opcua.client;

/**
 * Default exception for the client package.
 *
 * @since 1.0
 */
public class DefaultException extends Exception {
  private static final long serialVersionUID = -3274350702359453522L;

  DefaultException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
