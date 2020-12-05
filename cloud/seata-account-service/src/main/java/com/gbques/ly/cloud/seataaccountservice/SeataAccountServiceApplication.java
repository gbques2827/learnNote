package com.gbques.ly.cloud.seataaccountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//排除数据库依赖
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//开启服务注册
@EnableDiscoveryClient
//开启Feign客户端
public class SeataAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeataAccountServiceApplication.class, args);
	}

}
