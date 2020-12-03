package com.gbques.ly.cloud.consulconfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//服务发现
@EnableDiscoveryClient
public class ConsulConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsulConfigClientApplication.class, args);
	}

}
