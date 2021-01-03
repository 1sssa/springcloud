package com.cloud.newsprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class NewsProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsProviderApplication.class, args);
    }

}
