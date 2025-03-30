package com.email.emailManageSystem.server.mapper;

import com.email.emailManageSystem.common.result.PageResult;
import com.email.emailManageSystem.pojo.dto.AdminDTO;
import com.email.emailManageSystem.pojo.dto.AdminPageQueryDTO;
import com.email.emailManageSystem.pojo.dto.AdminQueryDTO;
import com.email.emailManageSystem.pojo.entity.Admin;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper {

    Admin getAdminByNameAndPassword(@Param("adminName") String adminName, @Param("adminPassword")String adminPassword);

    Boolean update(AdminDTO adminDTO);

    Admin find(AdminQueryDTO adminQueryDTO);

    Page<Admin> list(AdminPageQueryDTO adminPageQueryDTO);

    void insert(Admin admin);
}
