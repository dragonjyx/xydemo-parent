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
    private ApplicationContext applicationContext = null;

    @Before
    public void init(){
        applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        ((ClassPathXmlApplicationContext) applicationContext).start();//启动spring
    }

    @Test
    public void testDI(){
        Machine machine = applicationContext.getBean(Machine.class);
        FruitJuice fruitJuice = machine.makeJuice("橙汁");
        fruitJuice.getFruitJuice();
    }

    @Test
    public void testDI2(){

        Machine machine1 = (Machine) applicationContext.getBean("machine1");
        FruitJuice fruitJuice1 = machine1.makeJuice("橙汁");
        fruitJuice1.getFruitJuice();

        Machine machine2 = (Machine) applicationContext.getBean("machine2");
        FruitJuice fruitJuice2 = machine2.makeJuice("西瓜汁");
        fruitJuice2.getFruitJuice();
    }


    @After
    public void destory(){
        ((ClassPathXmlApplicationContext) applicationContext).stop();//停止spring
    }

}
