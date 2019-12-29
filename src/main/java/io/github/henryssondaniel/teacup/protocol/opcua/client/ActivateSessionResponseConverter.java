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

    ActivateSessionResponseBuilder activateSessionResponseBuilder =
        new ActivateSessionResponseBuilderImpl();
    setBinaryEncodingId(activateSessionResponseBuilder);
    setDiagnosticInfos(activateSessionResponseBuilder);
    setResponseHeader(activateSessionResponseBuilder);
    setResults(activateSessionResponseBuilder);
    setServerNonce(activateSessionResponseBuilder);
    setTypeId(activateSessionResponseBuilder);
    setXmlEncodingId(activateSessionResponseBuilder);

    return activateSessionResponseBuilder.build();
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
    ResponseHeaderBuilder responseHeaderBuilder = new ResponseHeaderBuilderImpl();
    setExtensionObject(responseHeader.getAdditionalHeader(), responseHeaderBuilder);
    setBinaryEncoding(responseHeader.getBinaryEncodingId(), responseHeaderBuilder);
    setRequestHandle(responseHeader, responseHeaderBuilder);
    setServiceDiagnostics(responseHeader, responseHeaderBuilder);
    setServiceResult(responseHeader, responseHeaderBuilder);
    responseHeaderBuilder.setStringTable(responseHeader.getStringTable());
    setTimestamp(responseHeader, responseHeaderBuilder);
    setTypeId(responseHeader.getTypeId(), responseHeaderBuilder);
    setXmlEncodingId(responseHeader.getXmlEncodingId(), responseHeaderBuilder);

    return responseHeaderBuilder.build();
  }

  private static void setBinaryEncoding(
      org.eclipse.milo.opcua.stack.core.types.builtin.NodeId nodeId,
      ResponseHeaderBuilder responseHeaderBuilder) {
    if (nodeId != null) responseHeaderBuilder.setBinaryEncodingId(createNodeId(nodeId));
  }

  private void setBinaryEncodingId(ActivateSessionResponseBuilder activateSessionResponseBuilder) {
    var binaryEncodingId = activateSessionResponse.getBinaryEncodingId();
    if (binaryEncodingId != null)
      activateSessionResponseBuilder.setBinaryEncodingId(createNodeId(binaryEncodingId));
  }

  private void setDiagnosticInfos(ActivateSessionResponseBuilder activateSessionResponseBuilder) {
    var diagnosticInfos = activateSessionResponse.getDiagnosticInfos();
    if (diagnosticInfos != null)
      activateSessionResponseBuilder.setDiagnosticInfos(
          Arrays.stream(diagnosticInfos)
              .map(ActivateSessionResponseConverter::createDiagnosticInfo)
              .toArray(
                  io.github.henryssondaniel.teacup.protocol.opcua.client.DiagnosticInfo[]::new));
  }

  private static void setExtensionObject(
      ExtensionObject extensionObject, ResponseHeaderBuilder responseHeaderBuilder) {
    if (extensionObject != null)
      responseHeaderBuilder.setAdditionalHeader(
          new ExtensionObjectImpl(
              extensionObject.getBody(), createNodeId(extensionObject.getEncodingId())));
  }

  private static void setRequestHandle(
      ResponseHeader responseHeader, ResponseHeaderBuilder responseHeaderBuilder) {
    var requestHandle = responseHeader.getRequestHandle();
    if (requestHandle != null) responseHeaderBuilder.setRequestHandle(requestHandle.intValue());
  }

  private void setResponseHeader(ActivateSessionResponseBuilder activateSessionResponseBuilder) {
    var responseHeader = activateSessionResponse.getResponseHeader();
    if (responseHeader != null)
      activateSessionResponseBuilder.setResponseHeader(createResponseHeader(responseHeader));
  }

  private void setResults(ActivateSessionResponseBuilder activateSessionResponseBuilder) {
    var statusCodes = activateSessionResponse.getResults();

    if (statusCodes != null) {
      var length = statusCodes.length;

      var results = new long[length];
      var i = 0;
      while (i < length) {
        results[i] = statusCodes[i].getValue();
        i++;
      }

      activateSessionResponseBuilder.setResults(results);
    }
  }

  private void setServerNonce(ActivateSessionResponseBuilder activateSessionResponseBuilder) {
    var serverNonce = activateSessionResponse.getServerNonce();
    if (serverNonce != null) activateSessionResponseBuilder.setServerNonce(serverNonce.bytes());
  }

  private static void setServiceDiagnostics(
      ResponseHeader responseHeader, ResponseHeaderBuilder responseHeaderBuilder) {
    var serviceDiagnostics = responseHeader.getServiceDiagnostics();
    if (serviceDiagnostics != null)
      responseHeaderBuilder.setServiceDiagnostics(createDiagnosticInfo(serviceDiagnostics));
  }

  private static void setServiceResult(
      ResponseHeader responseHeader, ResponseHeaderBuilder responseHeaderBuilder) {
    var serviceResult = responseHeader.getServiceResult();
    if (serviceResult != null) responseHeaderBuilder.setServiceResult(serviceResult.getValue());
  }

  private static void setTimestamp(
      ResponseHeader responseHeader, ResponseHeaderBuilder responseHeaderBuilder) {
    var timestamp = responseHeader.getTimestamp();
    if (timestamp != null) responseHeaderBuilder.setTimestamp(timestamp.getJavaInstant());
  }

  private static void setTypeId(
      org.eclipse.milo.opcua.stack.core.types.builtin.NodeId nodeId,
      ResponseHeaderBuilder responseHeaderBuilder) {
    if (nodeId != null) responseHeaderBuilder.setTypeId(createNodeId(nodeId));
  }

  private void setTypeId(ActivateSessionResponseBuilder activateSessionResponseBuilder) {
    var typeId = activateSessionResponse.getTypeId();
    if (typeId != null) activateSessionResponseBuilder.setTypeId(createNodeId(typeId));
  }

  private static void setXmlEncodingId(
      org.eclipse.milo.opcua.stack.core.types.builtin.NodeId nodeId,
      ResponseHeaderBuilder responseHeaderBuilder) {
    if (nodeId != null) responseHeaderBuilder.setXmlEncodingId(createNodeId(nodeId));
  }

  private void setXmlEncodingId(ActivateSessionResponseBuilder activateSessionResponseBuilder) {
    var xmlEncodingId = activateSessionResponse.getXmlEncodingId();
    if (xmlEncodingId != null)
      activateSessionResponseBuilder.setXmlEncodingId(createNodeId(xmlEncodingId));
  }
}
