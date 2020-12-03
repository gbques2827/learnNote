package com.gbques.ly.eurekasecurityserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//启用Euerka注册中心功能
@EnableEurekaServer
public class EurekaSecurityServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaSecurityServerApplication.class, args);
	}

}
