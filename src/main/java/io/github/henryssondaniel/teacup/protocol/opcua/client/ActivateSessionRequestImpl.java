package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.CLIENT_SOFTWARE_CERTIFICATES;
import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.LOCALE_IDS;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

class ActivateSessionRequestImpl implements ActivateSessionRequestSetter {
  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(
          ActivateSessionRequestImpl.class);

  private SignatureData clientSignature;
  private SignedSoftwareCertificate[] clientSoftwareCertificates;
  private String[] localeIds;
  private RequestHeader requestHeader;
  private ExtensionObject userIdentityToken;
  private SignatureData userTokenSignature;

  @Override
  public SignatureData getClientSignature() {
    return clientSignature;
  }

  @Override
  public SignedSoftwareCertificate[] getClientSoftwareCertificates() {
    LOGGER.log(Level.FINE, "Get client software certificates");
    return getSignedSoftwareCertificates(clientSoftwareCertificates);
  }

  @Override
  public String[] getLocaleIds() {
    LOGGER.log(Level.FINE, "Get locale ID's");
    return getLocaleIds(localeIds);
  }

  @Override
  public RequestHeader getRequestHeader() {
    return requestHeader;
  }

  @Override
  public ExtensionObject getUserIdentityToken() {
    return userIdentityToken;
  }

  @Override
  public SignatureData getUserTokenSignature() {
    return userTokenSignature;
  }

  @Override
  public void setClientSignature(SignatureData clientSignature) {
    this.clientSignature = clientSignature;
  }

  @Override
  public void setClientSoftwareCertificates(
      SignedSoftwareCertificate... clientSoftwareCertificates) {
    LOGGER.log(Level.FINE, CLIENT_SOFTWARE_CERTIFICATES);
    this.clientSoftwareCertificates = getSignedSoftwareCertificates(clientSoftwareCertificates);
  }

  @Override
  public void setLocaleIds(String... localeIds) {
    LOGGER.log(Level.FINE, LOCALE_IDS);
    this.localeIds = getLocaleIds(localeIds);
  }

  @Override
  public void setRequestHeader(RequestHeader requestHeader) {
    this.requestHeader = requestHeader;
  }

  @Override
  public void setUserIdentityToken(ExtensionObject userIdentityToken) {
    this.userIdentityToken = userIdentityToken;
  }

  @Override
  public void setUserTokenSignature(SignatureData userTokenSignature) {
    this.userTokenSignature = userTokenSignature;
  }

  private static String[] getLocaleIds(String... localeIds) {
    return Optional.ofNullable(localeIds).map(String[]::clone).orElse(null);
  }

  private static SignedSoftwareCertificate[] getSignedSoftwareCertificates(
      SignedSoftwareCertificate... clientSoftwareCertificates) {
    return Optional.ofNullable(clientSoftwareCertificates)
        .map(SignedSoftwareCertificate[]::clone)
        .orElse(null);
  }
}
