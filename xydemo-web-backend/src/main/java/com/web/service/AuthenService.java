package com.web.service;


import com.web.support.req.LoginReq;
import com.web.support.resp.LoginResp;

/**
 * @description:
 * @athoor: DRAGON-Yeah
 * @date: 2019/8/5 13:34
 */
public interface AuthenService {


    LoginResp doLogin(LoginReq loginReq);



}
