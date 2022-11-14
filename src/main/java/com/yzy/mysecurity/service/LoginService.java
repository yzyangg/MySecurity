package com.yzy.mysecurity.service;

import com.yzy.mysecurity.pojo.Result;
import com.yzy.mysecurity.pojo.SysUser;

/**
 * @projectName: MySecurity
 * @package: com.yzy.mysecurity.service
 * @className: LoginService
 * @date: 2022/11/14 14:17
 * @author: yzy
 * @description:
 */
public interface LoginService {
    Result login(SysUser sysUser);

    Result logout();
}
