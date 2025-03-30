package com.email.emailManageSystem.server.controller;

import com.email.emailManageSystem.common.result.PageResult;
import com.email.emailManageSystem.common.result.Result;
import com.email.emailManageSystem.pojo.dto.AdminPageQueryDTO;
import com.email.emailManageSystem.pojo.dto.AdminQueryDTO;
import com.email.emailManageSystem.pojo.entity.Admin;
import com.email.emailManageSystem.pojo.vo.AdminLoginVo;
import com.email.emailManageSystem.server.service.AdminService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
//        System.out.println("访问登录端口"); TODO 日志打印
        AdminLoginVo admin = adminService.login(adminName, adminPassword);
        return admin == null ? Result.error("用户名或密码错误") : Result.success(admin);
    }

//    @PostMapping("/update")
//    @ApiOperation("修改管理员信息")
//    Result<String> update(@RequestBody AdminDTO adminDTO){
//        // 这个地方，首先被拦截器拦截，检查两个方面 一是UUID 二是是否有权限
//
//
//
//        return Result.success("修改成功!");
//    }

    @PostMapping("/find")
    @ApiOperation("管理员查询")
    Result<Admin> find(@RequestBody AdminQueryDTO adminQueryDTO){
        Admin admin = adminService.find(adminQueryDTO);
        return admin==null?Result.error("查询不到用户"):Result.success(admin, "查询成功");
    }

    @PostMapping("/list")
    @ApiOperation("管理员的分页查询")
    Result<PageResult<Admin>> list(@RequestBody AdminPageQueryDTO adminPageQueryDTO){
        PageResult pageResult = adminService.list(adminPageQueryDTO);
        return pageResult!=null?Result.success(pageResult):Result.error("没有符合的结果");
    }

    @PostMapping("/insert")
    @ApiOperation("管理员的增加功能")
    Result insert(@RequestBody Admin admin){
        adminService.insert(admin);
        return Result.success("成功");
    }

}