package io.github.henryssondaniel.teacup.protocol.opcua.client;

interface ActivateSessionRequestSetter extends ActivateSessionRequest, RequestSetter {
  void setClientSignature(SignatureData clientSignature);

  void setClientSoftwareCertificates(SignedSoftwareCertificate... clientSoftwareCertificates);

  void setLocaleIds(String... localeIds);

  void setUserIdentityToken(ExtensionObject userIdentityToken);

  void setUserTokenSignature(SignatureData userTokenSignature);
}
