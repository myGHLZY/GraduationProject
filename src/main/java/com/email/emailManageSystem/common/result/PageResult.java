package com.email.emailManageSystem.common.result;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author userlzy
 * @version 1.0
 * @description: 分页查询的返回
 * @date 2025/3/30 13:06
 */
@AllArgsConstructor
@Data
public class PageResult<T> implements Serializable{

    Long total; //总记录数
    List<T> record;

}