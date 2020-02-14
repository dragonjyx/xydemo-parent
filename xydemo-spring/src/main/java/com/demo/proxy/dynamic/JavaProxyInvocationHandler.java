package com.demo.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 */
public class JavaProxyInvocationHandler implements InvocationHandler {

    /**
     * 中间类持有委托类对象的引用,这里会构成一种静态代理关系
     */
    private Object obj ;

    public JavaProxyInvocationHandler() {
        super();
    }

    public JavaProxyInvocationHandler(Object obj) {
        this.obj = obj;
    }

    public Object newProxyInstance(){
        return Proxy.newProxyInstance(
                //指定代理对象的类加载器
                obj.getClass().getClassLoader(),
                //代理对象需要实现的接口，可以同时指定多个接口
                obj.getClass().getInterfaces(),
                //方法调用的实际处理者，代理对象的方法调用都会转发到这里
            this
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("------接收到客户要求，准备找房子------");
        Object result = method.invoke(obj, args);
        System.out.println("------找房子完毕，给客户反馈------");
        return result;
    }

}
