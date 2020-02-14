package com.demo.proxy;

import java.util.Map;

/**
 * 房子中介
 */
public class HouseAgent implements Agent {

    private Owner owner;

    public HouseAgent(Owner owner) {
        this.owner = owner;
    }

    @Override
    public void findForOwner(Map demand) {
        if (demand == null || demand.isEmpty()) {
            System.out.println("请说说您的需求");
            return;
        }

        System.out.println("------接收到客户要求，准备找房子------");

        findHouse();
        String res = "根据您的要求" + demand.toString() + "为您找到房子";
        //回调
        this.owner.findResult(res);

        System.out.println("------找房子完毕，给客户反馈------");
    }



    private void findHouse(){
        System.out.println("------正在找房子...------");
    }


}
