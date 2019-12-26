package io.github.henryssondaniel.teacup.protocol.opcua.client;

/**
 * Activate session response.
 *
 * @since 1.0
 */
public interface ActivateSessionResponseBuilder
    extends ResponseBuilder<ActivateSessionResponse, ActivateSessionResponseBuilder> {
  /**
   * Sets the binary encoding ID.
   *
   * @param binaryEncodingId the binary encoding ID
   * @return the activate session response builder
   */
  ActivateSessionResponseBuilder setBinaryEncodingId(NodeId binaryEncodingId);

  /**
   * Sets the diagnostic info's
   *
   * @param diagnosticInfos the diagnostic info's
   * @return the activate session response builder
   */
  ActivateSessionResponseBuilder setDiagnosticInfos(DiagnosticInfo... diagnosticInfos);

  /**
   * Sets the results.
   *
   * @param results the results
   * @return the activate session response builder
   */
  ActivateSessionResponseBuilder setResults(long... results);

  /**
   * Sets the server nonce.
   *
   * @param serverNonce the server nonce
   * @return the activate session response builder
   */
  ActivateSessionResponseBuilder setServerNonce(byte... serverNonce);

  /**
   * Sets the type ID.
   *
   * @param typeId the type ID
   * @return the activate session response builder
   */
  ActivateSessionResponseBuilder setTypeId(NodeId typeId);

  /**
   * Sets the XML encoding ID.
   *
   * @param xmlEncodingId the XML encoding ID
   * @return the activate session response builder
   */
  ActivateSessionResponseBuilder setXmlEncodingId(NodeId xmlEncodingId);
}
