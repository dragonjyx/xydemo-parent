package com.test.mybatis;


import com.dbaccess.mapper.RoleMapper;
import com.dbaccess.model.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * mybatis
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-persistence-root.xml"})
public class MybatisTest {


    @Autowired
    private RoleMapper roleMapper;


    @Test
    public void testQuery(){

        Role role = roleMapper.findById(1L);
        System.out.println("----------------------");
        System.out.println(role.toString());
        System.out.println("----------------------");

    }




}
