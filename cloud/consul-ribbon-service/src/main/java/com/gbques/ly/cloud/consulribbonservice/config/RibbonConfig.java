package com.gbques.ly.cloud.consulribbonservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ly
 * @since 2020-11-27 10:03
 */
@Configuration
public class RibbonConfig {

    @Bean
    //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}