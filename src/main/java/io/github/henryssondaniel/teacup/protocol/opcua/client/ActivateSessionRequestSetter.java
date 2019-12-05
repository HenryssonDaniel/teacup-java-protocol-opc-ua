package io.github.henryssondaniel.teacup.protocol.opcua.client;

interface ActivateSessionRequestSetter extends ActivateSessionRequest {
  void setClientSignature(SignatureData clientSignature);

  void setClientSoftwareCertificates(SignedSoftwareCertificate... clientSoftwareCertificates);

  void setLocaleIds(String... localeIds);

  void setRequestHeader(RequestHeader requestHeader);

  void setUserIdentityToken(ExtensionObject userIdentityToken);

  void setUserTokenSignature(SignatureData userTokenSignature);
}
