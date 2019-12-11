package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.BUILD;
import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.CLIENT_SOFTWARE_CERTIFICATES;
import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.LOCALE_IDS;

import java.util.logging.Level;
import java.util.logging.Logger;

class ActivateSessionRequestBuilderImpl implements ActivateSessionRequestBuilder {
  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(
          ActivateSessionRequestBuilderImpl.class);
  private ActivateSessionRequestSetter activateSessionRequestSetter =
      new ActivateSessionRequestImpl();

  @Override
  public ActivateSessionRequest build() {
    LOGGER.log(Level.FINE, BUILD);

    ActivateSessionRequest request = activateSessionRequestSetter;
    activateSessionRequestSetter = new ActivateSessionRequestImpl();

    return request;
  }

  @Override
  public ActivateSessionRequestBuilder setClientSignature(SignatureData clientSignature) {
    LOGGER.log(Level.FINE, "Set client signature");
    activateSessionRequestSetter.setClientSignature(clientSignature);
    return this;
  }

  @Override
  public ActivateSessionRequestBuilder setClientSoftwareCertificates(
      SignedSoftwareCertificate... clientSoftwareCertificates) {
    LOGGER.log(Level.FINE, CLIENT_SOFTWARE_CERTIFICATES);
    activateSessionRequestSetter.setClientSoftwareCertificates(clientSoftwareCertificates);
    return this;
  }

  @Override
  public ActivateSessionRequestBuilder setLocaleIds(String... localeIds) {
    LOGGER.log(Level.FINE, LOCALE_IDS);
    activateSessionRequestSetter.setLocaleIds(localeIds);
    return this;
  }

  @Override
  public ActivateSessionRequestBuilder setRequestHeader(RequestHeader requestHeader) {
    LOGGER.log(Level.FINE, "Set request header");
    activateSessionRequestSetter.setRequestHeader(requestHeader);
    return this;
  }

  @Override
  public ActivateSessionRequestBuilder setUserIdentityToken(ExtensionObject userIdentityToken) {
    LOGGER.log(Level.FINE, "Set user identity token");
    activateSessionRequestSetter.setUserIdentityToken(userIdentityToken);
    return this;
  }

  @Override
  public ActivateSessionRequestBuilder setUserTokenSignature(SignatureData userTokenSignature) {
    LOGGER.log(Level.FINE, "Set user token signature");
    activateSessionRequestSetter.setUserTokenSignature(userTokenSignature);
    return this;
  }
}
