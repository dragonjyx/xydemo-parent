package com.xydemo.controller;


import com.xydemo.service.AuthenService;
import com.xydemo.support.enums.LoginErrorCodeEnum;
import com.xydemo.support.req.LoginReq;
import com.xydemo.support.vo.LoginResultVo;
import com.xydemo.utils.base.BaseController;
import com.xydemo.utils.jwt.AuthenUser;
import com.xydemo.utils.jwt.JwtUtil;
import com.xydemo.utils.jwt.UserInfoContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Api(value = "页面模块，form表单提交功能", tags = "页面模块，form表单提交功能")
@Slf4j
@Controller
@RequestMapping("/")
public class PageController extends BaseController {

    @Autowired
    private AuthenService authenService;

    public static final String LOGIN_TOKEN = "LOGIN_TOKEN";
    public static final Integer SESSION_TOKEN_TIMEOUT_SECONDS = 60*60*24;

    @ApiOperation(value = "登录页面")
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, Map map) {
        String errStr = request.getParameter("err");
        if (!StringUtils.isEmpty(errStr)) {
            int err = Integer.parseInt(errStr);
            String errorMessage = LoginErrorCodeEnum.getByCode(err).getMessage();
            map.put("errTip", errorMessage);
        }
        return "login";
    }


    @ApiOperation(value = "首页")
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }


    @ApiOperation(value = "登出")
    @RequestMapping(value = "do-logout", method = RequestMethod.GET)
    public String doLogout(HttpServletRequest request) {
        request.getSession().removeAttribute(LOGIN_TOKEN);
        UserInfoContext.remove();
        return "redirect:login";
    }


    @ApiOperation(value = "登录表单接口")
    @RequestMapping(value = "do-login", method = RequestMethod.POST)
    public String dologin(HttpServletRequest request, LoginReq loginReq) {
        if (StringUtils.isEmpty(loginReq.getAccount())) {
            //登录账号不能为空
            return "redirect:login?err=" + LoginErrorCodeEnum.ACCOUNT_IS_NULL.getCode();
        }
        if (StringUtils.isEmpty(loginReq.getPassword())) {
            //登录密码不能为空
            return "redirect:login?err=" + LoginErrorCodeEnum.PASSWORD_IS_NULL.getCode();
        }

        LoginResultVo loginResultVo = null;
        try {
            loginResultVo = authenService.doLoginAuthen(loginReq);

        }catch (Exception e){
            log.error("登录错误：",e);
            return "redirect:login?err=" + LoginErrorCodeEnum.LOGIN_FAIL.getCode();
        }
        int result = loginResultVo.getResult();
        if (result != 0) {
            //登录密码错误
            return "redirect:login?err=" + result;
        }

        AuthenUser authenUser = loginResultVo.getAuthenUser();
        String token =  JwtUtil.generateToken(authenUser,SESSION_TOKEN_TIMEOUT_SECONDS);
        //把token存放在session
        request.getSession().setAttribute(LOGIN_TOKEN, token);
        //把用户信息存到上下文
        UserInfoContext.set(authenUser);

        return "redirect:index?token=" + token;
    }


}
