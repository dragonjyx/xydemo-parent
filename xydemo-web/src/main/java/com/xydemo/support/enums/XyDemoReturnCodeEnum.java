package com.xydemo.support.enums;


import com.xydemo.utils.enums.ReturnCode;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 管理员模块返回
 * @athoor: DRAGON-Yeah
 * @date: 2019/8/5 13:36
 */
@Getter
public enum XyDemoReturnCodeEnum implements ReturnCode {
    LOGIN_FAIL("101", "登录失败"),
    PASSWORD_ERROR("102", "密码错误"),
    UPLOAD_IMG_IS_EMPTY("103", "请选择上传的图片"),
    UPLOAD_IMG_ERROR("104", "上传图片失败"),
    USERID_IS_NULL("105", "请填写用户ID"),
    USERINFO_IS_NULL("106", "查找用户信息失败"),
    ;

    private String code;
    private String message;

    XyDemoReturnCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String getCode(String name) {
        for (XyDemoReturnCodeEnum resultCode : XyDemoReturnCodeEnum.values()) {
            if (resultCode.name().equals(name)) {
                return resultCode.code;
            }
        }
        return null;
    }

    public static String getMessage(String name) {
        for (XyDemoReturnCodeEnum resultCode : XyDemoReturnCodeEnum.values()) {
            if (resultCode.name().equals(name)) {
                return resultCode.message;
            }
        }
        return name;
    }


    public static Map<String,ReturnCode> initSwaggerCode(){
        Map<String,ReturnCode> codeMap = new HashMap<String,ReturnCode>();
        XyDemoReturnCodeEnum[] values = XyDemoReturnCodeEnum.values();
        for(XyDemoReturnCodeEnum code : values) {
            codeMap.put(code.name(), code);
        }
        return codeMap;
    }

}
