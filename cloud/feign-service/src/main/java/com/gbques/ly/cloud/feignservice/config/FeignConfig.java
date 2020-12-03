package com.gbques.ly.cloud.feignservice.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ly
 * @since 2020-11-29 14:54
 */
//只要有@Bean就使用@Configuration注解，没就使用@Component
@Configuration
public class FeignConfig {
    //配置打印日志
    @Bean
    Logger.Level feignLoggerLevel() {
        /*NONE：默认的，不显示任何日志；
        BASIC：仅记录请求方法、URL、响应状态码及执行时间；
        HEADERS：除了BASIC中定义的信息之外，还有请求和响应的头信息；
        FULL：除了HEADERS中定义的信息之外，还有请求和响应的正文及元数据。*/
        return Logger.Level.FULL;
    }
}