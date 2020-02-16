package com.xydemo.support.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description:
 * @athoor: DRAGON-Yeah
 * @date: 2019/8/5 22:46
 */
@ApiModel("登录成功结果")
@Data
public class LoginResp {

    @ApiModelProperty(value = "登录令牌")
    private String token;

}
