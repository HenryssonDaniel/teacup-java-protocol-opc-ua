package io.github.henryssondaniel.teacup.protocol.opcua.client;

import java.time.Instant;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.milo.opcua.stack.core.serialization.UaRequestMessage;
import org.eclipse.milo.opcua.stack.core.types.builtin.ByteString;
import org.eclipse.milo.opcua.stack.core.types.builtin.DateTime;
import org.eclipse.milo.opcua.stack.core.types.builtin.XmlElement;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UShort;

class ActivateSessionRequestConverter implements Converter<UaRequestMessage> {
  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(
          ActivateSessionRequestConverter.class);
  private final ActivateSessionRequest activateSessionRequest;

  ActivateSessionRequestConverter(ActivateSessionRequest activateSessionRequest) {
    this.activateSessionRequest = activateSessionRequest;
  }

  @Override
  public UaRequestMessage convert() {
    LOGGER.log(Level.FINE, "Convert");

    var signedSoftwareCertificates = activateSessionRequest.getClientSoftwareCertificates();

    return new org.eclipse.milo.opcua.stack.core.types.structured.ActivateSessionRequest(
        createRequestHeader(activateSessionRequest.getRequestHeader()),
        createSignatureData(activateSessionRequest.getClientSignature()),
        Optional.ofNullable(signedSoftwareCertificates)
            .map(ActivateSessionRequestConverter::convert)
            .orElse(null),
        activateSessionRequest.getLocaleIds(),
        createExtensionObject(activateSessionRequest.getUserIdentityToken()),
        createSignatureData(activateSessionRequest.getUserTokenSignature()));
  }

  @Override
  public void log() {
    LOGGER.log(
        Level.INFO,
        () ->
            "Request:"
                + System.lineSeparator()
                + "Client signature:"
                + System.lineSeparator()
                + logClientSignature(activateSessionRequest.getClientSignature())
                + System.lineSeparator()
                + "Client software certificates:"
                + System.lineSeparator()
                + logClientSoftwareCertificates(
                    activateSessionRequest.getClientSoftwareCertificates())
                + System.lineSeparator()
                + "Locale ID's: "
                + Arrays.toString(activateSessionRequest.getLocaleIds())
                + System.lineSeparator()
                + "Request header:"
                + System.lineSeparator()
                + logRequestHeader(activateSessionRequest.getRequestHeader())
                + System.lineSeparator()
                + "User identity token:"
                + logAdditionalHeader(activateSessionRequest.getUserIdentityToken())
                + System.lineSeparator()
                + "User token signature:"
                + logClientSignature(activateSessionRequest.getUserTokenSignature()));
  }

  private static org.eclipse.milo.opcua.stack.core.types.structured.SignedSoftwareCertificate[]
      convert(SignedSoftwareCertificate... signedSoftwareCertificates) {
    return Optional.ofNullable(signedSoftwareCertificates)
        .map(ActivateSessionRequestConverter::createSignedSoftwareCertificates)
        .orElse(null);
  }

  private static org.eclipse.milo.opcua.stack.core.types.builtin.ExtensionObject
      createExtensionObject(ExtensionObject extensionObject) {
    return Optional.ofNullable(extensionObject)
        .map(ActivateSessionRequestConverter::getExtensionObject)
        .orElse(null);
  }

  private static org.eclipse.milo.opcua.stack.core.types.builtin.NodeId createNodeId(
      Object identifier, UShort namespaceIndex) {
    return identifier instanceof UUID
        ? new org.eclipse.milo.opcua.stack.core.types.builtin.NodeId(
            namespaceIndex, (UUID) identifier)
        : new org.eclipse.milo.opcua.stack.core.types.builtin.NodeId(
            namespaceIndex, Optional.ofNullable(identifier).map(Object::toString).orElse(null));
  }

  private static org.eclipse.milo.opcua.stack.core.types.builtin.NodeId createNodeId(
      NodeId nodeId) {
    return Optional.ofNullable(nodeId).map(ActivateSessionRequestConverter::getNodeId).orElse(null);
  }

  private static org.eclipse.milo.opcua.stack.core.types.structured.RequestHeader
      createRequestHeader(RequestHeader requestHeader) {
    return Optional.ofNullable(requestHeader)
        .map(
            header ->
                new org.eclipse.milo.opcua.stack.core.types.structured.RequestHeader(
                    createNodeId(header.getAuthenticationToken()),
                    createTimestamp(requestHeader.getTimestamp()),
                    UInteger.valueOf(header.getRequestHandle()),
                    UInteger.valueOf(header.getReturnDiagnostics()),
                    header.getAuditEntryId(),
                    UInteger.valueOf(header.getTimeoutHint()),
                    createExtensionObject(header.getAdditionalHeader())))
        .orElse(null);
  }

  private static org.eclipse.milo.opcua.stack.core.types.structured.SignatureData
      createSignatureData(SignatureData signatureData) {
    return Optional.ofNullable(signatureData)
        .map(
            data ->
                new org.eclipse.milo.opcua.stack.core.types.structured.SignatureData(
                    data.getAlgorithm(), new ByteString(data.getSignature())))
        .orElse(null);
  }

  private static org.eclipse.milo.opcua.stack.core.types.structured.SignedSoftwareCertificate
      createSignatureData(SignedSoftwareCertificate signedSoftwareCertificate) {
    return Optional.ofNullable(signedSoftwareCertificate)
        .map(
            softwareCertificate ->
                new org.eclipse.milo.opcua.stack.core.types.structured.SignedSoftwareCertificate(
                    new ByteString(softwareCertificate.getCertificateData()),
                    new ByteString(softwareCertificate.getSignature())))
        .orElse(null);
  }

