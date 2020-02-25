package com.xydemo.support.vo;

import com.xydemo.utils.jwt.AuthenUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author oyxl 10071355
 * @version 1.0
 * @description TODO
 * @date 2020/2/25 11:42
 * @blame 仓储开发组
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResultVo {
    private AuthenUser authenUser;
    private int result;
}
