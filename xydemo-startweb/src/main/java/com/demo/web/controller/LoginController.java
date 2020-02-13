package com.demo.web.controller;


import com.demo.web.model.vo.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String login(HttpServletRequest request){
        log.warn("sessionId:{}",request.getSession().getId());
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


    @RequestMapping(value = "do-login1",method = RequestMethod.POST)
    public String dologin1(HttpServletRequest request, HttpServletResponse response){
        String account = request.getParameter("account");
        String password= request.getParameter("password");
        log.warn("account:{},password:{}",account,password);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.warn("login success");
        return "redirect:index";//302
    }




    //json数据交互
    @ResponseBody
    @RequestMapping(value = "user-info/query",method = RequestMethod.POST)
    public UserInfo queryUserInfo(@RequestBody UserInfo user){
        userInfo.setUserName(user.getUserName());
        return userInfo;
    }


    @ResponseBody
    @RequestMapping(value = "user/query/{id}",method = {RequestMethod.GET,RequestMethod.POST})
    public UserInfo queryUser(@PathVariable("id") Long userId,@RequestBody UserInfo user){
        log.warn("user:{}",user.toString());
        userInfo.setId(userId);
        return userInfo;
    }









}
