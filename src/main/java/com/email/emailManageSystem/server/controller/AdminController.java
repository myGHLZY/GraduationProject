package com.email.emailManageSystem.server.controller;

import com.email.emailManageSystem.common.result.Result;
import com.email.emailManageSystem.pojo.entity.Admin;
import com.email.emailManageSystem.pojo.vo.AdminLoginVo;
import com.email.emailManageSystem.server.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.DocFlavor;
import java.util.UUID;

/**
 * @author userlzy
 * @version 1.0
 * @description:
 * @date 2025/3/8 22:03
 */
@RestController("/admin")
@Api(tags = "管理员模块")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/login")
    @ApiOperation("管理员登录")
    Result<AdminLoginVo> login(String adminName, String adminPassword){

        Admin admin = adminService.login(adminName, adminPassword);
        AdminLoginVo adminLoginVo = new AdminLoginVo();
        adminLoginVo.setAdmin(admin);
        adminLoginVo.setUuid(UUID.randomUUID().toString());
        return admin == null ? Result.error("用户名或密码错误") : Result.success(adminLoginVo);
    }

}