package com.dbaccess.template;

import org.apache.commons.lang3.StringUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class AbsDbTemplate implements Template {

    private final static String driverClass = "com.mysql.cj.jdbc.Driver";

    protected Connection connection = null;
    protected PreparedStatement statement = null;

    @Override
    public void init(String host, int port, String dbName, String username, String password) {
        if(StringUtils.isEmpty(host)){
            System.out.println("host is null");
            System.exit(1);
        }
        if(StringUtils.isEmpty(dbName)){
            System.out.println("dbName is null");
            System.exit(1);
        }
        if(StringUtils.isEmpty(username)){
            System.out.println("username is null");
            System.exit(1);
        }
        if(StringUtils.isEmpty(username)){
            System.out.println("password is null");
            System.exit(1);
        }
        if (connection != null){
            return;
        }
        try {
            System.out.println("步骤1：加载驱动");
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("步骤2：创建数据库连接");
            String url= String.format("jdbc:mysql://%s:%d/%s?useUnicode=true&characterEncoding=UTF-8&useSSL=false",host,port,dbName);
            connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    protected PreparedStatement getStatement(String sql) {
        try {
            statement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }


    @Override
    public void destory() {
        System.out.println("步骤6：释放资源");
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
