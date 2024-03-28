package com.zdf.trafficcustomsdeclaration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * @author mrzhang
 * @date 2024/3/25 22:58
 */
@SpringBootApplication
@EnableDiscoveryClient
public class TrafficCustomsDeclarationApplication {
    public static void main(String[] args) {
        SpringApplication.run(TrafficCustomsDeclarationApplication.class, args);
    }
}
