package com.doisbitsw.licencas;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication


public class LicencasApplication {

    public static void main(String[] args) {
        SpringApplication.run(LicencasApplication.class, args);
    }

}