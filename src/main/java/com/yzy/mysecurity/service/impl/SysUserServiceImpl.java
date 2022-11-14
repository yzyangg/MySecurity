package com.yzy.mysecurity.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzy.mysecurity.pojo.Result;
import com.yzy.mysecurity.pojo.SysUser;
import com.yzy.mysecurity.service.SysUserService;
import com.yzy.mysecurity.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

/**
* @author Crims
* @description 针对表【sys_user】的数据库操作Service实现
* @createDate 2022-11-13 21:57:54
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{

}




