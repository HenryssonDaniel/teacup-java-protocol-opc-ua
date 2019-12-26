package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.SET_BINARY_ENCODING_ID;
import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.SET_DIAGNOSTIC_INFOS;
import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.SET_RESULTS;
import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.SET_SERVER_NONCE;
import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.SET_XML_ENCODING_ID;

import java.util.logging.Level;
import java.util.logging.Logger;

class ActivateSessionResponseBuilderImpl
    extends ResponseBuilderImpl<
        ActivateSessionResponse, ActivateSessionResponseBuilder, ActivateSessionResponseSetter>
    implements ActivateSessionResponseBuilder {
  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(
          ActivateSessionResponseBuilderImpl.class);

  ActivateSessionResponseBuilderImpl() {
    super(new ActivateSessionResponseImpl());
  }

  @Override
  public ActivateSessionResponseBuilder setBinaryEncodingId(NodeId binaryEncodingId) {
    LOGGER.log(Level.FINE, SET_BINARY_ENCODING_ID);
    getImplementation().setBinaryEncodingId(binaryEncodingId);
    return this;
  }

  @Override
  public ActivateSessionResponseBuilder setDiagnosticInfos(DiagnosticInfo... diagnosticInfos) {
    LOGGER.log(Level.FINE, SET_DIAGNOSTIC_INFOS);
    getImplementation().setDiagnosticInfos(diagnosticInfos);
    return this;
  }

  @Override
  public ActivateSessionResponseBuilder setResults(long... results) {
    LOGGER.log(Level.FINE, SET_RESULTS);
    getImplementation().setResults(results);
    return this;
  }

  @Override
  public ActivateSessionResponseBuilder setServerNonce(byte... serverNonce) {
    LOGGER.log(Level.FINE, SET_SERVER_NONCE);
    getImplementation().setServerNonce(serverNonce);
    return this;
  }

  @Override
  public ActivateSessionResponseBuilder setTypeId(NodeId typeId) {
    LOGGER.log(Level.FINE, "Set type ID");
    getImplementation().setTypeId(typeId);
    return this;
  }

  @Override
  public ActivateSessionResponseBuilder setXmlEncodingId(NodeId xmlEncodingId) {
    LOGGER.log(Level.FINE, SET_XML_ENCODING_ID);
    getImplementation().setXmlEncodingId(xmlEncodingId);
    return this;
  }

  @Override
  protected ActivateSessionResponseSetter createImplementation() {
    return new ActivateSessionResponseImpl();
  }
}
