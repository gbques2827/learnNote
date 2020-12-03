package com.gbques.ly.cloud.configsecurityserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
//开启config配置中心
@EnableConfigServer
public class ConfigSecurityServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigSecurityServerApplication.class, args);
	}

}
