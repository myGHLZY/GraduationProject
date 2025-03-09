package com.email.emailManageSystem.pojo.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author userlzy
 * @version 1.0
 * @description: TODO
 * @date 2025/3/9 16:28
 */
@Data
@ToString
public class User {

    private Long userId; // 主键（自增）
    private String userPassword; // 密码（6-10位，数字、字母和特殊字符结合）
    private String userEmailAddress; // 邮箱地址（不存储@后的地址）
    private String userName; // 用户名
    private String userAvatarUrl; // 用户头像地址（阿里云）
    private Boolean userAutoRespond; // 自动回复（0：关闭，1：开启）
    private Boolean userFilter; // 过滤选项（0：关闭，1：开启）
    private Boolean userFilterRespond; // 过滤通知（0：关闭，1：开启）
    private Boolean userNeedRead; // 已读通知（0：关闭，1：开启）
    private Boolean userAutoClean; // 自动清理（0：关闭，1：开启）
    private Integer userSendTotal; // 已发送邮件总数
    private Integer userReceiveTotal; // 已接收邮件总数
    private Boolean userAutoSave; // 自动保存（0：关闭，1：开启）
    private Long userCapacityMax; // 用户拥有的最大容量（默认 1GB，单位：MB）
    private Long userCapacityUsed; // 用户已使用的容量（单位：MB）

}