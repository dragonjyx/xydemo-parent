package com.xydemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/")
public class LoginController {

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
     * @param account
     * @param password
     * @return
     */
    @RequestMapping(value = "do-login",method = RequestMethod.POST)
    public String dologin(String account,String password){
        log.warn("account:{},password:{}",account,password);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.warn("login success");
        return "redirect:index";//302
    }






}
