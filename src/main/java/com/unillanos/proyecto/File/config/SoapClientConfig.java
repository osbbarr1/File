package com.unillanos.proyecto.File.config;
import com.unillanos.proyecto.File.service.soap.SoapClientService;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.config.RequestConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;


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
    soapClientService.setMessageSender(createMessageSender());
    return soapClientService;
  }

  public HttpComponentsMessageSender createMessageSender() {
    HttpComponentsMessageSender messageSender = new HttpComponentsMessageSender();
    RequestConfig requestConfig = RequestConfig.custom()
            .setExpectContinueEnabled(false)
            .build();

    HttpClient httpClient = HttpClients.custom()
            .setDefaultRequestConfig(requestConfig)
            .addInterceptorFirst((HttpRequestInterceptor) (request, context) -> {
                  request.removeHeaders("Content-Length");
                  request.addHeader("authorization", "Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJleGFtcGxlVXNlciIsImlzcyI6InlvdXItYXBwIiwiaWF0IjoxNzM0MDM3MDk2LCJyb2xlIjoiQURNSU4ifQ.ugGlndkH26C4M9920QbV_vtgcSBAAuOOGaSwNrKFYoE");
            })
            .build();
    messageSender.setHttpClient(httpClient);
    return messageSender;
  }
}
