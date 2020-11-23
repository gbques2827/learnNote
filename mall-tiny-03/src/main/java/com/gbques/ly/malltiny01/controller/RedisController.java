package com.gbques.ly.malltiny01.controller;

import com.alibaba.druid.util.StringUtils;
import com.gbques.ly.malltiny01.common.CommonResult;
import com.gbques.ly.malltiny01.utils.FormUtils;
import com.gbques.ly.malltiny01.utils.RandomUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author ly
 * @since 2020-11-21 12:07
 */
@RequestMapping("/api/redis")
@RestController
@Api(tags = "验证码验证")
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate;

    //生成验证码
    //查询全部
    @GetMapping("/getCode")
    @ApiOperation("生成验证码")
    public CommonResult generateAuthCode(String phone) {
        //验证手机号是否正确
        if (StringUtils.isEmpty(phone) || !FormUtils.isMobile(phone)) {
            return CommonResult.failed("手机号不正确");
        }
        //生成验证码
        String code = RandomUtils.getFourBitRandom();
        redisTemplate.opsForValue().set(phone, code, 30, TimeUnit.MINUTES);
        return CommonResult.success(code);
    }

    //验证验证码是否正确
    @GetMapping("/verify")
    @ApiOperation("验证验证码")
    public CommonResult verifyAuthCode(String phone, String code) {
        //验证手机号是否正确
        if (StringUtils.isEmpty(phone) || !FormUtils.isMobile(phone)) {
            return CommonResult.failed("手机号不正确");
        }
        //验证code是否存在
        if (StringUtils.isEmpty(code)) {
            return CommonResult.failed("验证码不能为空");
        }
        //验证是否正确
        //通过手机号获取验证码
        if(!code.equals(redisTemplate.opsForValue().get(phone))){
            return CommonResult.failed("验证码不正确");
        }
        return CommonResult.success("验证通过");
    }
}
