package com.xydemo.utils.swagger2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: 错误码
 * @athoor: DRAGON-Yeah
 * @date: 2019/8/8 11:21
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ErrorCode {

    /**
     * 错误码列表
     */
    String[] codes() default "";
}
