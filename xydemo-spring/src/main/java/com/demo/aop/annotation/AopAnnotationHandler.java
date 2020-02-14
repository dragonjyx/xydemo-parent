package com.demo.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * AOP注解方式
 */
@Aspect
@Component
public class AopAnnotationHandler {


    /**
     * 定义一个方法,用于声明切点表达式,该方法一般没有方法体
     * @Pointcut用来声明切点表达式
     * 通知直接使用定义的方法名即可引入当前的切点表达式
     */
    @Pointcut("execution(* com.demo.aop.service.*.*(..))")
    public void PointcutDeclaration() {
    }

    /**
     * 前置通知
     *
     * @param joinPoint
     */
    @Before("PointcutDeclaration()")
    public void beforMethod(JoinPoint joinPoint) {
        System.out.println("------接收到客户要求，准备找房子------");
    }

    /**
     * 后置通知（无论方法是否发生异常都会执行,所以访问不到方法的返回值）
     *
     * @param joinPoint
     */
    @After("PointcutDeclaration()")
    public void afterMethod(JoinPoint joinPoint) {
        System.out.println("------找房子完毕，给客户反馈完毕------");
    }


}
