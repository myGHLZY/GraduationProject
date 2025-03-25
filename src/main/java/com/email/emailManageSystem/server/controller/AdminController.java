package com.email.emailManageSystem.server.controller;

import com.email.emailManageSystem.common.result.Result;
import com.email.emailManageSystem.pojo.entity.Admin;
import com.email.emailManageSystem.pojo.vo.AdminLoginVo;
import com.email.emailManageSystem.server.service.AdminService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.val;
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
@RestController
@RequestMapping("/admin")
@Api(tags = "管理员模块")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/login")
    @ApiOperation("管理员登录")
    Result<AdminLoginVo> login(String adminName, String adminPassword) throws JsonProcessingException {
        System.out.println("访问登录端口");
        AdminLoginVo admin = adminService.login(adminName, adminPassword);
        return admin == null ? Result.error("用户名或密码错误") : Result.success(admin);
    }

    @GetMapping("/aaa")
    @ApiOperation("管理员登录")
    Result<AdminLoginVo> test(String adminName, String adminPassword) throws JsonProcessingException {
        System.out.println("访问登录端口");
        AdminLoginVo admin = adminService.login(adminName, adminPassword);
        return admin == null ? Result.error("用户名或密码错误") : Result.success(admin);
    }

}