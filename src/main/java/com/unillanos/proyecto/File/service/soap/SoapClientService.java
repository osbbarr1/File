package com.unillanos.proyecto.File.service.soap;

import com.unillanos.proyecto.File.soap.*;
import jakarta.xml.bind.JAXBElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.List;


public class SoapClientService extends WebServiceGatewaySupport
{

  @Value("${soap.service.uri}")
  private String soapServiceUri;

  public File getFileUUID(String uuid) {
    GetFileUUID request = new GetFileUUID();
    request.setUuid(uuid);

    SoapActionCallback soapActionCallback = new SoapActionCallback("");

    Object response = getWebServiceTemplate()
        .marshalSendAndReceive(request, soapActionCallback);

    if (response instanceof JAXBElement element) {

      GetFileUUIDResponse fileInfo = (GetFileUUIDResponse) element.getValue();
      return fileInfo.getReturn();
    }
    throw new IllegalStateException("Unexpected response type: " + response.getClass());
  }


  public List<File> getFileList() {
    GetFileList request = new GetFileList();
    Object response = getWebServiceTemplate()
        .marshalSendAndReceive(soapServiceUri, request,
            new SoapActionCallback(""));
    if (response instanceof JAXBElement<?> element) {
      GetFileListResponse fileInfo = (GetFileListResponse) element.getValue();
      if (fileInfo.getReturn() != null && fileInfo.getReturn().getFileList() != null) {
        return fileInfo.getReturn().getFileList();
      } else {
        throw new IllegalStateException("File list is empty or null.");
      }
    }
    throw new IllegalStateException("Unexpected response type: " + response.getClass());
  }
}
