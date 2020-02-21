package com.test.spring.jdbctmplate;


import com.dbaccess.model.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * spring jdbc template
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-beans.xml"})
public class SpringJDBCTemplateTest {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    public void testQuery() {
        String sql = "SELECT * FROM t_role";
        List<Role> roleList = jdbcTemplate.query(sql, new RowMapper<Role>() {
            @Override
            public Role mapRow(ResultSet resultSet, int rowNum) {
                Role roleModel = new Role();
                try {
                    roleModel.setId(resultSet.getLong("id"));
                    roleModel.setCreateDate(resultSet.getDate("create_date"));
                    roleModel.setUpdateDate(resultSet.getDate("update_date"));
                    roleModel.setIsDelete(resultSet.getBoolean("is_delete"));
                    roleModel.setRemark(resultSet.getString("remark"));
                    roleModel.setRoleId(resultSet.getString("role"));
                    roleModel.setName(resultSet.getString("name"));
                    roleModel.setAppId(resultSet.getString("appid"));
                    roleModel.setDescription(resultSet.getString("description"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return roleModel;
            }
        });
        System.out.println("----------------------");
        System.out.println(roleList.toString());
        System.out.println("----------------------");
    }


    @Test
    public void testUpdate(){
        String sql = "UPDATE t_role SET description=? WHERE id=?";
        int result = jdbcTemplate.update(sql,"测试测试",1);
        System.out.println("更新结果:" + result);
    }



}
