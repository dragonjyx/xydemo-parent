package com.xydemo.support.aop;

import com.xydemo.utils.aop.ParamsExceptionHandler;
import com.xydemo.utils.base.BaseResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description: controller 层参数校验
 * @athoor: DRAGON-Yeah
 * @date: 2019/8/5 22:10
 */
@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler extends ParamsExceptionHandler {

    @Override
    @ExceptionHandler(Exception.class)
    public BaseResp handler(Exception e) {
        return super.handler(e);
    }

}
