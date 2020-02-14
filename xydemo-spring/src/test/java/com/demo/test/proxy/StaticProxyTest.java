package com.demo.test.proxy;

import com.demo.proxy.Agent;
import com.demo.proxy.HouseAgent;
import com.demo.proxy.Owner;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class StaticProxyTest {


    /**
     * 小红
     */
    private class XiaoHong extends Owner{
        @Override
        public void findResult(String res) {
            System.out.println("小红获取到中介的结果："+res);
        }
    }


    @Test
    public void testFindHouse(){
        //小红
        XiaoHong xiaoHong = new XiaoHong();
        //中介
        Agent agent =  new HouseAgent(xiaoHong);
        //录入需求
        Map<String,String> demand = new HashMap<>();
        demand.put("大小","90平方米");
        demand.put("户型","三室一厅");
        demand.put("装修","欧式风格");
        agent.findForOwner(demand);

    }





}
