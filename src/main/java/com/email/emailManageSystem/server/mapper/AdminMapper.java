package com.email.emailManageSystem.server.mapper;

import com.email.emailManageSystem.pojo.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper {

    Admin getAdminByNameAndPassword(@Param("adminName") String adminName, @Param("adminPassword")String adminPassword);

}
