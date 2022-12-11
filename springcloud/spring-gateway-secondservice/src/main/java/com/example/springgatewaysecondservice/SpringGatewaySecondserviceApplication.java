package com.example.springgatewaysecondservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class SpringGatewaySecondserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringGatewaySecondserviceApplication.class, args);
    }

}
