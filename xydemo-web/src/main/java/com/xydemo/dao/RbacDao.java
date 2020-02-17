package com.xydemo.dao;

import com.xydemo.mapper.UserInfoMapper;
import com.xydemo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;


/**
 * RBAC dao
 */
@Repository
public class RbacDao {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo findByEmail(String email){
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("email",email);
        UserInfo userInfo = userInfoMapper.selectOneByExample(example);
        return userInfo;
    }

    public UserInfo findByMobile(String mobile){
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("mobile",mobile);
        UserInfo userInfo = userInfoMapper.selectOneByExample(example);
        return userInfo;
    }


}
