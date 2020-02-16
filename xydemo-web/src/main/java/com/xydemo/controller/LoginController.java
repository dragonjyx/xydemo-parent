package com.xydemo.controller;

import com.xydemo.service.AuthenService;
import com.xydemo.support.req.LoginReq;
import com.xydemo.support.resp.LoginResp;
import com.xydemo.utils.swagger2.ErrorCode;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequestMapping("/")
public class LoginController {


    @Autowired
    private AuthenService authenService;

    /**
     * 渲染出一个login页面
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(HttpServletRequest request){
        return "login";
    }


    /**
     * 渲染index页面
     * @return
     */
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }



    /**
     * 登录
     * @param loginReq
     * @return
     */
    @ErrorCode
    @ApiOperation(value = "用户登录")
    @ApiResponses({@ApiResponse(code = 0 ,message = "返回登录令牌")})
    @PostMapping("dologin")
    public String dologin(@Validated LoginReq loginReq){
        String account  = loginReq.getAccount();
        String password = loginReq.getPassword();
        log.warn("account:{},password:{}",account,password);

        LoginResp loginResp = authenService.doLogin(loginReq);

        log.warn("login success");
        return "redirect:index";
    }






}
