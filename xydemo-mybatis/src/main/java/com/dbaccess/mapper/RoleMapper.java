package com.dbaccess.mapper;

import com.dbaccess.model.Role;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {


    /**
     * 根据id查询
     * @param id
     * @return
     */
    Role findById(@Param("id") Long id);


}
