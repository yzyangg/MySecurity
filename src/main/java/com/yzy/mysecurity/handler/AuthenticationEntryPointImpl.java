package com.yzy.mysecurity.handler;

import com.alibaba.fastjson.JSON;
import com.yzy.mysecurity.pojo.Result;
import com.yzy.mysecurity.utils.WebUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @projectName: MySecurity
 * @package: com.yzy.mysecurity.handler
 * @className: AuthenticationEntryPointImpl
 * @date: 2022/11/14 20:33
 * @author: yzy
 * @description:
 */

/**
 * 认证失败处理器
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        Result result = new Result(HttpStatus.UNAUTHORIZED.value(), "认证失败");
        String json = JSON.toJSONString(result);
        WebUtil.renderString(response,json);
    }
}
