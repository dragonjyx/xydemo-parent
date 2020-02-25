package com.xydemo;

import com.xydemo.utils.base.ApplicationStartedEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动入口
 */
@SpringBootApplication
public class XydemoWebApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(XydemoWebApplication.class);
        application.addListeners(new ApplicationStartedEventListener());
        application.run(args);
    }

}
