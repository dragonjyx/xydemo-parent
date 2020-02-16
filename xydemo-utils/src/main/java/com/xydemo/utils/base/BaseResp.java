package com.xydemo.utils.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.xydemo.utils.enums.ReturnCode;
import com.xydemo.utils.enums.ReturnCodeEnum;
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


    public static BaseResp success() {
        return new BaseResp(SystemConsts.SUCCESS_CODE);
    }

    public static BaseResp success(Object data) {
        return new BaseResp(SystemConsts.SUCCESS_CODE, null, data);
    }

    public static BaseResp success(String message) {
        return new BaseResp(SystemConsts.SUCCESS_CODE, message);
    }

    public static BaseResp success(String message, Object data) {
        return new BaseResp(SystemConsts.SUCCESS_CODE, message, data);
    }

    public static BaseResp error() {
        return new BaseResp(ReturnCodeEnum.SYSTEM_ERROR.getCode(), ReturnCodeEnum.SYSTEM_ERROR.getMessage());
    }

    public static BaseResp error(ReturnCode returnCode) {
        for (ReturnCodeEnum codeEnum : ReturnCodeEnum.values()) {
            if (codeEnum.getCode() == returnCode.getCode()) {
                return new BaseResp(codeEnum.getCode(), codeEnum.getMessage());
            }
        }
        return new BaseResp(ReturnCodeEnum.UNDEFINED_ERROR.getCode(), ReturnCodeEnum.UNDEFINED_ERROR.getMessage());
    }

    public static BaseResp error(String code, String message) {
        return new BaseResp(code, message);
    }

    public static BaseResp error(String message) {
        return new BaseResp(ReturnCodeEnum.UNDEFINED_ERROR.getCode(), message);
    }

    public BaseResp(String code) {
        this(code, null, null);
    }

    public BaseResp(String code, String message) {
        this(code, message, null);
    }

    public BaseResp(String code, String message, T data) {
        this(AppUtils.getIpAddress().replaceAll("\\.","") + "-" + AppUtils.getPid() + "-" + System.currentTimeMillis(), code, message, data);
    }

    public BaseResp(String id, String code, String message, T data) {
        this.id = id;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
