package com.email.emailManageSystem.pojo.vo;

import com.email.emailManageSystem.pojo.entity.Admin;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;

/**
 * @author userlzy
 * @version 1.0
 * @description:
 * @date 2025/3/22 13:51
 */

@Data
@ToString
public class AdminLoginVo {

    Admin admin;
    String uuid;

}