package com.demo.web;


import com.demo.web.model.vo.UserInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 配置信息
 */
@Configuration
public class DemoConfig {

    @Value("${userInfo.name}")
    private String userName;


    @Bean("userInfo")
    public UserInfo userInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(25);
        userInfo.setUserName(userName);
        return userInfo;
    }


}
