package com.gbques.ly.cloud.adminsecurityserver;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//开启服务注册发现
@EnableDiscoveryClient
//表示这是一个admin服务端
@EnableAdminServer
@SpringBootApplication
public class AdminSecurityServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminSecurityServerApplication.class, args);
	}

}
