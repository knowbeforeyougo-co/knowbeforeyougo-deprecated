package com.yakovliam.knowbeforeyougo.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ClientApplication {

    /**
     * Entry point for the client
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }
}
