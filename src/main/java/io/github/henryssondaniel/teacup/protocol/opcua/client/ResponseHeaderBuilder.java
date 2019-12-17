package io.github.henryssondaniel.teacup.protocol.opcua.client;

import io.github.henryssondaniel.teacup.protocol.Builder;
import java.time.Instant;

/**
 * Response header builder.
 *
 * @since 1.0
 */
public interface ResponseHeaderBuilder extends Builder<ResponseHeader> {
  /**
   * Sets the additional header.
   *
   * @param additionalHeader the additional header
   * @return the response header builder
   */
  ResponseHeaderBuilder setAdditionalHeader(ExtensionObject additionalHeader);

  /**
   * Sets the binary encoding ID.
   *
   * @param binaryEncodingId the binary encoding ID
   * @return the response header builder
   */
  ResponseHeaderBuilder setBinaryEncodingId(NodeId binaryEncodingId);

  /**
   * Sets the request handle.
   *
   * @param requestHandle the request handle
   * @return the response header builder
   */
  ResponseHeaderBuilder setRequestHandle(int requestHandle);

  /**
   * Sets the service diagnostics.
   *
   * @param serviceDiagnostics the service diagnostics
   * @return the response header builder
   */
  ResponseHeaderBuilder setServiceDiagnostics(DiagnosticInfo serviceDiagnostics);

  /**
   * Sets the service result.
   *
   * @param serviceResult the service result
   * @return the response header builder
   */
  ResponseHeaderBuilder setServiceResult(StatusCode serviceResult);

  /**
   * Sets the string table.
   *
   * @param stringTable the string table
   * @return the response header builder
   */
  ResponseHeaderBuilder setStringTable(String... stringTable);

  /**
   * Sets the timestamp.
   *
   * @param timestamp the timestamp
   * @return the response header builder
   */
  ResponseHeaderBuilder setTimestamp(Instant timestamp);

  /**
   * Sets the type ID.
   *
   * @param typeId the type ID
   * @return the response header builder
   */
  ResponseHeaderBuilder setTypeId(NodeId typeId);

  /**
   * Sets the XML encoding ID.
   *
   * @param xmlEncodingId the XML encoding ID
   * @return the response header builder
   */
  ResponseHeaderBuilder setXmlEncodingId(NodeId xmlEncodingId);
}
