package com.xydemo.support.aop;

import com.xydemo.utils.aop.ServiceExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @description: controller异常捕捉
 * @athoor: DRAGON-Yeah
 * @date: 2019/8/5 14:34
 */
@Slf4j
@Aspect
@Component
public class AdminServiceExceptionHandler extends ServiceExceptionHandler {

    @Pointcut("execution(public * com.xydemo.controller.*.*(..))")
    public void handlerExpection(){}


    @Around("handlerExpection()")
    @Override
    public Object doAroundAdvice(ProceedingJoinPoint pjp) {
        return super.doAroundAdvice(pjp);
    }
}
