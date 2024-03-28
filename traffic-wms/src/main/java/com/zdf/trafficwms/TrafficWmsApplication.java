package com.zdf.trafficwms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author mrzhang
 * @date 2024/3/27 01:08
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.zdf.trafficwms.mapper")
public class TrafficWmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(TrafficWmsApplication.class, args);
    }

}
