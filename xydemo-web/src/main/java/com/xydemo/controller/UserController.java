package com.xydemo.controller;

import com.xydemo.model.UserInfo;
import com.xydemo.service.UserService;
import com.xydemo.support.enums.XyDemoReturnCodeEnum;
import com.xydemo.support.req.UserQueryReq;
import com.xydemo.utils.asserts.AppAssert;
import com.xydemo.utils.asserts.ParameterAssert;
import com.xydemo.utils.base.ApiBaseController;
import com.xydemo.utils.base.BaseController;
import com.xydemo.utils.base.BaseResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(value = "用户模块",tags = "用户模块")
@Slf4j
@RestController
@RequestMapping("api/user")
public class UserController extends ApiBaseController {


    @Autowired
    private UserService userService;


    @ApiOperation(value = "获取用户信息")
    @ApiImplicitParam(name = "userId",value = "输入用户ID",required = true,dataType = "String")
    @GetMapping("info/{userId}")
    public BaseResp queryUserInfo(@PathVariable("userId") String userId){
        ParameterAssert.isEmpty(userId,XyDemoReturnCodeEnum.USERID_IS_NULL);
        UserInfo userInfo = userService.queryUserInfo(userId);
        AppAssert.notNull(userInfo,XyDemoReturnCodeEnum.USERINFO_IS_NULL);
        return BaseResp.success(userInfo);
    }


    @ResponseBody
    @RequestMapping(value = "query",method = RequestMethod.POST)
    public BaseResp queryTest(@RequestBody UserQueryReq userQueryReq){
        log.warn("请求参数：{}",userQueryReq.toString());
        List<UserInfo> userInfoList = userService.allUserInfo();
        return BaseResp.success(userInfoList);

    }






}
