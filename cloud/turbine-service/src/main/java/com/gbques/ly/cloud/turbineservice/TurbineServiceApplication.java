package com.gbques.ly.cloud.turbineservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
//开启Turbine来聚合hystrix-service服务的监控信息
@EnableTurbine
//表示这是一个eureka客户端
@EnableDiscoveryClient
@SpringBootApplication
public class TurbineServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurbineServiceApplication.class, args);
	}

}
