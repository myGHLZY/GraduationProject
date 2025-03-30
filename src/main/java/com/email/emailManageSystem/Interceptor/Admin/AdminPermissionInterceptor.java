package com.email.emailManageSystem.Interceptor.Admin;

import com.email.emailManageSystem.common.properties.LoginProperties;
import com.email.emailManageSystem.constant.RequestUriConstant;
import com.email.emailManageSystem.pojo.dto.AdminDTO;
import com.email.emailManageSystem.pojo.entity.Admin;
import com.email.emailManageSystem.utils.SerializeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author userlzy
 * @version 1.0
 * @description: 权限拦截器
 * @date 2025/3/25 23:06
 */
@Component
public class AdminPermissionInterceptor implements HandlerInterceptor {

    @Autowired
    LoginProperties loginProperties;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        String uuid = request.getHeader(loginProperties.getAdminAuth());
        Admin admin = SerializeUtils.deserialize(stringRedisTemplate.opsForValue().get(uuid),Admin.class);
        // 检查是否弃用
        if(!admin.getAdminUsing())
        {
            stringRedisTemplate.delete(uuid);
            throw new RuntimeException("账号已经弃用");
        }
        // 1 是否有访问"/admin/update"接口的权限,也就是超级管理员权限 TODO 太多的if需要优化
        if (uri.equals(RequestUriConstant.adminUpdate) && admin.getAdminSuperPermission())
            return true;
        if (uri.equals(RequestUriConstant.adminList) && admin.getAdminSuperPermission())
            return true;
        if (uri.equals(RequestUriConstant.adminFind) && admin.getAdminSuperPermission())
            return true;
        if (uri.equals(RequestUriConstant.adminInsert) && admin.getAdminSuperPermission())
            return true;
        if (uri.equals(RequestUriConstant.adminDeprecated) && admin.getAdminSuperPermission())
            return true;
        throw new RuntimeException("无权限");

    }

//    default void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//    }

}