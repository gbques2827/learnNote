package com.gbques.ly.cloud.seatastorageservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.gbques.ly.cloud.seatastorageservice.dao"})
public class MyBatisConfig {
}
