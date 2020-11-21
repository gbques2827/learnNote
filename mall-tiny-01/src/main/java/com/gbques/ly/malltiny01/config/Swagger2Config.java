package com.gbques.ly.malltiny01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ly
 * @since 2020-11-18 19:50
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    //划分各个服务
    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gbques.ly.malltiny01.controller"))
                //只显示api路径下的页面
                //Predicates.and(PathSelectors.regex("/api/.*"))
                .paths(PathSelectors.regex("/api/.*"))
                .build();

    }


    //定义信息
    private ApiInfo webApiInfo(){
        return new ApiInfoBuilder()
                .title("mall-tiny")
                .description("SwaggerUI演示")
                .version("1.0")
                .contact(new Contact("ly","xxx","xxx@qq.com"))
                .build();
    }

}
