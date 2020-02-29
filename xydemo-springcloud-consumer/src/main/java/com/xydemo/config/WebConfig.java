package com.xydemo.config;


import com.xydemo.utils.base.BaseResp;
import com.xydemo.utils.config.WebMvcConfig;
import org.springframework.cloud.alibaba.sentinel.annotation.SentinelRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 其他配置
 */

@Configuration
public class WebConfig extends WebMvcConfig {


    @Bean
    @SentinelRestTemplate
    public BaseResp<String> fallbackRestTemplate(){
        return BaseResp.success();
    }


}
