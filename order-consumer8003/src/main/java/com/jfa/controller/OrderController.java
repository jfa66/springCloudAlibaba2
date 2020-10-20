package com.jfa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    /*@Value("${service-url.nacos-user-service}")
    private String service_url;*/

    @Value("${service.name}")
    private String serviceName;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/nacos/{id}")
    public String getService_url(@PathVariable("id") Long id){
        ServiceInstance serviceInstance=loadBalancerClient.choose("nacos-payment-provider");
        String path=String.format("http://%s:%s/%s/nacos/"+id,serviceInstance.getHost(),serviceInstance.getPort(),serviceName);
        System.out.println("request path："+path);
        return restTemplate.getForObject(path,String.class);
    }
}
