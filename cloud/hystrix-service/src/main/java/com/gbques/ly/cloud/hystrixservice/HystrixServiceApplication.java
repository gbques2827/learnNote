package com.gbques.ly.cloud.hystrixservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//开启Hystrix的断路器功能
@EnableCircuitBreaker
//表明这是一个eureka客户端
@EnableDiscoveryClient
@SpringBootApplication
public class HystrixServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixServiceApplication.class, args);
	}

}
