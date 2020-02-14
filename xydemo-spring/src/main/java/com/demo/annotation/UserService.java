package com.demo.annotation;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void dologin(){
        System.out.println("正在登陆...");
    }

}
