package com.demo.test.proxy;

import com.demo.proxy.Agent;
import com.demo.proxy.Owner;
import com.demo.proxy.dynamic.JavaProxyInvocationHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class DynamicProxyAsAspectJTest {

    private JavaProxyInvocationHandler proxyInvocationHandler = null;
    private Agent agent = null;

    //声明需求切面的类
    private final static String packageStr = "com.demo.proxy.HouseDynamicAgent";

    /**
     * 小红
     */
    private class XiaoHong extends Owner{
        @Override
        public void findResult(String res) {
            System.out.println("小红获取到中介的结果："+res);
        }
    }


    @Before
    public void init() throws Exception {
        Object obj = getObjectByRefect(packageStr);
        //动态 "织入" 把切面类
        proxyInvocationHandler = new JavaProxyInvocationHandler(obj);
        agent = (Agent) proxyInvocationHandler.newProxyInstance();
    }



    @Test
    public void testDynamicProxy(){
        //录入需求
        Map<String,String> demand = new HashMap<>();
        demand.put("大小","90平方米");
        demand.put("户型","三室一厅");
        demand.put("装修","欧式风格");
        agent.findForOwner(demand);
    }


    /**
     * @return 通过反射机制获取对象
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    private Object getObjectByRefect(String packageStr) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> clazz = Class.forName(packageStr);
        Constructor constructor = clazz.getConstructor();
        Object object = constructor.newInstance();

        Method method = clazz.getMethod("setOwner",Owner.class);
        method.invoke(object,new XiaoHong());

        return object;
    }

    @After
    public void destory(){

    }

}
