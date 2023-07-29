package io.red.alice;

import io.red.alice.services.StorageProperties;
import io.red.alice.services.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class MsAliceApplication {

  public static void main(String[] args) {
    SpringApplication.run(MsAliceApplication.class, args);
  }

}
