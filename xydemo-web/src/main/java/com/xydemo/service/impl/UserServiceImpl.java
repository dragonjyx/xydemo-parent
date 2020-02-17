package com.xydemo.service.impl;

import com.xydemo.mapper.UserInfoMapper;
import com.xydemo.model.UserInfo;
import com.xydemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Slf4j
@Service
public class UserServiceImpl implements UserService {


    @Resource
    private UserInfoMapper userInfoMapper;


    @Override
    public UserInfo queryUserInfo(String userId) {
        log.warn("userId:{}",userId);
        UserInfo userInfo = userInfoMapper.queryByUserId(userId);
        return userInfo;
    }
}
