package com.dbaccess.mapper;

import com.dbaccess.model.Role;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface RoleMapper extends Mapper<Role> {


    /**
     * 根据id查询
     * @param id
     * @return
     */
    Role findById(@Param("id") Long id);


    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteById(@Param("roleId") Long id);


    /**
     * 添加一个新角色
     * @param role
     * @return
     */
    int addNewRole(Role role);



}
