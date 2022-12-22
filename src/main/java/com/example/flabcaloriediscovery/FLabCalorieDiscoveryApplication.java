package com.example.flabcaloriediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FLabCalorieDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(FLabCalorieDiscoveryApplication.class, args);
    }

}
