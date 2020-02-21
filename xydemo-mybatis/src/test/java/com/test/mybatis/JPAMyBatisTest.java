package com.test.mybatis;


import com.dbaccess.mapper.JPARoleMapper;
import com.dbaccess.model.JPARole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * mybatis 添加 jpa
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-persistence-root.xml"})
public class JPAMyBatisTest {

    @Autowired
    private JPARoleMapper jpaRoleMapper;

    @Test
    public void testJPA(){

        Example example = new Example(JPARole.class);
        example.createCriteria().andEqualTo("id",1L);

        List<JPARole> roleList = jpaRoleMapper.selectByExample(example);

        System.out.println("----------------------");
        System.out.println(roleList.toString());
        System.out.println("----------------------");
    }

}
