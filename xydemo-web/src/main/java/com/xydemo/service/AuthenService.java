package com.xydemo.service;


import com.xydemo.support.req.LoginReq;
import com.xydemo.support.resp.LoginResp;

/**
 * @description:
 * @athoor: DRAGON-Yeah
 * @date: 2019/8/5 13:34
 */
public interface AuthenService {


    LoginResp doLogin(LoginReq loginReq);



}
