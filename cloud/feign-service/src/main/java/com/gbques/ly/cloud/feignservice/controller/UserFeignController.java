package com.gbques.ly.cloud.feignservice.controller;

import com.gbques.ly.cloud.feignservice.model.CommonResult;
import com.gbques.ly.cloud.feignservice.model.User;
import com.gbques.ly.cloud.feignservice.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author ly
 * @since 2020-11-29 14:22
 */
@RestController
@RequestMapping("/user")
public class UserFeignController {
    @Resource
    private UserService userService;

    @GetMapping("/{id}")
    public CommonResult getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/getByUsername")
    public CommonResult getByUsername(@RequestParam String username) {
        return userService.getByUsername(username);
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping("/update")
    public CommonResult update(@RequestBody User user) {
        return userService.update(user);
    }

    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}
