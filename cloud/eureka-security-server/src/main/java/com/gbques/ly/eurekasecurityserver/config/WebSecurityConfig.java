package com.gbques.ly.eurekasecurityserver.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author ly
 * @since 2020-11-26 21:39
 */
@EnableWebSecurity //这个注解包括一系列注解，所以不需要@Configuration
//如果登录速率慢可以添加@Configuration试试
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /*
    * 默认情况下添加SpringSecurity依赖的应用每个请求都需要添加CSRF
     token才能访问，Eureka客户端注册时并不会添加，所以需要配置
     /eureka/**路径不需要CSRF token
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/eureka/**");
        super.configure(http);
    }
}