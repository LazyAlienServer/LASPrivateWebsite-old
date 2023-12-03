package com.las.lasbackendapigateway9000;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LasBackendApiGateway9000Application {

    public static void main(String[] args) {
        SpringApplication.run(LasBackendApiGateway9000Application.class, args);
    }

}
