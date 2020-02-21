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

        System.out.println("----------------------");
        Role role = roleMapper.findById(1L);
        System.out.println(role.toString());
        System.out.println("----------------------");

    }

    @Test
    public void testQueryWithCache(){

        long start = System.currentTimeMillis();
        System.out.println("----------------------");
        Role role = roleMapper.findById(1L);
        System.out.println("第一次查询时间:"+ (System.currentTimeMillis() - start) + "ms");
        System.out.println(role.toString());
        System.out.println("----------------------");


        start = System.currentTimeMillis();
        role = roleMapper.findById(1L);
        System.out.println("第二次查询时间:"+ (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        role = roleMapper.findById(1L);
        System.out.println("第三次查询时间:"+ (System.currentTimeMillis() - start) + "ms");

    }




}
