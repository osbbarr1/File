package com.unillanos.proyecto.File.service.soap;

import com.unillanos.proyecto.File.soap.*;
import jakarta.xml.bind.JAXBElement;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.io.File;
import java.util.List;


public class SoapClientService extends WebServiceGatewaySupport
{

  public FileDTO getFileUUID(String uuid) {
    // Crear el request
    GetFileUUID request = new GetFileUUID();
    request.setUuid(uuid);

    SoapActionCallback soapActionCallback = new SoapActionCallback("http://services/");

    Object response = getWebServiceTemplate()
        .marshalSendAndReceive(request, soapActionCallback);

    if (response instanceof JAXBElement element) {

      GetFileUUIDResponse fileInfo = (GetFileUUIDResponse) element.getValue();
      return fileInfo.getReturn();
    }
    throw new IllegalStateException("Unexpected response type: " + response.getClass());
  }


  public List<FileDTO> getFileList() {
    GetFileList request = new GetFileList();
    Object response = getWebServiceTemplate()
        .marshalSendAndReceive("http://localhost:8080/fileOperation/FileRead", request,
            new SoapActionCallback("http://services/"));
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
