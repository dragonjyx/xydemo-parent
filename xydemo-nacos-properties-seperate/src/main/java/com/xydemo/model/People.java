package com.xydemo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 匹配nacos中的配置
 */
@Data
@Component
@ConfigurationProperties(prefix = "people")
@Configuration
public class People {

    private String name;
    private int age;

}
