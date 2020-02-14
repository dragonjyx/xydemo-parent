package com.demo.aop.service;

import com.demo.aop.XiaoMing;
import com.demo.proxy.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * HouseAgentService
 */
@Service("houseAgentService")
public class HouseAgentService implements Agent {

    @Autowired
    private XiaoMing xiaoMing;

    @Override
    public void findForOwner(Map demand) {
        if (demand == null || demand.isEmpty()) {
            System.out.println("请说说您的需求");
            return;
        }
        findHouse();
        String res = "根据您的要求" + demand.toString() + "为您找到房子";
        //回调
        this.xiaoMing.findResult(res);
    }

    private void findHouse() {
        System.out.println("------正在找房子...------");
    }

}
