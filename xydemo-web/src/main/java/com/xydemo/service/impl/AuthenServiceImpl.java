package com.xydemo.service.impl;

import cn.hutool.core.date.DateUtil;
import com.xydemo.dao.RbacDao;
import com.xydemo.model.UserInfo;
import com.xydemo.service.AuthenService;
import com.xydemo.support.enums.LoginErrorCodeEnum;
import com.xydemo.support.req.LoginReq;
import com.xydemo.support.vo.LoginResultVo;
import com.xydemo.utils.encrypt.MD5Util;
import com.xydemo.utils.jwt.AuthenUser;
import com.xydemo.utils.regex.RegexVaildate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class AuthenServiceImpl implements AuthenService {

    @Autowired
    private RbacDao rbacDao;
    //半小时
    private static long HALF_HOUR = 60 * 30;

    @Override
    public LoginResultVo doLoginAuthen(LoginReq loginReq) {
        LoginResultVo loginResultVo = new LoginResultVo();

        String account = loginReq.getAccount();
        String password = loginReq.getPassword();

        UserInfo userInfo = null;

        if(RegexVaildate.isEmail(account)){
            userInfo = rbacDao.findByEmail(account);
        }else if(RegexVaildate.isPhoneNumber(account)){
            userInfo = rbacDao.findByMobile(account);
        }else {
            //非法账号
            loginResultVo.setResult(LoginErrorCodeEnum.ACCOUNT_IS_ILLEGAL.getCode());
            return loginResultVo;
        }

        if(userInfo == null){
            //账号不存在
            loginResultVo.setResult(LoginErrorCodeEnum.ACCOUNT_NOT_EXIST.getCode());
            return loginResultVo;
        }

        //判断是否已经上锁
        Boolean locked = userInfo.getLocked();
        if(locked != null && Boolean.TRUE.equals(locked)){
            loginResultVo.setResult(LoginErrorCodeEnum.USER_IS_LOCKED.getCode());
            return loginResultVo;
        }

        AuthenUser authenUser = new AuthenUser();
        authenUser.setUserId(userInfo.getUserId());
        authenUser.setUsername(userInfo.getLoginName());

        //准备密码
        String ukey = userInfo.getUkey();
        String md5Pwd = MD5Util.md5Encrypt32(password + ukey);

        //登录时间
        Date loginDate = userInfo.getLoginDate();
        loginDate = loginDate == null?DateUtil.date():loginDate;

        //登录成功次数
        Integer loginTimes = userInfo.getLoginTimes();
        loginTimes = loginTimes == null?0:loginTimes;

        //判断是否已经登录5次密码错误
        Integer loginErrorTimes = userInfo.getLoginErrorTimes();
        loginErrorTimes = loginErrorTimes == null?0:loginErrorTimes;
        if(loginErrorTimes >= 5 ){
            //判断是否已经超过半小时
            long offectTime = (System.currentTimeMillis() - loginDate.getTime())/1000;
            if(offectTime >= HALF_HOUR){
                //登录错误次数重新算
                userInfo.setLoginErrorTimes(0);
                userInfo.setLoginIp(loginReq.getLoginIp());
                userInfo.setLoginDate(DateUtil.date());

                //登录成功
                if(md5Pwd.equals(userInfo.getPassword())){
                    loginTimes ++ ;
                    userInfo.setLoginTimes(loginTimes);
                    rbacDao.updateUserInfo(userInfo);

                    //登录成功
                    loginResultVo.setResult(LoginErrorCodeEnum.LOGIN_SUCCESS.getCode());
                    loginResultVo.setAuthenUser(authenUser);
                    return loginResultVo;
                }

                //密码不正确 登录失败
                userInfo.setLoginErrorTimes(1);
                rbacDao.updateUserInfo(userInfo);
                loginResultVo.setResult(LoginErrorCodeEnum.PASSWORD_IS_TRUE.getCode());
                return loginResultVo;
            }

            loginResultVo.setResult(LoginErrorCodeEnum.LOGIN_ERROR_5_TIMES.getCode());
            return loginResultVo;
        }

        //正常登录错误
        if(!md5Pwd.equals(userInfo.getPassword())){
            //记录密码錯誤次數
            loginErrorTimes ++;
            userInfo.setLoginErrorTimes(loginErrorTimes);
            userInfo.setLoginIp(loginReq.getLoginIp());
            userInfo.setLoginDate(DateUtil.date());
            //更新登录错误信息
            rbacDao.updateUserInfo(userInfo);

            //错误5次
            if(loginErrorTimes == 5){
                loginResultVo.setResult(LoginErrorCodeEnum.LOGIN_ERROR_5_TIMES.getCode());
            }else{
                //密码不正确
                loginResultVo.setResult(LoginErrorCodeEnum.PASSWORD_IS_TRUE.getCode());
            }
            return loginResultVo;
        }

        //登录成功，记录登录信息
        userInfo.setLoginErrorTimes(0);
        userInfo.setLoginIp(loginReq.getLoginIp());
        userInfo.setLoginDate(DateUtil.date());
        loginTimes ++ ;
        userInfo.setLoginTimes(loginTimes);
        rbacDao.updateUserInfo(userInfo);

        loginResultVo.setResult(LoginErrorCodeEnum.LOGIN_SUCCESS.getCode());
        loginResultVo.setAuthenUser(authenUser);
        return loginResultVo;
    }


}
