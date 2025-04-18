package com.email.emailManageSystem.Interceptor.Admin;

import com.email.emailManageSystem.common.properties.LoginProperties;
import com.email.emailManageSystem.pojo.entity.Admin;
import com.email.emailManageSystem.pojo.vo.AdminLoginVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @author userlzy
 * @version 1.0
 * @description: 管理员登录拦截器，注意这个拦截器只负责UUID的检查，其他的如权限检查由其他拦截器完成
 * @date 2025/3/22 14:02
 */
@Component
public class AdminLoginInterceptor implements HandlerInterceptor {

    @Autowired
    LoginProperties loginProperties;

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        System.out.println("登录拦截器");
        // 从请求头中获得uuid
        String uuid = request.getHeader(loginProperties.getAdminAuth());
        if (uuid == null)
        {
            response.setStatus(401);
            throw new RuntimeException("请登录");
        }
        // 从Redis中获得信息
        return checkRedis(uuid);
    }

    boolean checkRedis(String uuid) {
        // 检查过期时间
        Long ttl = stringRedisTemplate.getExpire(uuid, TimeUnit.SECONDS);
        if (ttl == null || ttl <= 0)
        {
            throw new RuntimeException("用户登录超时");
        }


        if (stringRedisTemplate.hasKey(uuid))
        {
            stringRedisTemplate.expire(uuid, loginProperties.getAdminExpire(), TimeUnit.MINUTES);
            return true;
        }
        return false;
    }

//    default void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
//    }
//
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {


    }

}