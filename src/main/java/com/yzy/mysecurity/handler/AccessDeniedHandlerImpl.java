package com.yzy.mysecurity.handler;

import com.alibaba.fastjson.JSON;
import com.yzy.mysecurity.pojo.Result;
import com.yzy.mysecurity.utils.WebUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @projectName: MySecurity
 * @package: com.yzy.mysecurity.handler
 * @className: AccessDeniedHandlerImpl
 * @date: 2022/11/14 20:44
 * @author: yzy
 * @description:
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        Result result = new Result(HttpStatus.FORBIDDEN.value(), "权限不足");
        String json = JSON.toJSONString(result);
        WebUtil.renderString(response,json);
    }
}
