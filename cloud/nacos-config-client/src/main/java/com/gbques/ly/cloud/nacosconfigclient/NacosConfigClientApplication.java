package com.gbques.ly.cloud.nacosconfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//开启服务注册发现
@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosConfigClientApplication.class, args);
	}

}
