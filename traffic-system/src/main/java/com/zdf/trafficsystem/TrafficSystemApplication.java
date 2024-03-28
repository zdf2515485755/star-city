package com.zdf.trafficsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author mrzhang
 * @date 2024/3/23 02:31
 */
@SpringBootApplication
@EnableDiscoveryClient
public class TrafficSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrafficSystemApplication.class, args);
    }

}
