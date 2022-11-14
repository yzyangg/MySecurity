package com.yzy.mysecurity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yzy.mysecurity.pojo.LoginUser;
import com.yzy.mysecurity.pojo.SysUser;
import com.yzy.mysecurity.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @projectName: MySecurity
 * @package: com.yzy.mysecurity.service.impl
 * @className: UserDetailsServiceImpl
 * @date: 2022/11/14 12:57
 * @author: yzy
 * @description:
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getUsername, username);
        SysUser user = sysUserService.getOne(wrapper);
        if(user==null){
            throw new RuntimeException("用户不存在");
        }
        //TODO 本来应该是去数据库查权限信息
        List<String> permissions = new ArrayList<>(Arrays.asList("test"));
        System.out.println("loadUserByUsername ing");
        return new LoginUser(user,permissions);
    }
}
