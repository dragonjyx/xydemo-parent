package com.test.jdbc;

import com.dbaccess.model.Role;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.Random;

public class JDBCTest {

    private final static String driverClass = "com.mysql.cj.jdbc.Driver";
    private final static String url = "jdbc:mysql://111.229.196.111:3306/db_xydemo?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    private final static String username = "root";
    private final static String password = "root";

    private Connection connection = null;
    private PreparedStatement statement = null;

    @Before
    public void dbInit() throws ClassNotFoundException, SQLException {
        System.out.println("步骤1：加载驱动");
        //使用反射机制
        Class.forName(driverClass);

        System.out.println("步骤2：创建数据库连接");
        connection = DriverManager.getConnection(url,username,password);
    }


    @Test
    public void execCURD() throws SQLException {
        System.out.println("步骤3：准备sql语句以及参数");
        String sql = "INSERT INTO t_role(create_date,update_date,is_delete,remark,role,appid,`name`,description) " +
                "VALUES(now(),now(),0,?,?,?,?,?);";

        String remark = "添加新角色";
        String role   = System.currentTimeMillis() + "";
        String appid  = "A1234567890L";
        String name   = "ADMIN" + new Random().nextInt(10);
        String description = "管理员";

        //连接会话
        statement = connection.prepareStatement(sql);
        statement.setString(1,remark);
        statement.setString(2,role);
        statement.setString(3,appid);
        statement.setString(4,name);
        statement.setString(5,description);

        //增删改 是不会返回结果的，那么就放回false
        System.out.println("步骤4：执行sql");
        boolean result = statement.execute();

        System.out.println("步骤5：处理执行结果：" + result);

        //在同一个会话中处理多个语句
        String querySql = "SELECT * FROM t_role";
        statement = connection.prepareStatement(querySql);
        //查询才会返回结果
        ResultSet resultSet = statement.executeQuery();

        if(resultSet==null){
            return;
        }

        Role roleModel = null;
        while (resultSet.next()){
            roleModel = new Role();
            roleModel.setId(resultSet.getLong("id"));
            roleModel.setCreateDate(resultSet.getDate("create_date"));
            roleModel.setUpdateDate(resultSet.getDate("update_date"));
            roleModel.setDelete(resultSet.getBoolean("is_delete"));
            roleModel.setRemark(resultSet.getString("remark"));
            roleModel.setRoleId(resultSet.getString("role"));
            roleModel.setName(resultSet.getString("name"));
            roleModel.setAppId(resultSet.getString("appid"));
            roleModel.setDescription(resultSet.getString("description"));

            System.out.println(roleModel.toString());
        }
        
        
    }


    @After
    public void dbRelease() throws SQLException {
        System.out.println("步骤6：释放资源");
        statement.close();
        connection.close();
    }


}
