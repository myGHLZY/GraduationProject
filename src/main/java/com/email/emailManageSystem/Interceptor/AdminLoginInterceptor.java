package com.email.emailManageSystem.Interceptor;

import com.email.emailManageSystem.common.properties.LoginProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author userlzy
 * @version 1.0
 * @description: TODO
 * @date 2025/3/22 14:02
 */
@Component
public class AdminLoginInterceptor implements HandlerInterceptor {

    @Autowired
    LoginProperties loginProperties;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 从请求头中获得uuid
        String uuid = request.getHeader(loginProperties.getAdminAuth());
        // 从Redis中获得信息



        return true;
    }

//    boolean checkRedis(String uuid){
//
//    }

//    default void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
//    }
//
//    default void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//    }

}