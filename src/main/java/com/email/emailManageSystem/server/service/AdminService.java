package com.email.emailManageSystem.server.service;

import com.email.emailManageSystem.pojo.dto.AdminDTO;
import com.email.emailManageSystem.pojo.dto.AdminFindDTO;
import com.email.emailManageSystem.pojo.entity.Admin;
import com.email.emailManageSystem.pojo.vo.AdminLoginVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

/**
 * @author userlzy
 * @version 1.0
 * @description: 管理员的Service接口
 * @date 2025/3/9 16:58
 */

@Service
public interface AdminService {

    AdminLoginVo login(String adminName, String adminPassword) throws JsonProcessingException;

    Boolean update(AdminDTO adminDTO);

    Admin find(AdminFindDTO adminFindDTO);
}