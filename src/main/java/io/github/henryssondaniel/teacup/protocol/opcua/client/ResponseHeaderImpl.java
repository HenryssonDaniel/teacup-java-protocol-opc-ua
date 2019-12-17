package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.SET_STRING_TABLE;

import java.time.Instant;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

class ResponseHeaderImpl implements ResponseHeaderSetter {
  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(ResponseHeaderImpl.class);

  private ExtensionObject additionalHeader;
  private NodeId binaryEncodingId;
  private int requestHandle;
  private DiagnosticInfo serviceDiagnostics;
  private long serviceResult;
  private String[] stringTable;
  private Instant timestamp;
  private NodeId typeId;
  private NodeId xmlEncodingId;

  @Override
  public ExtensionObject getAdditionalHeader() {
    return additionalHeader;
  }

  @Override
  public NodeId getBinaryEncodingId() {
    return binaryEncodingId;
  }

  @Override
  public int getRequestHandle() {
    return requestHandle;
  }

  @Override
  public DiagnosticInfo getServiceDiagnostics() {
    return serviceDiagnostics;
  }

  @Override
  public long getServiceResult() {
    return serviceResult;
  }

  @Override
  public String[] getStringTable() {
    LOGGER.log(Level.FINE, "Get string table");
    return Optional.ofNullable(stringTable).map(String[]::clone).orElse(null);
  }

  @Override
  public Instant getTimestamp() {
    return timestamp;
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
  public void setAdditionalHeader(ExtensionObject additionalHeader) {
    this.additionalHeader = additionalHeader;
  }

  @Override
  public void setBinaryEncodingId(NodeId binaryEncodingId) {
    this.binaryEncodingId = binaryEncodingId;
  }

  @Override
  public void setRequestHandle(int requestHandle) {
    this.requestHandle = requestHandle;
  }

  @Override
  public void setServiceDiagnostics(DiagnosticInfo serviceDiagnostics) {
    this.serviceDiagnostics = serviceDiagnostics;
  }

  @Override
  public void setServiceResult(long serviceResult) {
    this.serviceResult = serviceResult;
  }

  @Override
  public void setStringTable(String... stringTable) {
    LOGGER.log(Level.FINE, SET_STRING_TABLE);
    this.stringTable = Optional.ofNullable(stringTable).map(String[]::clone).orElse(null);
  }

  @Override
  public void setTimestamp(Instant timestamp) {
    this.timestamp = timestamp;
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
