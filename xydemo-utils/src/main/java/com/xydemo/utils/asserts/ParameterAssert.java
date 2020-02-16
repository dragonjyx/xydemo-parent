package com.xydemo.utils.asserts;


import com.xydemo.utils.enums.ReturnCode;
import com.xydemo.utils.exception.ParameterException;

/**
 * @description: 参数校验
 * @athoor: DRAGON-Yeah
 * @date: 2019/8/8 10:09
 */
public class ParameterAssert {
    /**
     * 不能为空
     */
    public static void notNull(Object obj,ReturnCode respCodeEnum) {
        if(obj == null) {
            throw new ParameterException(respCodeEnum);
        }
    }

    /**
     * 不能为空
     */
    public static void notNull(Object obj,String message) {
        if(obj == null) {
            throw new ParameterException(message);
        }
    }

    /**
     * 只能为空
     */
    public static void isNull(Object obj,ReturnCode respCodeEnum) {
        if(obj != null) {
            throw new ParameterException(respCodeEnum);
        }
    }

    /**
     * 只能为空
     */
    public static void isNull(Object obj,String message) {
        if(obj != null) {
            throw new ParameterException(message);
        }
    }

    /**
     * 表达式必须为true
     */
    public static void isTrue(boolean expression,ReturnCode respCodeEnum) {
        if(!expression) {
            throw new ParameterException(respCodeEnum);
        }
    }

    /**
     * 表达式必须为true
     */
    public static void isTrue(boolean expression,String message) {
        if(!expression) {
            throw new ParameterException(message);
        }
    }

    /**
     * 表达式必须为true
     */
    public static void isTrue(boolean expression,String code,String message) {
        if(!expression) {
            throw new ParameterException(code,message);
        }
    }
}
