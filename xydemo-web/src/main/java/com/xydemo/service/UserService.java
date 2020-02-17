package com.xydemo.service;

import com.xydemo.model.UserInfo;

public interface UserService {

    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    UserInfo queryUserInfo(String userId);


}
