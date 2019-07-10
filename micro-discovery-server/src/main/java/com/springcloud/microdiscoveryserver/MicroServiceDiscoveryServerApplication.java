package com.springcloud.microdiscoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroServiceDiscoveryServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceDiscoveryServerApplication.class, args);
    }

}
