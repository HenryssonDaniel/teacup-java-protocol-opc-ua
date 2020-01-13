package io.github.henryssondaniel.teacup.protocol.opcua.client;

import java.time.Instant;

/**
 * Response header.
 *
 * @since 1.0
 */
public interface ResponseHeader {
  /**
   * Returns the additional header.
   *
   * @return the additional header
   */
  ExtensionObject getAdditionalHeader();

  /**
   * Returns the request handle.
   *
   * @return the request handle
   */
  int getRequestHandle();

  /**
   * Returns the service diagnostics.
   *
   * @return the service diagnostics
   */
  DiagnosticInfo getServiceDiagnostics();

  /**
   * Returns the service result.
   *
   * @return the service result
   */
  long getServiceResult();

  /**
   * Returns the string table.
   *
   * @return the string table
   */
  String[] getStringTable();

  /**
   * Returns the timestamp.
   *
   * @return the timestamp
   */
  Instant getTimestamp();
}
