package com.yzy.mysecurity.service.impl;

import com.yzy.mysecurity.pojo.LoginUser;
import com.yzy.mysecurity.pojo.Result;
import com.yzy.mysecurity.pojo.SysUser;
import com.yzy.mysecurity.service.LoginService;
import com.yzy.mysecurity.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @projectName: MySecurity
 * @package: com.yzy.mysecurity.service.impl
 * @className: LoginServiceImpl
 * @date: 2022/11/14 14:17
 * @author: yzy
 * @description:
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Result login(SysUser sysUser) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(sysUser.getUsername(), sysUser.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //认证失败
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("用户名或者密码错误");
        }
        //认证成功生成token（用id生成token）
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String token = JWTUtil.createJWT(String.valueOf(loginUser.getSysUser().getId()));
        Map<String, String> map = new HashMap<>();
        map.put("token",token);
        return new Result(200,"登陆成功",map);
    }


    //TODO 没用redis 无法显示（暂时）不知道如何删除contextHolder中的认证信息
    @Override
    public Result logout() {

        return null;
    }


}
