package com.demo.web.controller;


import com.demo.web.model.vo.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;


/**
 * 登录控制器
 */
@Slf4j
@Controller
@RequestMapping("/")
public class LoginController {


    @Autowired
    private UserInfo userInfo;

    /**
     * 渲染出一个login页面
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }


    /**
     * 渲染index页面
     * @return
     */
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(Map map){
        map.put("user",userInfo);
        return "index";
    }


    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    @RequestMapping(value = "dologin",method = RequestMethod.POST)
    public String dologin(String account,String password){
        log.warn("account:{},password:{}",account,password);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.warn("login success");
        return "redirect:index";
    }





}
