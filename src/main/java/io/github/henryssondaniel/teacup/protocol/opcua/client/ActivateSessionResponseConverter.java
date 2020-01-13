package io.github.henryssondaniel.teacup.protocol.opcua.client;

import static io.github.henryssondaniel.teacup.protocol.opcua.client.Constants.CONVERT;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.milo.opcua.stack.core.types.builtin.DiagnosticInfo;
import org.eclipse.milo.opcua.stack.core.types.builtin.ExtensionObject;
import org.eclipse.milo.opcua.stack.core.types.structured.ActivateSessionResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.ResponseHeader;

class ActivateSessionResponseConverter implements Converter<Response> {
  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(
          ActivateSessionResponseConverter.class);
  private final ActivateSessionResponse activateSessionResponse;

  ActivateSessionResponseConverter(ActivateSessionResponse activateSessionResponse) {
    this.activateSessionResponse = activateSessionResponse;
  }

  @Override
  public Response convert() {
    LOGGER.log(Level.FINE, CONVERT);

    ActivateSessionResponseSetter activateSessionResponseSetter = new ActivateSessionResponseImpl();
    setDiagnosticInfos(activateSessionResponseSetter);
    setResponseHeader(activateSessionResponseSetter);
    setResults(activateSessionResponseSetter);
    setServerNonce(activateSessionResponseSetter);

    return activateSessionResponseSetter;
  }

  @Override
  public void log() {
    LOGGER.log(Level.INFO, () -> "Response:" + System.lineSeparator() + activateSessionResponse);
  }

  private static io.github.henryssondaniel.teacup.protocol.opcua.client.DiagnosticInfo
      createDiagnosticInfo(DiagnosticInfo diagnosticInfo) {
    DiagnosticInfoBuilder diagnosticInfoBuilder = new DiagnosticInfoBuilderImpl();
    diagnosticInfoBuilder.setAdditionalInfo(diagnosticInfo.getAdditionalInfo());

    var innerDiagnosticInfo = diagnosticInfo.getInnerDiagnosticInfo();
    if (innerDiagnosticInfo != null)
      diagnosticInfoBuilder.setInnerDiagnosticInfo(createDiagnosticInfo(innerDiagnosticInfo));

    diagnosticInfoBuilder.setInnerStatusCode(diagnosticInfo.getInnerStatusCode().getValue());
    diagnosticInfoBuilder.setLocale(diagnosticInfo.getLocale());
    diagnosticInfoBuilder.setLocalizedText(diagnosticInfo.getLocalizedText());
    diagnosticInfoBuilder.setNamespaceUri(diagnosticInfo.getNamespaceUri());
    diagnosticInfoBuilder.setSymbolicId(diagnosticInfo.getSymbolicId());

    return diagnosticInfoBuilder.build();
  }

  private static NodeId createNodeId(
      org.eclipse.milo.opcua.stack.core.types.builtin.NodeId nodeId) {
    return new NodeIdImpl(nodeId.getIdentifier(), nodeId.getNamespaceIndex().shortValue());
  }

  private static io.github.henryssondaniel.teacup.protocol.opcua.client.ResponseHeader
      createResponseHeader(ResponseHeader responseHeader) {
    ResponseHeaderSetter responseHeaderSetter = new ResponseHeaderImpl();
    setExtensionObject(responseHeader.getAdditionalHeader(), responseHeaderSetter);
    setRequestHandle(responseHeader, responseHeaderSetter);
    setServiceDiagnostics(responseHeader, responseHeaderSetter);
    setServiceResult(responseHeader, responseHeaderSetter);
    responseHeaderSetter.setStringTable(responseHeader.getStringTable());
    setTimestamp(responseHeader, responseHeaderSetter);

    return responseHeaderSetter;
  }

  private void setDiagnosticInfos(ActivateSessionResponseSetter activateSessionResponseSetter) {
    var diagnosticInfos = activateSessionResponse.getDiagnosticInfos();
    if (diagnosticInfos != null)
      activateSessionResponseSetter.setDiagnosticInfos(
          Arrays.stream(diagnosticInfos)
              .map(ActivateSessionResponseConverter::createDiagnosticInfo)
              .toArray(
                  io.github.henryssondaniel.teacup.protocol.opcua.client.DiagnosticInfo[]::new));
  }

  private static void setExtensionObject(
      ExtensionObject extensionObject, ResponseHeaderSetter responseHeaderSetter) {
    if (extensionObject != null)
      responseHeaderSetter.setAdditionalHeader(
          new ExtensionObjectImpl(
              extensionObject.getBody(), createNodeId(extensionObject.getEncodingId())));
  }

  private static void setRequestHandle(
      ResponseHeader responseHeader, ResponseHeaderSetter responseHeaderSetter) {
    var requestHandle = responseHeader.getRequestHandle();
    if (requestHandle != null) responseHeaderSetter.setRequestHandle(requestHandle.intValue());
  }

  private void setResponseHeader(ResponseSetter responseSetter) {
    var responseHeader = activateSessionResponse.getResponseHeader();
    if (responseHeader != null)
      responseSetter.setResponseHeader(createResponseHeader(responseHeader));
  }

  private void setResults(ActivateSessionResponseSetter activateSessionResponseSetter) {
    var statusCodes = activateSessionResponse.getResults();

    if (statusCodes != null) {
      var length = statusCodes.length;

      var results = new long[length];
      var i = 0;
      while (i < length) {
        results[i] = statusCodes[i].getValue();
        i++;
      }

      activateSessionResponseSetter.setResults(results);
    }
  }

  private void setServerNonce(ActivateSessionResponseSetter activateSessionResponseSetter) {
    var serverNonce = activateSessionResponse.getServerNonce();
    if (serverNonce != null) activateSessionResponseSetter.setServerNonce(serverNonce.bytes());
  }

  private static void setServiceDiagnostics(
      ResponseHeader responseHeader, ResponseHeaderSetter responseHeaderSetter) {
    var serviceDiagnostics = responseHeader.getServiceDiagnostics();
    if (serviceDiagnostics != null)
      responseHeaderSetter.setServiceDiagnostics(createDiagnosticInfo(serviceDiagnostics));
  }

  private static void setServiceResult(
      ResponseHeader responseHeader, ResponseHeaderSetter responseHeaderSetter) {
    var serviceResult = responseHeader.getServiceResult();
    if (serviceResult != null) responseHeaderSetter.setServiceResult(serviceResult.getValue());
  }

  private static void setTimestamp(
      ResponseHeader responseHeader, ResponseHeaderSetter responseHeaderSetter) {
    var timestamp = responseHeader.getTimestamp();
    if (timestamp != null) responseHeaderSetter.setTimestamp(timestamp.getJavaInstant());
  }
}
