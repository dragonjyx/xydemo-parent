package com.test.mybatis;


import com.dbaccess.mapper.RoleMapper;
import com.dbaccess.model.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * mybatis 添加 jpa
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-persistence-root.xml"})
public class JPAMyBatisTest {


    @Autowired
    private RoleMapper roleMapper;


    @Test
    public void testJPAInsert(){

        String remark = "添加新角色111";
        String roleId   = System.currentTimeMillis() + "";
        String appid  = "A1234567890L";
        String name   = "库工" + new Random().nextInt(10);
        String description = "使用sql插入对象";

        Role role = new Role();
        role.setIsDelete(false);
        role.setUpdateDate(new Date());
        role.setCreateDate(new Date());
        role.setName(name);
        role.setRemark(remark);
        role.setDescription(description);
        role.setAppId(appid);
        role.setRoleId(roleId);

//        int result = roleMapper.insert(role);

        int result = roleMapper.addNewRole(role);
        System.out.println("执行结果:"+result);

    }




    @Test
    public void testJPAAndXML(){


        System.out.println("-----------1-----------");
        Role role = roleMapper.findById(1L);
        System.out.println(role.toString());
        System.out.println("------------1----------");

        Example example = new Example(Role.class);
        example.createCriteria().andEqualTo("id",1L);
        List<Role> roleList = roleMapper.selectByExample(example);
        System.out.println("-----------2-----------");
        System.out.println(roleList.toString());
        System.out.println("-----------2-----------");

    }







}
