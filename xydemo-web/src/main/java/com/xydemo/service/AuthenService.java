package com.xydemo.service;

import com.xydemo.support.req.LoginReq;
import com.xydemo.support.vo.LoginResultVo;

public interface AuthenService {

    LoginResultVo doLoginAuthen(LoginReq loginReq);

}
