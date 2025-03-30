package com.email.emailManageSystem.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author userlzy
 * @version 1.0
 * @description: 查询体
 * @date 2025/3/27 21:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminQueryDTO implements Serializable {

    Integer adminId; // SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '主键（自增）',
    String adminName; //VARCHAR(20) NOT NULL COMMENT '管理员名称',
    //String adminPassword; //VARCHAR(10) NOT NULL COMMENT '密码（6-10位，数字、字母和特殊字符结合）',
    //String adminAvatarUrl; //VARCHAR(255) DEFAULT NULL COMMENT '用户头像地址（阿里云）',
    Boolean adminSuperPermission; //TINYINT(1) DEFAULT 0 COMMENT '超级管理员权限（0：否，1：是）',
    Boolean adminManageUser; //TINYINT(1) DEFAULT 0 COMMENT '用户管理权限（0：否，1：是）',
    Boolean adminContent; //TINYINT(1) DEFAULT 0 COMMENT '信息发布权限（0：否，1：是）',
    Boolean adminLog; //TINYINT(1) DEFAULT 0 COMMENT '日志查看权限（0：否，1：是）',
    Boolean adminUsing;

}