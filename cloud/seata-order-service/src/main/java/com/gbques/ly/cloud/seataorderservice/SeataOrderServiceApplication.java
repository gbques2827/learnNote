package com.gbques.ly.cloud.seataorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
//排除数据库依赖
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//开启服务注册
@EnableDiscoveryClient
//开启Feign客户端
@EnableFeignClients
public class SeataOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeataOrderServiceApplication.class, args);
	}

}
