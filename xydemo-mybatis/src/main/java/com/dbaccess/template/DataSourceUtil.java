package com.dbaccess.template;

/**
 * 数据源服务
 */
public class DataSourceUtil {

    private static DataSourceUtil ds;

    private DataSourceUtil(){
        super();
    }

    /**
     * 获取单例对象
     * @return
     */
    public static DataSourceUtil getInstance(){
        //使用double check实例化对象
        if(ds == null){
            synchronized (DataSourceUtil.class){
                if(ds == null){
                    ds = new DataSourceUtil();
                }
            }
        }
        return ds;
    }

    private Template dataSourceTemplate;

    /**
     * 初始化 模板
     * @param host
     * @param port
     * @param dbName
     * @param username
     * @param password
     * @return
     */
    public Template initDataSourceTemplate(String host, int port, String dbName, String username, String password) {
        if(dataSourceTemplate != null){
            return dataSourceTemplate;
        }
        dataSourceTemplate = new DataSourceTemplate();
        dataSourceTemplate.init(host,port,dbName,username,password);
        return dataSourceTemplate;
    }

    /**
     * 释放模板
     */
    public void destory(){
        if(dataSourceTemplate == null){
            return;
        }
        dataSourceTemplate.destory();
    }



}
