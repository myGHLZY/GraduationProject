package com.email.emailManageSystem.constant;

import lombok.Data;

/**
 * @author userlzy
 * @version 1.0
 * @description: 访问路径常量
 * @date 2025/3/26 21:47
 */
@Data
public class RequestUriConstant {

    //Admin  TODO 命名优化 ADMIN_UPDATE-->  以及 要把find的路径改成query
    public static final String adminUpdate = "/admin/update";
    public static final String adminFind = "/admin/find";
    public static final String adminList = "/admin/list";
    public static final String adminInsert = "/admin/insert";
    public static final String adminDeprecated = "/admin/deprecated";
    public static final String adminDelete = "/admin/delete";


}