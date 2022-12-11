package com.example.springgatewayfirstservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class SpringGatewayFirstserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringGatewayFirstserviceApplication.class, args);
    }

}
