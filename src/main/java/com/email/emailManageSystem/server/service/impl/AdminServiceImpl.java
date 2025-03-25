package com.email.emailManageSystem.server.service.impl;

import com.email.emailManageSystem.common.properties.LoginProperties;
import com.email.emailManageSystem.pojo.entity.Admin;
import com.email.emailManageSystem.pojo.vo.AdminLoginVo;
import com.email.emailManageSystem.server.mapper.AdminMapper;
import com.email.emailManageSystem.server.service.AdminService;

import com.email.emailManageSystem.utils.SerializeUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author userlzy
 * @version 1.0
 * @description: TODO
 * @date 2025/3/9 16:58
 */

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    LoginProperties loginProperties;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public AdminLoginVo login(String adminName, String adminPassword) throws JsonProcessingException {

        Admin admin = adminMapper.getAdminByNameAndPassword(adminName, adminPassword);
        if(admin == null)
            return null;
        AdminLoginVo adminLoginVo = new AdminLoginVo();
        adminLoginVo.setAdmin(admin);
        adminLoginVo.setUuid(UUID.randomUUID().toString());
        // 序列化
        String serialize = SerializeUtils.serialize(adminLoginVo.getAdmin());
        stringRedisTemplate.opsForValue().set(adminLoginVo.getUuid(),serialize, loginProperties.getAdminExpire(), TimeUnit.MINUTES);
        return adminLoginVo;
    }
}