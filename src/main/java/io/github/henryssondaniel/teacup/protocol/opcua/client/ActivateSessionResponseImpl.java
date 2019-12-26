package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.SET_DIAGNOSTIC_INFOS;
import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.SET_RESULTS;
import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.SET_SERVER_NONCE;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

class ActivateSessionResponseImpl extends ResponseImpl implements ActivateSessionResponseSetter {
  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(
          ActivateSessionResponseImpl.class);

  private NodeId binaryEncodingId;
  private DiagnosticInfo[] diagnosticInfos;
  private long[] results;
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
  public long[] getResults() {
    LOGGER.log(Level.FINE, "Get results");
    return Optional.ofNullable(results).map(long[]::clone).orElse(null);
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
    LOGGER.log(Level.FINE, SET_DIAGNOSTIC_INFOS);
    this.diagnosticInfos =
        Optional.ofNullable(diagnosticInfos).map(DiagnosticInfo[]::clone).orElse(null);
  }

  @Override
  public void setResults(long... results) {
    LOGGER.log(Level.FINE, SET_RESULTS);
    this.results = Optional.ofNullable(results).map(long[]::clone).orElse(null);
  }

  @Override
  public void setServerNonce(byte... serverNonce) {
    LOGGER.log(Level.FINE, SET_SERVER_NONCE);
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
