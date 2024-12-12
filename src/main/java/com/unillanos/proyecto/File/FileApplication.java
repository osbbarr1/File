package com.unillanos.proyecto.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class FileApplication {

  public static void main(String[] args) {

    Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
    System.setProperty("MYSQL_URL", dotenv.get("MYSQL_URL"));
    System.setProperty("MYSQL_USERNAME", dotenv.get("MYSQL_USERNAME"));
    System.setProperty("MYSQL_PASSWORD", dotenv.get("MYSQL_PASSWORD"));
    SpringApplication.run(FileApplication.class, args);

  }

  /*
   * @Bean
   * CommandLineRunner init(SoapClientService soapClientService){
   * return args -> {
   * List<FileDTO> lis = soapClientService.getFileList();
   * System.out.println("El resultado obtenido ES ====>>>>> {}") ;
   * };
   * }
   */
}