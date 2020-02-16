package com.web.support.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@ApiModel("用户信息")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoResp implements Serializable {


    private static final long serialVersionUID = -3645524249624165054L;


    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "性别")
    private Integer gender;


    @ApiModelProperty(value = "职业")
    private String job;


}
