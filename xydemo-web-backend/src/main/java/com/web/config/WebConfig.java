package com.web.config;


import com.xydemo.utils.config.WebMvcConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 其他配置
 */
@MapperScan(basePackages = "com.web.mapper")
@ComponentScans(value = {@ComponentScan("com.web.service.impl"),
        @ComponentScan("com.web.dao")})
@Configuration
public class WebConfig extends WebMvcConfig {


}
