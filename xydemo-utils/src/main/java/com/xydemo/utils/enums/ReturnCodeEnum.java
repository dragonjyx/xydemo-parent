package com.xydemo.utils.enums;

import lombok.Getter;

/**
 * @author DRAGON
 * @description: 基础异常
 * @date 2019/08/05
 */
@Getter
public enum ReturnCodeEnum implements ReturnCode {

    SUCCESS("0","成功"),
    TOKEN_EXPIRED("000","登录凭证不正确或已过期,请重新获取"),
    ILLEGALIT_TOKEN("001","非法的请求token"),
    TOKEN_NOT_NULL("002","token不能为空"),
    NOT_SUPPORT_REQUEST("003","不支持该请求方式"),


    DATA_BIND_EXCEPTION("091", "数据绑定错误"),
    SQL_EXCEPTION("092", "数据库访问异常"),
    ILLEGAL_ARGUMENT_EXCEPTION("093", "请求参数类型错误"),
    NULL_POINT_EXCEPTION("094", "空指针异常"),
    DEFINED_ERROR("095", "自定义错误"),
    UNDEFINED_ERROR("096", "未知错误"),
    SYSTEM_ERROR("097", "系统错误"),
    BUSSINESS_ERROR("098", "业务错误"),
    PARAMS_ERROR("099", "参数错误");

    private String code;
    private String message;

    ReturnCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String getCode(String name) {
        for (ReturnCodeEnum resultCode : ReturnCodeEnum.values()) {
            if (resultCode.name().equals(name)) {
                return resultCode.code;
            }
        }
        return null;
    }

    public static String getMessage(String name) {
        for (ReturnCodeEnum resultCode : ReturnCodeEnum.values()) {
            if (resultCode.name().equals(name)) {
                return resultCode.message;
            }
        }
        return name;
    }


}
