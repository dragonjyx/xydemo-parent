package com.demo.aop;

import com.demo.proxy.Owner;

public class XiaoMing extends Owner {

    @Override
    public void findResult(String res) {
        System.out.println("小明获取到中介的结果："+res);
    }

}
