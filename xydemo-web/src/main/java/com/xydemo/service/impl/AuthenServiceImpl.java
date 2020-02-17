package com.xydemo.service.impl;

import com.xydemo.dao.RbacDao;
import com.xydemo.model.UserInfo;
import com.xydemo.service.AuthenService;
import com.xydemo.support.req.LoginReq;
import com.xydemo.utils.encrypt.MD5Util;
import com.xydemo.utils.regex.RegexVaildate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthenServiceImpl implements AuthenService {


    @Autowired
    private RbacDao rbacDao;


    @Override
    public int doLoginAuthen(LoginReq loginReq) {
        String account = loginReq.getAccount();
        String password = loginReq.getPassword();

        UserInfo userInfo = null;

        if(RegexVaildate.isEmail(account)){
            userInfo = rbacDao.findByEmail(account);
        }else if(RegexVaildate.isPhoneNumber(account)){
            userInfo = rbacDao.findByMobile(account);
        }else {
            //非法账号
            return 3;
        }

        if(userInfo == null){
            //账号不存在
            return 4;
        }

        String ukey = userInfo.getUkey();
        String md5Pwd = MD5Util.md5Encrypt32(password + ukey);

        if(!md5Pwd.equals(userInfo.getPassword())){
            //密码不正确
            return 5;
        }
        //登录成功
        return 0;
    }


}
