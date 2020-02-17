package com.xydemo.config;


import com.xydemo.utils.config.WebMvcConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 其他配置
 */

@Configuration
@ComponentScan("com.xydemo.dao")
@MapperScan(basePackages = "com.xydemo.mapper")
public class WebConfig extends WebMvcConfig {


}
