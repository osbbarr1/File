package com.unillanos.proyecto.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class FileApplication {

	public static void main(String[] args) {
                Dotenv dotenv = Dotenv.load();
                System.setProperty("MYSQL_URL", dotenv.get("MYSQL_URL"));
                System.setProperty("MYSQL_USERNAME", dotenv.get("MYSQL_USERNAME"));
                System.setProperty("MYSQL_PASSWORD", dotenv.get("MYSQL_PASSWORD"));
		SpringApplication.run(FileApplication.class, args);
	}

}
