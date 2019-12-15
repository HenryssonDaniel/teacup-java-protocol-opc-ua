package io.github.henryssondaniel.teacup.protocol.opcua.client;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

class ActivateSessionResponseImpl implements ActivateSessionResponseSetter {
  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(
          ActivateSessionResponseImpl.class);

  private NodeId binaryEncodingId;
  private DiagnosticInfo[] diagnosticInfos;
  private ResponseHeader responseHeader;
  private StatusCode[] results;
  private byte[] serverNonce;
  private NodeId typeId;
  private NodeId xmlEncodingId;

  @Override
  public NodeId getBinaryEncodingId() {
    return binaryEncodingId;
  }

  @Override
  public DiagnosticInfo[] getDiagnosticInfos() {
    LOGGER.log(Level.FINE, "Get diagnostic infos");
    return Optional.ofNullable(diagnosticInfos).map(DiagnosticInfo[]::clone).orElse(null);
  }

  @Override
  public ResponseHeader getResponseHeader() {
    return responseHeader;
  }

  @Override
  public StatusCode[] getResults() {
    LOGGER.log(Level.FINE, "Get results");
    return Optional.ofNullable(results).map(StatusCode[]::clone).orElse(null);
  }

  @Override
  public byte[] getServerNonce() {
    LOGGER.log(Level.FINE, "Get server nonce");
    return Optional.ofNullable(serverNonce).map(byte[]::clone).orElse(null);
  }

  @Override
  public NodeId getTypeId() {
    return typeId;
  }

  @Override
  public NodeId getXmlEncodingId() {
    return xmlEncodingId;
  }

  @Override
  public void setBinaryEncodingId(NodeId binaryEncodingId) {
    this.binaryEncodingId = binaryEncodingId;
  }

  @Override
  public void setDiagnosticInfos(DiagnosticInfo... diagnosticInfos) {
    LOGGER.log(Level.FINE, "Set diagnostic info's");
    this.diagnosticInfos =
        Optional.ofNullable(diagnosticInfos).map(DiagnosticInfo[]::clone).orElse(null);
  }

  @Override
  public void setResponseHeader(ResponseHeader responseHeader) {
    this.responseHeader = responseHeader;
  }

  @Override
  public void setResults(StatusCode... results) {
    LOGGER.log(Level.FINE, "Set results");
    this.results = Optional.ofNullable(results).map(StatusCode[]::clone).orElse(null);
  }

  @Override
  public void setServerNonce(byte... serverNonce) {
    LOGGER.log(Level.FINE, "Set server nonce");
    this.serverNonce = Optional.ofNullable(serverNonce).map(byte[]::clone).orElse(null);
  }

  @Override
  public void setTypeId(NodeId typeId) {
    this.typeId = typeId;
  }

  @Override
  public void setXmlEncodingId(NodeId xmlEncodingId) {
    this.xmlEncodingId = xmlEncodingId;
  }
}
