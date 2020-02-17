package com.xydemo.controller;

import com.xydemo.model.UserInfo;
import com.xydemo.service.UserService;
import com.xydemo.utils.base.BaseController;
import com.xydemo.utils.base.BaseResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;


@Api(value = "用户模块",tags = "用户模块")
@Slf4j
@RestController
@RequestMapping("user")
public class UserController extends BaseController {


    @Autowired
    private UserService userService;


    @ApiOperation(value = "获取用户信息")
    @ApiImplicitParam(name = "userId",value = "输入用户ID",required = true,dataType = "String")
    @GetMapping("info/{userId}")
    public BaseResp queryUserInfo(@PathVariable("userId") String userId){
        if(StringUtils.isEmpty(userId)){
            return BaseResp.error("请填写用户信息");
        }
        UserInfo userInfo = userService.queryUserInfo(userId);
        if(userInfo == null){
            return BaseResp.error("查找用户信息失败");
        }
        return BaseResp.success(userInfo);
    }





}
