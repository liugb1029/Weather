package com.song.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CollectionController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/service/{name}")
    public List<ServiceInstance> serviceUrl(@PathVariable("name") String serviceName) {
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
        return instances;
    }

    @GetMapping("/services")
    public List<String> services(String serviceName) {
        List<String> services = discoveryClient.getServices();
        return services;
    }

}