  private static org.eclipse.milo.opcua.stack.core.types.structured.SignedSoftwareCertificate[]
      createSignedSoftwareCertificates(SignedSoftwareCertificate... signedSoftwareCertificates) {
    var certificates =
        new org.eclipse.milo.opcua.stack.core.types.structured.SignedSoftwareCertificate
            [signedSoftwareCertificates.length];

    var length = signedSoftwareCertificates.length;

    var i = 0;
    while (i < length) {
      certificates[i] = createSignatureData(signedSoftwareCertificates[i]);
      i++;
    }

    return certificates;
  }

  private static DateTime createTimestamp(Instant instant) {
    return Optional.ofNullable(instant).map(DateTime::new).orElse(null);
  }

  private static org.eclipse.milo.opcua.stack.core.types.builtin.ExtensionObject getExtensionObject(
      ExtensionObject extensionObject) {
    var body = extensionObject.getBody();
    var nodeId = createNodeId(extensionObject.getEncodingId());

    org.eclipse.milo.opcua.stack.core.types.builtin.ExtensionObject object = null;

    if (body != null && nodeId != null)
      object =
          body instanceof byte[]
              ? new org.eclipse.milo.opcua.stack.core.types.builtin.ExtensionObject(
                  new ByteString((byte[]) body), nodeId)
              : new org.eclipse.milo.opcua.stack.core.types.builtin.ExtensionObject(
                  new XmlElement(body.toString()), nodeId);

    return object;
  }

  private static org.eclipse.milo.opcua.stack.core.types.builtin.NodeId getNodeId(NodeId nodeId) {
    var identifier = nodeId.getIdentifier();
    var namespaceIndex = UShort.valueOf(nodeId.getNamespaceIndex());

    return identifier instanceof byte[]
        ? new org.eclipse.milo.opcua.stack.core.types.builtin.NodeId(
            namespaceIndex, new ByteString((byte[]) identifier))
        : getNodeId(identifier, namespaceIndex);
  }

  private static org.eclipse.milo.opcua.stack.core.types.builtin.NodeId getNodeId(
      Object identifier, UShort namespaceIndex) {
    return identifier instanceof Integer
        ? new org.eclipse.milo.opcua.stack.core.types.builtin.NodeId(
            namespaceIndex, (int) identifier)
        : createNodeId(identifier, namespaceIndex);
  }

  private static String logAdditionalHeader(ExtensionObject extensionObject) {
    return Optional.ofNullable(extensionObject)
        .map(
            object ->
                "Body: "
                    + object.getBody()
                    + System.lineSeparator()
                    + "Encoding ID:"
                    + System.lineSeparator()
                    + logNodeId(object.getEncodingId()))
        .orElse(null);
  }

  private static String logClientSignature(SignatureData signatureData) {
    return Optional.ofNullable(signatureData)
        .map(
            data ->
                "Algorithm: "
                    + data.getAlgorithm()
                    + System.lineSeparator()
                    + "Signature: "
                    + Arrays.toString(data.getSignature()))
        .orElse(null);
  }

  private static String logClientSoftwareCertificates(
      SignedSoftwareCertificate... signedSoftwareCertificates) {
    return Optional.ofNullable(signedSoftwareCertificates)
        .map(ActivateSessionRequestConverter::logSignedSoftwareCertificate)
        .orElse(null);
  }

  private static String logNodeId(NodeId nodeId) {
    return Optional.ofNullable(nodeId)
        .map(
            id ->
                "Identifier: "
                    + id.getIdentifier()
                    + System.lineSeparator()
                    + "Namespace index: "
                    + id.getNamespaceIndex())
        .orElse(null);
  }

  private static String logRequestHeader(RequestHeader requestHeader) {
    return Optional.ofNullable(requestHeader)
        .map(
            header ->
                "Additional header:"
                    + System.lineSeparator()
                    + logAdditionalHeader(header.getAdditionalHeader())
                    + System.lineSeparator()
                    + "Get audit entry ID: "
                    + header.getAuditEntryId()
                    + "Get authentication token:"
                    + System.lineSeparator()
                    + logNodeId(header.getAuthenticationToken())
                    + System.lineSeparator()
                    + "Request handle: "
                    + header.getRequestHandle()
                    + System.lineSeparator()
                    + "Return diagnostics: "
                    + header.getReturnDiagnostics()
                    + System.lineSeparator()
                    + "Timeout hint: "
                    + header.getTimeoutHint()
                    + System.lineSeparator()
                    + "Timestamp: "
                    + header.getTimestamp())
        .orElse(null);
  }

  private static String logSignedSoftwareCertificate(
      SignedSoftwareCertificate... signedSoftwareCertificates) {
    var stringBuilder = new StringBuilder(0);

    for (var signedSoftwareCertificate : signedSoftwareCertificates) {
      if (stringBuilder.length() > 0) stringBuilder.append(System.lineSeparator());

      stringBuilder
          .append("Certificate data: ")
          .append(Arrays.toString(signedSoftwareCertificate.getCertificateData()))
          .append(System.lineSeparator())
          .append("Signed signature: ")
          .append(Arrays.toString(signedSoftwareCertificate.getSignature()));
    }

    return stringBuilder.toString();
  }
}
