package com.xydemo.service.impl;

import com.xydemo.service.AuthenService;
import com.xydemo.support.req.LoginReq;
import com.xydemo.support.resp.LoginResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @description:
 * @athoor: DRAGON-Yeah
 * @date: 2019/8/5 21:45
 */
@Slf4j
@Service
public class AuthenServiceImpl implements AuthenService {


    @Override
    public LoginResp doLogin(LoginReq loginReq) {
        LoginResp loginResp = new LoginResp();
        loginResp.setToken(UUID.randomUUID().toString());
//        AppAssert.isTrue(false,AdminReturnCodeEnum.PASSWORD_ERROR);

        return loginResp;
    }
}
