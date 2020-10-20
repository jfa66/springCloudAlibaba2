package com.jfa.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.jfa")
public class Payment9003Application {

    public static void main(String[] args) {
        SpringApplication.run(Payment9003Application.class,args);
    }
}
