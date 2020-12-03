package com.gbques.ly.cloud.feignservice.service;

import com.gbques.ly.cloud.feignservice.model.CommonResult;
import com.gbques.ly.cloud.feignservice.model.User;
import com.gbques.ly.cloud.feignservice.service.impl.UserFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author ly
 * @since 2020-11-29 14:18
 */
//这里实现的是负载均衡，即对远端服务的调用
//表示这是对user-service服务的接口调用客户端
//fallback = UserFallbackService.class兜底类
@FeignClient(value = "user-service",fallback = UserFallbackService.class)
public interface UserService {
    //这里可以对路径进行拼接,对远程服务进行调用
    //http://user-service/user/create
    //这里的注释最好和远程服务一致，不然可能会报错，
    // 即 远程是@GetMapping，这里就是 @GetMapping
    @PostMapping("/user/create")
    CommonResult create(@RequestBody User user);

    @GetMapping("/user/{id}")
    CommonResult<User> getUser(@PathVariable Long id);

    @GetMapping("/user/getByUsername")
    CommonResult<User> getByUsername(@RequestParam String username);

    @PostMapping("/user/update")
    CommonResult update(@RequestBody User user);

    @PostMapping("/user/delete/{id}")
    CommonResult delete(@PathVariable Long id);
}
