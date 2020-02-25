package com.xydemo.support.enums;

import lombok.Getter;

/**
 * @author oyxl 10071355
 * @version 1.0
 * @description TODO
 * @date 2020/2/25 9:27
 * @blame 仓储开发组
 **/
@Getter
public enum LoginErrorCodeEnum {

    LOGIN_SUCCESS(0, "登录成功"),
    ACCOUNT_IS_NULL(1, "登录账号不能为空"),
    PASSWORD_IS_NULL(2, "登录密码不能为空"),
    ACCOUNT_IS_ILLEGAL(3, "非法账号"),
    ACCOUNT_NOT_EXIST(4, "账号不存在"),
    PASSWORD_IS_TRUE(5, "密码不正确"),
    LOGIN_ERROR_5_TIMES(6, "登录错误次数超过5次，半小时后再进行登录"),

    ;

    private Integer code;
    private String message;

    LoginErrorCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static LoginErrorCodeEnum getByCode(Integer code){
        for (LoginErrorCodeEnum resultCode : LoginErrorCodeEnum.values()) {
            if (resultCode.getCode().equals(code)) {
                return resultCode;
            }
        }
        return null;
    }

    public static Integer getErrorCode(String name) {
        for (LoginErrorCodeEnum resultCode : LoginErrorCodeEnum.values()) {
            if (resultCode.name().equals(name)) {
                return resultCode.code;
            }
        }
        return null;
    }

    public static String getMessage(String name) {
        for (LoginErrorCodeEnum resultCode : LoginErrorCodeEnum.values()) {
            if (resultCode.name().equals(name)) {
                return resultCode.message;
            }
        }
        return name;
    }

}
