package com.gbques.ly.cloud.apigateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * @author ly
 * @since 2020-12-02 15:25
 */
@Configuration
public class RedisRateLimiterConfig {
    //只能留一个
   /* @Bean
    public KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("username"));
    }*/

    @Bean
    public KeyResolver ipKeyResolver() {
        //Objects.requireNonNull判断是否为空，为空抛异常，不为空直接返回原对象
        return exchange -> Mono.just(Objects.requireNonNull(exchange.getRequest().getRemoteAddress()).getHostName());
    }
}
