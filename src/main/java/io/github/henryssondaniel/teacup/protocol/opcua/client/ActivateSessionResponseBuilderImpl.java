package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.BUILD;
import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.SET_BINARY_ENCODING_ID;
import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.SET_DIAGNOSTIC_INFOS;
import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.SET_RESULTS;
import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.SET_SERVER_NONCE;
import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.SET_XML_ENCODING_ID;

import java.util.logging.Level;
import java.util.logging.Logger;

class ActivateSessionResponseBuilderImpl implements ActivateSessionResponseBuilder {
  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(
          ActivateSessionResponseBuilderImpl.class);
  private ActivateSessionResponseSetter activateSessionResponseSetter =
      new ActivateSessionResponseImpl();

  @Override
  public ActivateSessionResponse build() {
    LOGGER.log(Level.FINE, BUILD);

    var sessionResponseSetter = activateSessionResponseSetter;
    activateSessionResponseSetter = new ActivateSessionResponseImpl();

    return sessionResponseSetter;
  }

  @Override
  public ActivateSessionResponseBuilder setBinaryEncodingId(NodeId binaryEncodingId) {
    LOGGER.log(Level.FINE, SET_BINARY_ENCODING_ID);
    activateSessionResponseSetter.setBinaryEncodingId(binaryEncodingId);
    return this;
  }

  @Override
  public ActivateSessionResponseBuilder setDiagnosticInfos(DiagnosticInfo... diagnosticInfos) {
    LOGGER.log(Level.FINE, SET_DIAGNOSTIC_INFOS);
    activateSessionResponseSetter.setDiagnosticInfos(diagnosticInfos);
    return this;
  }

  @Override
  public ActivateSessionResponseBuilder setResponseHeader(ResponseHeader responseHeader) {
    LOGGER.log(Level.FINE, "Set response header");
    activateSessionResponseSetter.setResponseHeader(responseHeader);
    return this;
  }

  @Override
  public ActivateSessionResponseBuilder setResults(long... results) {
    LOGGER.log(Level.FINE, SET_RESULTS);
    activateSessionResponseSetter.setResults(results);
    return this;
  }

  @Override
  public ActivateSessionResponseBuilder setServerNonce(byte... serverNonce) {
    LOGGER.log(Level.FINE, SET_SERVER_NONCE);
    activateSessionResponseSetter.setServerNonce(serverNonce);
    return this;
  }

  @Override
  public ActivateSessionResponseBuilder setTypeId(NodeId typeId) {
    LOGGER.log(Level.FINE, "Set type ID");
    activateSessionResponseSetter.setTypeId(typeId);
    return this;
  }

  @Override
  public ActivateSessionResponseBuilder setXmlEncodingId(NodeId xmlEncodingId) {
    LOGGER.log(Level.FINE, SET_XML_ENCODING_ID);
    activateSessionResponseSetter.setXmlEncodingId(xmlEncodingId);
    return this;
  }
}
