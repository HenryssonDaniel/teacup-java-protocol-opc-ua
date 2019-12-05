package io.github.henryssondaniel.teacup.protocol.opcua.client;

import java.time.Instant;

/**
 * Request header.
 *
 * @since 1.0
 */
public interface RequestHeader {
  /**
   * Returns the additional header.
   *
   * @return the additional header
   */
  ExtensionObject getAdditionalHeader();

  /**
   * Returns the audit entry ID.
   *
   * @return the audit entry ID
   */
  String getAuditEntryId();

  /**
   * Returns the authentication token.
   *
   * @return the authentication token
   */
  NodeId getAuthenticationToken();

  /**
   * Returns the request handle.
   *
   * @return the request handle
   */
  int getRequestHandle();

  /**
   * Returns the return diagnostics.
   *
   * @return the return diagnostics
   */
  int getReturnDiagnostics();

  /**
   * Returns the timeout hint.
   *
   * @return the timeout hint
   */
  int getTimeoutHint();

  /**
   * Returns the timestamp.
   *
   * @return the timestamp
   */
  Instant getTimestamp();
}
