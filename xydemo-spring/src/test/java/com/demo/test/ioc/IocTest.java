package com.demo.test.ioc;

import com.demo.model.Fruit;
import com.demo.utils.ClassPathXmlApplicationContext;
import org.junit.Before;
import org.junit.Test;

public class IocTest {

    ClassPathXmlApplicationContext applicationContext = null;

    @Before
    public void init(){
        String beanPath = "bean.xml";
        applicationContext = new ClassPathXmlApplicationContext(beanPath);
    }

    @Test
    public void testIocGetBean() throws Exception {
        Fruit fruit = (Fruit)applicationContext.getBean("fruit");

        System.out.println(fruit.toString());
        System.out.println(fruit.getName());

    }


}
