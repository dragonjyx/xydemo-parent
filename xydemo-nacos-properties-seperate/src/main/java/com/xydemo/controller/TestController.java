package com.xydemo.controller;


import com.xydemo.model.People;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//动态获取nacos配置
@RefreshScope
@Slf4j
@RestController
public class TestController {


    @Value("${goods.name}")
    private String name;

    @Value("${goods.size}")
    private float size;

    @Autowired
    private People people;


    @GetMapping("test")
    public String testProperties(){
        log.warn("goods name:{},size:{}",name,size);

        return "test:" + people.toString();

    }



}
