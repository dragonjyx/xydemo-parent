package com.demo.proxy;

import java.util.Map;

/**
 * 房子中介
 */
public class HouseDynamicAgent implements Agent {

    private Owner owner;

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public HouseDynamicAgent() {
        super();
    }

    public HouseDynamicAgent(Owner owner) {
        this.owner = owner;
    }

    @Override
    public void findForOwner(Map demand) {
        if (demand == null || demand.isEmpty()) {
            System.out.println("请说说您的需求");
            return;
        }
        findHouse();
        String res = "根据您的要求" + demand.toString() + "为您找到房子";
        //回调
        this.owner.findResult(res);
    }

    private void findHouse(){
        System.out.println("------正在找房子...------");
    }


}
