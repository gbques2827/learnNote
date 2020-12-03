package com.gbques.ly.cloud.feignservice.service.impl;

import com.gbques.ly.cloud.feignservice.model.CommonResult;
import com.gbques.ly.cloud.feignservice.model.User;
import com.gbques.ly.cloud.feignservice.service.UserService;
import org.springframework.stereotype.Component;

/**
 * @author ly
 * @since 2020-11-29 14:47
 */
//必须添加该注释，让启动类扫描到该类
@Component
public class UserFallbackService implements UserService {
    @Override
    public CommonResult create(User user) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser);
    }

    @Override
    public CommonResult<User> getUser(Long id) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser);
    }

    @Override
    public CommonResult<User> getByUsername(String username) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser);
    }

    @Override
    public CommonResult update(User user) {
        return new CommonResult("调用失败，服务被降级",500);
    }

    @Override
    public CommonResult delete(Long id) {
        return new CommonResult("调用失败，服务被降级",500);
    }
}
