package com.unillanos.proyecto.File.config;

import com.unillanos.proyecto.File.service.soap.SoapClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfig
{

  @Value("${soap.service.uri}")
  private String soapServiceUri;

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
    soapClientService.setDefaultUri(soapServiceUri);
    soapClientService.setMarshaller(marshaller);
    soapClientService.setUnmarshaller(marshaller);
    return soapClientService;
  }
}
