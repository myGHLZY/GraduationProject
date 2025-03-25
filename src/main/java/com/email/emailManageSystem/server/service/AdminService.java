package com.email.emailManageSystem.server.service;

import com.email.emailManageSystem.pojo.entity.Admin;
import com.email.emailManageSystem.pojo.vo.AdminLoginVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

/**
 * @author userlzy
 * @version 1.0
 * @description: TODO
 * @date 2025/3/9 16:58
 */

@Service
public interface AdminService {

    AdminLoginVo login(String adminName, String adminPassword) throws JsonProcessingException;

}