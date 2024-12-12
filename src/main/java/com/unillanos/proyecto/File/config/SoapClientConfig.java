package com.unillanos.proyecto.File.config;

import com.unillanos.proyecto.File.service.soap.SoapClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Configuration
public class SoapClientConfig
{
  @Bean
  public Jaxb2Marshaller marshaller()
  {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setContextPath("com.unillanos.proyecto.File.soap");
    return marshaller;
  }

  @Bean
  public SoapClientService getSoapClient(Jaxb2Marshaller marshaller)
  {
    SoapClientService soapClientService = new SoapClientService();
    soapClientService.setDefaultUri("http://localhost:8080/fileOperation/FileRead");
    soapClientService.setMarshaller(marshaller);
    soapClientService.setUnmarshaller(marshaller);
    return soapClientService;
  }
}
