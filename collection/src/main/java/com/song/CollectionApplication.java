package com.song;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class CollectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollectionApplication.class, args);
    }
}
