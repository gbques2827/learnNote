package com.gbques.ly.cloud.nacosribbonservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//服务注册发现
@EnableDiscoveryClient
@SpringBootApplication
public class NacosRibbonServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosRibbonServiceApplication.class, args);
	}

}
