package com.yzy.mysecurity.filter;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yzy.mysecurity.pojo.LoginUser;
import com.yzy.mysecurity.pojo.SysUser;
import com.yzy.mysecurity.service.SysUserService;
import com.yzy.mysecurity.utils.JWTUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @projectName: MySecurity
 * @package: com.yzy.mysecurity.filter
 * @className: JwtTokenFilter
 * @date: 2022/11/14 15:41
 * @author: yzy
 * @description:
 */
@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 登陆后才做校验
     *
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取请求头中的token
        String token = request.getHeader("token");

        if (token == null) {
            filterChain.doFilter(request, response);
            return;
        }
        //解析token
        String userId;
        try {
            Claims claims = JWTUtil.parseJWT(token);
            userId = claims.getSubject();
        } catch (Exception e) {
            throw new RuntimeException("token非法");
        }
        //获取loginUser ??
        //LoginUser loginUser = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getId,userId);
        List<String> permissions = new ArrayList<>(Arrays.asList("test"));
        LoginUser loginUser = new LoginUser(sysUserService.getOne(wrapper), permissions);

        //TODO 装载权限信息
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
        //contextHolder 中存入对象供后续的过滤器使用
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //放行
        filterChain.doFilter(request, response);

    }
}

