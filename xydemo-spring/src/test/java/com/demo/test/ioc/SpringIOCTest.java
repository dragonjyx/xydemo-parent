package com.demo.test.ioc;

import com.demo.model.FruitJuice;
import com.demo.model.Machine;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 使用spring
 */
public class SpringIOCTest {

    private final static String xmlPath = "classpath:spring/applicationContext-beans.xml";
    private ApplicationContext context = null;

    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext(xmlPath);
        ((ClassPathXmlApplicationContext) context).start();//启动spring
    }

    @Test
    public void testDI(){
        Machine machine = context.getBean(Machine.class);
        FruitJuice fruitJuice = machine.makeJuice("橙汁");
        fruitJuice.getFruitJuice();
    }


    @After
    public void destory(){
        ((ClassPathXmlApplicationContext) context).stop();//停止spring
    }

}
