package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.CLIENT_SOFTWARE_CERTIFICATES;
import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.LOCALE_IDS;

import java.util.logging.Level;
import java.util.logging.Logger;

class ActivateSessionRequestBuilderImpl
    extends RequestBuilderImpl<
        ActivateSessionRequest, ActivateSessionRequestBuilder, ActivateSessionRequestSetter>
    implements ActivateSessionRequestBuilder {
  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(
          ActivateSessionRequestBuilderImpl.class);

  ActivateSessionRequestBuilderImpl() {
    super(new ActivateSessionRequestImpl());
  }

  @Override
  public ActivateSessionRequestBuilder setClientSignature(SignatureData clientSignature) {
    LOGGER.log(Level.FINE, "Set client signature");
    getImplementation().setClientSignature(clientSignature);
    return this;
  }

  @Override
  public ActivateSessionRequestBuilder setClientSoftwareCertificates(
      SignedSoftwareCertificate... clientSoftwareCertificates) {
    LOGGER.log(Level.FINE, CLIENT_SOFTWARE_CERTIFICATES);
    getImplementation().setClientSoftwareCertificates(clientSoftwareCertificates);
    return this;
  }

  @Override
  public ActivateSessionRequestBuilder setLocaleIds(String... localeIds) {
    LOGGER.log(Level.FINE, LOCALE_IDS);
    getImplementation().setLocaleIds(localeIds);
    return this;
  }

  @Override
  public ActivateSessionRequestBuilder setUserIdentityToken(ExtensionObject userIdentityToken) {
    LOGGER.log(Level.FINE, "Set user identity token");
    getImplementation().setUserIdentityToken(userIdentityToken);
    return this;
  }

  @Override
  public ActivateSessionRequestBuilder setUserTokenSignature(SignatureData userTokenSignature) {
    LOGGER.log(Level.FINE, "Set user token signature");
    getImplementation().setUserTokenSignature(userTokenSignature);
    return this;
  }

  @Override
  protected ActivateSessionRequestSetter createImplementation() {
    return new ActivateSessionRequestImpl();
  }
}
