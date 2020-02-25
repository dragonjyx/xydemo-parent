package com.example.validate.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 基础返回
 * @athoor: DRAGON-Yeah
 * @date: 2019/8/5 11:28
 */
@ApiModel(value = "返回内容")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResp<T> {

    @ApiModelProperty(value = "返回结果id")
    private String id;

    @ApiModelProperty(value = "结果代码")
    private String code = "0";

    @ApiModelProperty(value = "结果描述")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private T data;

    public BaseResp() {
        super();
    }

    public BaseResp(String id, String code, String message, T data) {
        this.id = id;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
