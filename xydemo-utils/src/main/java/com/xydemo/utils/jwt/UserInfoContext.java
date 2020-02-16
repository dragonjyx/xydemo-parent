package com.xydemo.utils.jwt;

/**
 * @description: 用户上下文
 * @athoor: DRAGON-Yeah
 * @date: 2019/8/7 22:01
 */
public class UserInfoContext {

    private static ThreadLocal<AuthenUser> AccountInfoLocal = new ThreadLocal<AuthenUser>();

    public static void set(AuthenUser token){
        AccountInfoLocal.set(token);
    }

    public static AuthenUser get(){
        return AccountInfoLocal.get();
    }

    public static void remove(){
        AccountInfoLocal.remove();
    }

}
