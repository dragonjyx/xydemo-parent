package com.demo.test.ioc;

import com.demo.model.Fruit;
import com.demo.utils.ClassPathXmlApplicationContext;
import org.junit.Test;

public class IocTest {


    @Test
    public void testIocGetBean() throws Exception {
        String beanPath = "bean.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(beanPath);

        Fruit fruit = (Fruit)applicationContext.getBean("fruit");

        System.out.println(fruit.toString());
        System.out.println(fruit.getName());

    }


}
