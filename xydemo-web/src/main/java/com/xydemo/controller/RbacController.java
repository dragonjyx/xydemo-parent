package com.xydemo.controller;

import com.xydemo.utils.base.ApiBaseController;
import com.xydemo.utils.base.BaseResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "RBAC模块",tags = "RBAC模块")
@Slf4j
@RestController
@RequestMapping("api/rbac")
public class RbacController extends ApiBaseController {


    @ApiOperation(value = "获取角色信息")
    @ApiImplicitParam(name = "id",value = "输入角色id",required = true,dataType = "Integer")
    @GetMapping("role/info/{id}")
    public BaseResp queryRole(@PathVariable("id") String id){

        return BaseResp.success(id);
    }



}
