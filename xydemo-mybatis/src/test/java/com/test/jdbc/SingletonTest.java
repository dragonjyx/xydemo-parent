package com.test.jdbc;

import com.dbaccess.template.DataSourceUtil;
import org.junit.Test;

public class SingletonTest {

    /**
     * 单例设计模式测试
     */
    @Test
    public void testSingleton(){

        System.out.println(DataSourceUtil.getInstance());
        System.out.println(DataSourceUtil.getInstance());
        System.out.println(DataSourceUtil.getInstance().equals(DataSourceUtil.getInstance()));
    }


}
