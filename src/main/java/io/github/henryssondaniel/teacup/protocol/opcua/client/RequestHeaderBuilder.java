package io.github.henryssondaniel.teacup.protocol.opcua.client;

import io.github.henryssondaniel.teacup.protocol.Builder;
import java.time.Instant;

/**
 * Request header builder.
 *
 * @since 1.0
 */
public interface RequestHeaderBuilder extends Builder<RequestHeader> {
  /**
   * Sets the additional header.
   *
   * @param additionalHeader the additional header
   * @return the request header builder
   */
  RequestHeaderBuilder setAdditionalHeader(ExtensionObject additionalHeader);

  /**
   * Sets the audit entry ID.
   *
   * @param auditEntryId the audit entry ID
   * @return the request header builder
   */
  RequestHeaderBuilder setAuditEntryId(String auditEntryId);

  /**
   * Sets the authentication token.
   *
   * @param authenticationToken the authentication token
   * @return the request header builder
   */
  RequestHeaderBuilder setAuthenticationToken(NodeId authenticationToken);

  /**
   * Sets the request handle.
   *
   * @param requestHandle the request handle
   * @return the request header builder
   */
  RequestHeaderBuilder setRequestHandle(int requestHandle);

  /**
   * Sets the return diagnostics.
   *
   * @param returnDiagnostics the return diagnostics
   * @return the request header builder
   */
  RequestHeaderBuilder setReturnDiagnostics(int returnDiagnostics);

  /**
   * Sets the timeout hint.
   *
   * @param timeoutHint the timeout hint
   * @return the request header builder
   */
  RequestHeaderBuilder setTimeoutHint(int timeoutHint);

  /**
   * Sets the timestamp.
   *
   * @param timestamp the timestamp
   * @return the request header builder
   */
  RequestHeaderBuilder setTimestamp(Instant timestamp);
}
