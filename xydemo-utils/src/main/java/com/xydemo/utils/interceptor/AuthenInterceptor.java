package com.xydemo.utils.interceptor;

import com.xydemo.utils.jwt.AuthenUser;
import com.xydemo.utils.jwt.JwtUtil;
import com.xydemo.utils.jwt.UserInfoContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @description: 授权拦截器
 * @athoor: DRAGON-Yeah
 * @date: 2019/8/10 21:44
 */
@Slf4j
public class AuthenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //获取token
        String token = request.getHeader("Authorization");
        if (!StringUtils.isEmpty(token)) {
            AuthenUser authenUser = JwtUtil.parseToken2AuthenUser(token);
            UserInfoContext.set(authenUser);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        AuthenUser authenUser = new AuthenUser();
        UserInfoContext.set(authenUser);
    }
}
