package com.demo.test.ioc;

import com.demo.model.FruitJuice;
import com.demo.model.Machine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 使用spring 注解注入
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-beans.xml"})
public class SpringIOCAnnotaitonTest {

    @Resource
    private Machine machine;

    @Test
    public void testAnnotation(){
        FruitJuice fruitJuice = machine.makeJuice("橙汁");
        fruitJuice.getFruitJuice();
    }

}
