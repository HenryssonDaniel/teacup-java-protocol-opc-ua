package io.github.henryssondaniel.teacup.protocol.opcua.client;

/**
 * Activate session request.
 *
 * @since 1.0
 */
public interface ActivateSessionRequest extends Request {
  /**
   * Returns the client signature.
   *
   * @return the client signature
   */
  SignatureData getClientSignature();

  /**
   * Returns the client software certificates.
   *
   * @return the client software certificates
   */
  SignedSoftwareCertificate[] getClientSoftwareCertificates();

  /**
   * Returns the locale ID's.
   *
   * @return the locale ID's
   */
  String[] getLocaleIds();

  /**
   * Returns the request header.
   *
   * @return the request header
   */
  RequestHeader getRequestHeader();

  /**
   * Returns the user identity token.
   *
   * @return the user identity token
   */
  ExtensionObject getUserIdentityToken();

  /**
   * Returns the user token signature.
   *
   * @return the user token signature
   */
  SignatureData getUserTokenSignature();
}
