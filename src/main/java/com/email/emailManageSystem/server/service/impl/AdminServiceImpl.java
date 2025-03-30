package com.email.emailManageSystem.server.service.impl;

import com.email.emailManageSystem.common.properties.LoginProperties;
import com.email.emailManageSystem.common.result.PageResult;
import com.email.emailManageSystem.pojo.dto.AdminDTO;
import com.email.emailManageSystem.pojo.dto.AdminPageQueryDTO;
import com.email.emailManageSystem.pojo.dto.AdminQueryDTO;
import com.email.emailManageSystem.pojo.entity.Admin;
import com.email.emailManageSystem.pojo.vo.AdminLoginVo;
import com.email.emailManageSystem.server.mapper.AdminMapper;
import com.email.emailManageSystem.server.service.AdminService;

import com.email.emailManageSystem.utils.SerializeUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author userlzy
 * @version 1.0
 * @description: 管理员的Service类
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
        // TODO 暂时的处理
        admin.setAdminPassword("******");
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

    @Override
    public Boolean update(AdminDTO adminDTO) {

        Boolean bool = adminMapper.update(adminDTO);

        return null;
    }

    @Override
    public Admin find(AdminQueryDTO adminQueryDTO) {
        Admin admin = adminMapper.find(adminQueryDTO);
        return admin;
    }

    @Override
    public PageResult list(AdminPageQueryDTO adminPageQueryDTO) {
        // 利用page-helper插件
        // 开始分页查询
        PageHelper.startPage(adminPageQueryDTO.getPageNum(), adminPageQueryDTO.getPageSize());
        //
        Page<Admin> page = adminMapper.list(adminPageQueryDTO);
        long total = page.getTotal();
        List<Admin> result = page.getResult();
        return new PageResult(total, result);
    }

    @Override
    public void insert(Admin admin) {
        adminMapper.insert(admin);
    }

    @Override
    public void deprecated(Long adminId) {
        adminMapper.deprecated(adminId);
    }
}