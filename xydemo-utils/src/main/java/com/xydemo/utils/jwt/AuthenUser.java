package com.xydemo.utils.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 认证用户
 * @athoor: DRAGON-Yeah
 * @date: 2019/8/6 15:42
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenUser {
    private String userId;
    private String username;
}
