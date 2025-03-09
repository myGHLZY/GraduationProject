package com.email.emailManageSystem.server.service.impl;

import com.email.emailManageSystem.pojo.entity.Admin;
import com.email.emailManageSystem.server.mapper.AdminMapper;
import com.email.emailManageSystem.server.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Admin login(String adminName, String adminPassword) {
        return adminMapper.getAdminByNameAndPassword(adminName, adminPassword);
    }
}