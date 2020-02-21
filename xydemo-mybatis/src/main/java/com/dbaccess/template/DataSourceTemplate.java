package com.dbaccess.template;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataSourceTemplate extends AbsDbTemplate {

    @Override
    public int insert(String sql, Object... args) {
        return doExecute(sql, args);
    }

    @Override
    public int delete(String sql, Object... args) {
        return doExecute(sql, args);
    }

    @Override
    public int update(String sql, Object... args) {
        return doExecute(sql, args);
    }

    @Override
    public ResultSet query(String sql, Object... args) {
        if(doExecute(sql,args) == 0){
            return null;
        }
        ResultSet resultSet = null;
        try {
            System.out.println("步骤5：处理执行结果");
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    /**
     * 执行sql
     * @param sql
     * @param args
     * @return
     */
    private int doExecute(String sql, Object[] args) {
        System.out.println("步骤3：准备sql语句以及参数");
        statement = getStatement(sql);
        setParams(args);
        try {
            System.out.println("步骤4：执行sql");
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    /**
     * 设置参数
     * @param args
     */
    private void setParams(Object[] args) {
        for (int i = 0; i < args.length; i++) {
            Object arg = args[i];
            try {
                if (arg instanceof Integer) {
                    Integer params = Integer.parseInt(arg.toString());
                    statement.setInt(i + 1, params);
                }else if(arg instanceof Long){
                    Long params = Long.parseLong(arg.toString());
                    statement.setLong(i + 1, params);
                }else if(arg instanceof Short){
                    Short params = Short.parseShort(arg.toString());
                    statement.setShort(i + 1, params);
                }else if(arg instanceof String){
                    statement.setString(i + 1, arg.toString());
                }else if(arg instanceof Date){
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    String params = simpleDateFormat.format((Date)arg);
                    statement.setString(i + 1, params);
                }else if (arg instanceof Boolean){
                    statement.setBoolean(i + 1,(Boolean) arg);
                }else if(arg instanceof BigDecimal){
                    statement.setBigDecimal(i + 1,(BigDecimal)arg);
                }else {
                    statement.setObject(i+1,arg);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
