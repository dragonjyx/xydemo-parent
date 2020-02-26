package com.xydemo;

import com.xydemo.utils.base.Log4j2ApplicationStartedEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动入口
 */
@SpringBootApplication
public class XydemoWebApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(XydemoWebApplication.class);
        application.addListeners(new Log4j2ApplicationStartedEventListener("applicationConfig: [classpath:/application.yaml]"));
        application.run(args);
    }

}
