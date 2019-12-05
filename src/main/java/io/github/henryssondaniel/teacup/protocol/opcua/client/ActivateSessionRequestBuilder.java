package io.github.henryssondaniel.teacup.protocol.opcua.client;

import io.github.henryssondaniel.teacup.protocol.Builder;

/**
 * Activate session request builder.
 *
 * @since 1.0
 */
public interface ActivateSessionRequestBuilder extends Builder<ActivateSessionRequest> {
  /**
   * Sets the client signature.
   *
   * @param clientSignature the client signature
   * @return the activate session request builder
   */
  ActivateSessionRequestBuilder setClientSignature(SignatureData clientSignature);

  /**
   * Sets the client software certificates.
   *
   * @param clientSoftwareCertificates the client software certificates
   * @return the activate session request builder
   */
  ActivateSessionRequestBuilder setClientSoftwareCertificates(
      SignedSoftwareCertificate... clientSoftwareCertificates);

  /**
   * Sets the locale ID's.
   *
   * @param localeIds the locale ID's
   * @return the activate session request builder
   */
  ActivateSessionRequestBuilder setLocaleIds(String... localeIds);

  /**
   * Sets the request header.
   *
   * @param requestHeader the request header
   * @return the activate session request builder
   */
  ActivateSessionRequestBuilder setRequestHeader(RequestHeader requestHeader);

  /**
   * Sets the user identity token.
   *
   * @param userIdentityToken the user identity token
   * @return the activate session request builder
   */
  ActivateSessionRequestBuilder setUserIdentityToken(ExtensionObject userIdentityToken);

  /**
   * Sets the user token signature.
   *
   * @param userTokenSignature the user token signature
   * @return the activate session request builder
   */
  ActivateSessionRequestBuilder setUserTokenSignature(SignatureData userTokenSignature);
}
