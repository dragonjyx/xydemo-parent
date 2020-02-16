package com.web.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequestMapping("/")
public class PageController {


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






}
