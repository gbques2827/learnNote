package com.gbques.ly.malltiny01.config;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ly
 * @since 2020-11-26 9:49
 */
@Data
//该注释产生的都是新的实例
@Configuration
//@Component，只要没有@Bean就使用@Component
//注意prefix要写到最后一个 "." 符号之前
//@ConfigurationProperties这个注释同一前缀只能有一个
@ConfigurationProperties(prefix="aliyun.oss")
public class OssConfig {

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;

    @Bean
    public OSSClient ossClient(){
        //new OSSClient(endpoint, accessKeyId, accessKeySecret);该方法已经过期
        //这里可以直接生成OSS对象，但是在service层需要获取accessKeyId，oss对象不能获取，所以这里进行强转
        //建议使用新的方法
        return (OSSClient) new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }
}