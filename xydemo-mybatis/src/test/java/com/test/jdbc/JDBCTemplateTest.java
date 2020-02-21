package com.test.jdbc;

import com.dbaccess.model.Role;
import com.dbaccess.template.DataSourceUtil;
import com.dbaccess.template.Template;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 模板设计模式
 */
public class JDBCTemplateTest {

    private final static String host = "111.229.196.111";
    private final static int    port = 3306;
    private final static String dbName   = "db_xydemo";
    private final static String username = "root";
    private final static String password = "root";

    private Template template = null;

    @Before
    public void dbInit(){
        template = DataSourceUtil.getInstance()
                .initDataSourceTemplate(host,port,dbName,username,password);
    }

    @Test
    public void execCURD() throws SQLException {
        //在同一个连接中处理多个语句
        String querySql = "SELECT * FROM t_role";
        ResultSet resultSet = template.query(querySql);

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
    public void dbRelease(){
        DataSourceUtil.getInstance().destory();
    }

}
