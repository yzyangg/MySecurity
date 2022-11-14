package com.yzy.mysecurity.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @projectName: MySecurity
 * @package: com.yzy.mysecurity.utils
 * @className: WebUtil
 * @date: 2022/11/14 20:36
 * @author: yzy
 * @description:
 */
public class WebUtil {
    public static void renderString(HttpServletResponse response,String json){
        try {
            response.setStatus(403);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().println(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
