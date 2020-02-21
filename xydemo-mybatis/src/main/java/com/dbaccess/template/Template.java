package com.dbaccess.template;

import java.sql.ResultSet;

/**
 * 数据库执行模板
 */
public interface Template {

    void init(String host,int port,String dbName,String username,String password);

    int insert(String sql,Object... args);

    int delete(String sql,Object... args);

    int update(String sql,Object... args);

    ResultSet query(String sql,Object... args);

    void destory();
}
