package me.fo0.geolocation.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class Main {

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

}
