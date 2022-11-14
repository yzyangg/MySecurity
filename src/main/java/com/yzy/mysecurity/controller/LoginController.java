package com.yzy.mysecurity.controller;

import com.yzy.mysecurity.pojo.Result;
import com.yzy.mysecurity.pojo.SysUser;
import com.yzy.mysecurity.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @projectName: MySecurity
 * @package: com.yzy.mysecurity.controller
 * @className: LoginController
 * @date: 2022/11/13 21:52
 * @author: yzy
 * @description:
 */
@RestController
@RequestMapping("user")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("login")
    public Result login(@RequestBody SysUser sysUser) {
        System.out.println("aaa");
        return loginService.login(sysUser);
    }

    @GetMapping("hello")
    public Result hello() {
        return new Result(200, "hello");
    }

    //TODO:暂时无法实现
    @GetMapping("logout")
    public Result logout() {
        return loginService.logout();
    }
}
