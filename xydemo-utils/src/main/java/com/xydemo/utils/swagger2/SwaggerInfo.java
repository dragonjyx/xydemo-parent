package com.xydemo.utils.swagger2;

import lombok.Data;

/**
 * @description:
 * @athoor: DRAGON-Yeah
 * @date: 2019/8/5 23:00
 */
@Data
public class SwaggerInfo {

    private boolean enable=true;

    //扫描包
    private String basePackage;

    //基本信息
    private String title;
    private String description;
    private String termsOfServiceUrl;
    private String version;

    //联系人信息
    private String name;
    private String url;
    private String email;


    private String tokenName;
    private String tokenDesc;

}
