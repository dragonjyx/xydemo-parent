package com.web.support.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@ApiModel("登录请求")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginReq implements Serializable {


    private static final long serialVersionUID = -6560532892165437435L;


    @ApiModelProperty(value = "登录账号",required = true)
    private String account;

    @ApiModelProperty(value = "登录密码",required = true)
    private String password;

    @ApiModelProperty(value = "登录类型",required = true)
    private String type;


}
