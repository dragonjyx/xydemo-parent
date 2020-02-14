package com.demo.test.proxy;

import com.demo.proxy.Agent;
import com.demo.proxy.HouseDynamicAgent;
import com.demo.proxy.Owner;
import com.demo.proxy.dynamic.JavaProxyInvocationHandler;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class DynamicProxyTest {


    @Test
    public void testNoDynamicProxy(){
        Agent agent = new HouseDynamicAgent(new Owner() {
            @Override
            protected void findResult(String res) {
                System.out.println("小红获取到中介的结果："+res);
            }
        });

        //录入需求
        Map<String,String> demand = new HashMap<>();
        demand.put("大小","90平方米");
        demand.put("户型","三室一厅");
        demand.put("装修","欧式风格");
        agent.findForOwner(demand);
    }



    @Test
    public void testDynamicProxy(){
        JavaProxyInvocationHandler proxyInvocationHandler = new JavaProxyInvocationHandler(new HouseDynamicAgent(new Owner(){
            @Override
            protected void findResult(String res) {
                System.out.println("小红获取到中介的结果："+res);
            }
        }));

        Agent agent = (Agent) proxyInvocationHandler.newProxyInstance();
        //录入需求
        Map<String,String> demand = new HashMap<>();
        demand.put("大小","90平方米");
        demand.put("户型","三室一厅");
        demand.put("装修","欧式风格");
        agent.findForOwner(demand);
    }





}
