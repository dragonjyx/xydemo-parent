package com.xydemo.inteceptor;

import com.alibaba.fastjson.JSONObject;
import com.xydemo.controller.PageController;
import com.xydemo.support.enums.LoginErrorCodeEnum;
import com.xydemo.utils.base.BaseResp;
import com.xydemo.utils.jwt.AuthenUser;
import com.xydemo.utils.jwt.JwtUtil;
import com.xydemo.utils.jwt.UserInfoContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author oyxl 10071355
 * @version 1.0
 * @description TODO
 * @date 2020/2/25 11:50
 * @blame 仓储开发组
 **/
@Slf4j
public class ApiLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader(PageController.LOGIN_TOKEN);
        if(StringUtils.isEmpty(token)){
            token = request.getParameter(PageController.LOGIN_TOKEN);
        }
        if(StringUtils.isEmpty(token)){
            responseOutWithJson(response);
            UserInfoContext.remove();
            return false;
        }
        //把用户信息存放到上下文
        AuthenUser authenUser = JwtUtil.parseToken2AuthenUser(token);
        UserInfoContext.set(authenUser);

        return true;
    }

    /**
     * 以JSON格式输出
     * @param response
     */
    protected void responseOutWithJson(HttpServletResponse response) {
        BaseResp baseResp = BaseResp.error(LoginErrorCodeEnum.LOGIN_FAIL.getMessage());
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(JSONObject.toJSONString(baseResp));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }


}
