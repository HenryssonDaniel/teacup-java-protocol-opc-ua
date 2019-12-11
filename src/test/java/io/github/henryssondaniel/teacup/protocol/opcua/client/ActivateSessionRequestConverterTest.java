package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.AUDIT_ENTRY_ID;
import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.IDENTIFIER;
import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.LOCALE_ID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.nio.charset.Charset;
import java.time.Instant;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ActivateSessionRequestConverterTest {
  private static final String BODY = "body";

  private final ActivateSessionRequest activateSessionRequest =
      mock(ActivateSessionRequestImpl.class);
  private final ExtensionObject extensionObject = mock(ExtensionObject.class);
  private final Instant instant = Instant.now();
  private final NodeId nodeId = mock(NodeId.class);
  private final RequestConverter requestConverter =
      new ActivateSessionRequestConverter(activateSessionRequest);
  private final RequestHeader requestHeader = mock(RequestHeader.class);
  private final SignatureData signatureData = mock(SignatureData.class);
  private final SignedSoftwareCertificate signedSoftwareCertificate =
      mock(SignedSoftwareCertificate.class);

  @BeforeEach
  void beforeEach() {
    when(activateSessionRequest.getClientSignature()).thenReturn(signatureData);
    when(activateSessionRequest.getClientSoftwareCertificates())
        .thenReturn(
            new SignedSoftwareCertificate[] {signedSoftwareCertificate, signedSoftwareCertificate});
    when(activateSessionRequest.getLocaleIds()).thenReturn(new String[] {LOCALE_ID});
    when(activateSessionRequest.getRequestHeader()).thenReturn(requestHeader);
    when(activateSessionRequest.getUserIdentityToken()).thenReturn(extensionObject);
    when(activateSessionRequest.getUserTokenSignature()).thenReturn(signatureData);

    when(extensionObject.getBody()).thenReturn(BODY);
    when(extensionObject.getEncodingId()).thenReturn(nodeId);

    when(requestHeader.getAdditionalHeader()).thenReturn(extensionObject);
    when(requestHeader.getAuditEntryId()).thenReturn(AUDIT_ENTRY_ID);
    when(requestHeader.getAuthenticationToken()).thenReturn(nodeId);
    when(requestHeader.getRequestHandle()).thenReturn(1);
    when(requestHeader.getReturnDiagnostics()).thenReturn(1);
    when(requestHeader.getTimeoutHint()).thenReturn(1);
    when(requestHeader.getTimestamp()).thenReturn(instant);
  }

  @Test
  void convert() {
    when(extensionObject.getBody()).thenReturn(null, BODY.getBytes(Charset.defaultCharset()));
    when(nodeId.getIdentifier()).thenReturn(UUID.randomUUID(), 1, IDENTIFIER);
    assertThat(requestConverter.convert())
        .isExactlyInstanceOf(
            org.eclipse.milo.opcua.stack.core.types.structured.ActivateSessionRequest.class);

    verifyFull();
  }

  @Test
  void convertWhenEverythingNull() {
    when(activateSessionRequest.getClientSignature()).thenReturn(null);
    when(activateSessionRequest.getClientSoftwareCertificates()).thenReturn(null);
    when(activateSessionRequest.getLocaleIds()).thenReturn(null);
    when(activateSessionRequest.getRequestHeader()).thenReturn(null);
    when(activateSessionRequest.getUserIdentityToken()).thenReturn(null);
    when(activateSessionRequest.getUserTokenSignature()).thenReturn(null);

    assertThat(requestConverter.convert())
        .isExactlyInstanceOf(
            org.eclipse.milo.opcua.stack.core.types.structured.ActivateSessionRequest.class);

    verifyActivateSessionRequest();
  }

  @Test
  void convertWhenIdentifierIsByteArray() {
    when(extensionObject.getBody()).thenReturn(BODY);
    when(nodeId.getIdentifier()).thenReturn(IDENTIFIER.getBytes(Charset.defaultCharset()));

    assertThat(requestConverter.convert())
        .isExactlyInstanceOf(
            org.eclipse.milo.opcua.stack.core.types.structured.ActivateSessionRequest.class);

    verifyActivateSessionRequest();
    verifyExtensionObject(2);
    verifyNodeId(3);
    verifyRequestHeader();
    verifySignatureData();
    verifySignedSoftwareCertificate();
  }

  @Test
  void convertWhenRequestHeaderDataIsNull() {
    when(extensionObject.getEncodingId()).thenReturn(null);

    when(requestHeader.getAdditionalHeader()).thenReturn(null);
    when(requestHeader.getAuthenticationToken()).thenReturn(null);
    when(requestHeader.getTimestamp()).thenReturn(null);

    assertThat(requestConverter.convert())
        .isExactlyInstanceOf(
            org.eclipse.milo.opcua.stack.core.types.structured.ActivateSessionRequest.class);

    verifyActivateSessionRequest();
    verifyExtensionObject(1);
    verifyRequestHeader();
    verifySignatureData();
    verifySignedSoftwareCertificate();
  }

  @Test
  void log() {
    requestConverter.log();

    verifyActivateSessionRequest();
    verifyExtensionObject(2);
    verifyNodeId(3);
    verifyRequestHeader();
    verifySignatureData();
    verifySignedSoftwareCertificate();
  }

  @Test
  void logWhenEverythingNull() {
    when(activateSessionRequest.getClientSignature()).thenReturn(null);
    when(activateSessionRequest.getClientSoftwareCertificates()).thenReturn(null);
    when(activateSessionRequest.getLocaleIds()).thenReturn(null);
    when(activateSessionRequest.getRequestHeader()).thenReturn(null);
    when(activateSessionRequest.getUserIdentityToken()).thenReturn(null);
    when(activateSessionRequest.getUserTokenSignature()).thenReturn(null);

    requestConverter.log();

    verifyActivateSessionRequest();
  }

  @Test
  void logWhenRequestHeaderArgumentsIsNull() {
    when(requestHeader.getAdditionalHeader()).thenReturn(null);
    when(requestHeader.getAuthenticationToken()).thenReturn(null);
    when(requestHeader.getTimestamp()).thenReturn(null);

    requestConverter.log();

    verifyActivateSessionRequest();
    verifyExtensionObject(1);
    verifyNodeId(1);
    verifyRequestHeader();
    verifySignatureData();
    verifySignedSoftwareCertificate();
  }

  private void verifyActivateSessionRequest() {
    verify(activateSessionRequest).getClientSignature();
    verify(activateSessionRequest).getClientSoftwareCertificates();
    verify(activateSessionRequest).getLocaleIds();
    verify(activateSessionRequest).getRequestHeader();
    verify(activateSessionRequest).getUserIdentityToken();
    verify(activateSessionRequest).getUserTokenSignature();
    verifyNoMoreInteractions(activateSessionRequest);
  }

  private void verifyExtensionObject(int times) {
    verify(extensionObject, times(times)).getBody();
    verify(extensionObject, times(times)).getEncodingId();
    verifyNoMoreInteractions(extensionObject);
  }

  private void verifyFull() {
    verifyActivateSessionRequest();
    verifyExtensionObject(2);
    verifyNodeId(3);
    verifyRequestHeader();
    verifySignatureData();
    verifySignedSoftwareCertificate();
  }

  private void verifyNodeId(int times) {
    verify(nodeId, times(times)).getIdentifier();
    verify(nodeId, times(times)).getNamespaceIndex();
    verifyNoMoreInteractions(nodeId);
  }

  private void verifyRequestHeader() {
    verify(requestHeader).getAdditionalHeader();
    verify(requestHeader).getAuditEntryId();
    verify(requestHeader).getAuthenticationToken();
    verify(requestHeader).getRequestHandle();
    verify(requestHeader).getReturnDiagnostics();
    verify(requestHeader).getTimeoutHint();
    verify(requestHeader).getTimestamp();
    verifyNoMoreInteractions(requestHeader);
  }

  private void verifySignatureData() {
    verify(signatureData, times(2)).getAlgorithm();
    verify(signatureData, times(2)).getSignature();
    verifyNoMoreInteractions(signatureData);
  }

  private void verifySignedSoftwareCertificate() {
    verify(signedSoftwareCertificate, times(2)).getCertificateData();
    verify(signedSoftwareCertificate, times(2)).getSignature();
    verifyNoMoreInteractions(signedSoftwareCertificate);
  }
}
