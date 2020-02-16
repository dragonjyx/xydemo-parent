package com.web.support.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @description: 登录
 * @athoor: DRAGON-Yeah
 * @date: 2019/8/5 21:45
 */
@Data
@ApiModel("登录请求信息")
public class LoginReq {

    @ApiModelProperty(value = "登录账号",required = true)
    @NotEmpty(message = "登录账号不能为空")
    private String account;

    @ApiModelProperty(value = "登录密码",required = true)
    @NotEmpty(message = "登录密码不能为空")
    private String password;


}
