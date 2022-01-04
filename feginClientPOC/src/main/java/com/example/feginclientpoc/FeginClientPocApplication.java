package com.example.feginclientpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeginClientPocApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeginClientPocApplication.class, args);
    }

}
