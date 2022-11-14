package com.yzy.mysecurity.controller;

import com.yzy.mysecurity.pojo.Result;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: MySecurity
 * @package: com.yzy.mysecurity.controller
 * @className: AuthController
 * @date: 2022/11/14 19:52
 * @author: yzy
 * @description:
 */
@RestController
@RequestMapping("auth")
public class AuthController {

    @GetMapping("test")
    @PreAuthorize("hasAuthority('test01')")
    public String auth(){
        return "i have the auth!";
    }

    @GetMapping("test01")
    @PreAuthorize("hasAuthority('test')")
    public String auth2(){
        return "i have the auth!";
    }
}
