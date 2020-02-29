package com.xydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class XydemoSpringcloudProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(XydemoSpringcloudProviderApplication.class, args);
    }

}
