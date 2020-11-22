package com.gbques.ly.malltiny01.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author helen
 * @since 2020/4/1
 */
//事务，保证事务的原子性
@EnableTransactionManagement
@Configuration
//这里扫描是dao层接口
@MapperScan("com.gbques.ly.malltiny01.dao")
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
