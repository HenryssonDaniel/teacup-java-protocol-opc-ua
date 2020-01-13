package io.github.henryssondaniel.teacup.protocol.opcua.client;

import java.time.Instant;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

class ResponseHeaderImpl implements ResponseHeaderSetter {
  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(ResponseHeaderImpl.class);
  private static final String SET_STRING_TABLE = "Set string table";

  private ExtensionObject additionalHeader;
  private int requestHandle;
  private DiagnosticInfo serviceDiagnostics;
  private long serviceResult;
  private String[] stringTable;
  private Instant timestamp;

  @Override
  public ExtensionObject getAdditionalHeader() {
    return additionalHeader;
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
  public void setAdditionalHeader(ExtensionObject additionalHeader) {
    this.additionalHeader = additionalHeader;
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
}
