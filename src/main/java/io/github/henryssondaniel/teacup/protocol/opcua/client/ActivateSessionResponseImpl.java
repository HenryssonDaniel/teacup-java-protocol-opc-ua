package io.github.henryssondaniel.teacup.protocol.opcua.client;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

class ActivateSessionResponseImpl extends ResponseImpl implements ActivateSessionResponseSetter {
  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(
          ActivateSessionResponseImpl.class);
  private static final String SET_DIAGNOSTIC_INFOS = "Set diagnostic infos";
  private static final String SET_RESULTS = "Set results";
  private static final String SET_SERVER_NONCE = "Set server nonce";

  private DiagnosticInfo[] diagnosticInfos;
  private long[] results;
  private byte[] serverNonce;

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
}
