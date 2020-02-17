package com.xydemo.controller;


import com.xydemo.service.AuthenService;
import com.xydemo.support.enums.XyDemoReturnCodeEnum;
import com.xydemo.support.req.LoginReq;
import com.xydemo.utils.asserts.ParameterAssert;
import com.xydemo.utils.uniqueid.UniqueIdGenerate;
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
public class PageController {

    @Autowired
    private AuthenService authenService;

    private static final String LOGIN_TOKEN = "LOGIN_TOKEN";

    @ApiOperation(value = "登录页面")
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(HttpServletRequest request,Map map) {
        String errStr = request.getParameter("err");
        if(!StringUtils.isEmpty(errStr)){
            int err = Integer.parseInt(errStr);

            switch (err){
                case 1:{
                    map.put("errTip","登录账号不能为空");
                } break;
                case 2:{
                    map.put("errTip","登录密码不能为空");
                } break;
                case 3:{
                    map.put("errTip","非法账号");
                } break;
                case 4:{
                    map.put("errTip","账号不存在");
                } break;
                case 5:{
                    map.put("errTip","密码不正确");
                } break;
                    default: break;
            }

        }
        return "login";
    }


    @ApiOperation(value = "首页")
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }


    @ApiOperation(value = "登录表单接口")
    @RequestMapping(value = "do-login", method = RequestMethod.POST)
    public String dologin(HttpServletRequest request, LoginReq loginReq) {
        if (StringUtils.isEmpty(loginReq.getAccount())) {
            //登录账号不能为空
            return "redirect:login?err=1";
        }
        if (StringUtils.isEmpty(loginReq.getPassword())) {
            //登录密码不能为空
            return "redirect:login?err=2";
        }
        int result = authenService.doLoginAuthen(loginReq);

        if (result != 0) {
            //登录密码错误
            return "redirect:login?err=" + result;
        }

        String token = UniqueIdGenerate.getId(LOGIN_TOKEN, 32);
        //把token存放在session
        request.setAttribute("token", token);

        return "redirect:index?token=" + token;
    }


}
