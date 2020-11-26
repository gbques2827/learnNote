package com.gbques.ly.malltiny01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

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
                .build()
                //添加登录认证
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());

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

    private List<ApiKey> securitySchemes() {
        //设置请求头信息，这里是通过swagger的方式进行权限验证
        List<ApiKey> result = new ArrayList<>();
        /*
        *  name: Authorization
         * in: header
         * value: Bearer
        * */
        ApiKey apiKey = new ApiKey("Authorization", "Authorization", "header");
        result.add(apiKey);
        return result;
    }

    private List<SecurityContext> securityContexts() {
        //设置需要登录认证的路径
        List<SecurityContext> result = new ArrayList<>();
        result.add(getContextByPath("/api/brand/.*"));
        return result;
    }

    //设置需要登录认证的路径
    private SecurityContext getContextByPath(String pathRegex){
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex(pathRegex))
                .build();
    }

    //默认权限
    private List<SecurityReference> defaultAuth() {
        //SecurityReference：安全参考
        List<SecurityReference> result = new ArrayList<>();
        //accessEverything：访问所有内容  AuthorizationScope：授权范围
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        result.add(new SecurityReference("Authorization", authorizationScopes));
        return result;
    }

}
