package com.xydemo.utils.uniqueid;


/**
 * id 生成
 * @author DRAGON
 */
public class UniqueIdGenerate {

    static SnowflakeIdGenerate idGenerate = new SnowflakeIdGenerate(0, 0);

    /**
     * 获取唯一ID
     * @param key
     * @param length
     * @return
     */
    public static String getSnowflakeId(String key,int length){
        long id = idGenerate.nextId();
        String iid = String.format("%0"+length+"d", id);//16位
        return iid;
    }

    /**
     * 16位
     * @param key
     * @return
     */
    public static String getId(String key){
        long id = generateId(key);
        String iid = String.format("%016d", id);//16位
        return iid;
    }

    /**
     * 自定义长度
     * @param key
     * @param length
     * @return
     */
    public static String getId(String key,int length){
        long id = generateId(key);
        String iid = String.format("%0"+length+"d", id);//16位
        return iid;
    }

    /**
     * @param key
     * @return
     */
    public static long generateId(String key){
        long id = idGenerate.nextId();
        return id;
    }

}
