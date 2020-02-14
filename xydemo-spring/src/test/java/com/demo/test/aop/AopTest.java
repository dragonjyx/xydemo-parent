package com.demo.test.aop;


import com.demo.aop.service.HouseAgentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用spring 注解注入
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-aop-scan-annotation.xml"})
public class AopTest {

    @Autowired
    private HouseAgentService houseAgentService;

    @Test
    public void testAOP(){
        //录入需求
        Map<String,String> demand = new HashMap<>();
        demand.put("大小","90平方米");
        demand.put("户型","三室一厅");
        demand.put("装修","欧式风格");

        houseAgentService.findForOwner(demand);
    }

}
