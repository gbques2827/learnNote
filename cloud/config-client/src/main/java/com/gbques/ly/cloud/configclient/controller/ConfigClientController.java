package com.gbques.ly.cloud.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ly
 * @since 2020-11-30 14:47
 */
@RestController
//开启时时刷新客户端配置
@RefreshScope
public class ConfigClientController {

    //config-dev.yml,对该文件进行操作
   /* config:
        info: "config info for dev(dev)"*/


    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }
}
