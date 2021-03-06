package com.demo.test.ioc;

import com.demo.annotation.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 使用spring 扫描注解
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-scan-annotation.xml"})
public class SpringIOCScanAnnotaitonTest {

    @Autowired
    private UserService userService;

    @Test
    public void testAnnotation(){
        userService.dologin();
    }

}
