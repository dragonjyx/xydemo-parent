package com.xydemo.mapper;

import com.xydemo.model.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper {


    /**
     * 根据用户ID查询用户信息
     * @param userId
     * @return
     */
    UserInfo queryByUserId(@Param("userId") String userId);


}
