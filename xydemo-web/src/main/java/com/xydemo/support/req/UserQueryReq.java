package com.xydemo.support.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;

@Data
@ApiModel("用户查询信息")
public class UserQueryReq {

    @ApiModelProperty(value = "邮箱")
    @Column(name="email")
    private String email;

    @ApiModelProperty(value = "手机号码")
    @Column(name="mobile")
    private String mobile;

    @ApiModelProperty(value = "登录名称")
    @Column(name="login_name")
    private String loginName;

}
