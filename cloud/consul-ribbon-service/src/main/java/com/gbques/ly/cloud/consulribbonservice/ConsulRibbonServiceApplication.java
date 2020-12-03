package com.gbques.ly.cloud.consulribbonservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient和@EnableEurekaClient一样的效果
//都是能够让注册中心能够发现，扫描到该服务
//@EnableEurekaClient只适用于Eureka作为注册中心，@EnableDiscoveryClient 可以是其他注册中心
//该注释可以省略但是最好写上
@EnableDiscoveryClient
public class ConsulRibbonServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsulRibbonServiceApplication.class, args);
	}

}
