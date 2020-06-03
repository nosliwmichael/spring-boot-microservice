package com.sbm.scraper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.sbm.client")
public class ScraperProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScraperProviderApplication.class, args);
    }

}