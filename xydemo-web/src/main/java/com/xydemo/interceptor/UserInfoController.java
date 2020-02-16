package com.xydemo.interceptor;


import com.xydemo.utils.base.BaseResp;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户信息控制器
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserInfoController {


    @ApiOperation(value = "获取用户信息")
    @GetMapping("info/query")
    public BaseResp getUserInfo(){

        return BaseResp.success("成功");
    }







}
