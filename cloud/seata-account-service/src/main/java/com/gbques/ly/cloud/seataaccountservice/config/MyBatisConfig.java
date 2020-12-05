package com.gbques.ly.cloud.seataaccountservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.gbques.ly.cloud.seataaccountservice.dao"})
public class MyBatisConfig {
}
