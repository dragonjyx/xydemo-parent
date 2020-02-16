package com.xydemo.utils.copy;

import org.springframework.cglib.beans.BeanCopier;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>对象属性拷贝
 * <p>@author DRAGON-Yeah
 * <p>@date 2015-04-01
 * <p>@version 1.0
 */
public class BeanCopyUtils {
	public static Map<String,BeanCopier> beanCopierMap = new ConcurrentHashMap<String,BeanCopier>();
    
    public static void copyProperties(Object source, Object target){
        String beanKey 		=  generateKey(source.getClass(), target.getClass());
        BeanCopier copier 	=  null;
        if(!beanCopierMap.containsKey(beanKey)){
             copier = BeanCopier.create(source.getClass(), target.getClass(), false);
             beanCopierMap.put(beanKey, copier);
        }else{
             copier = beanCopierMap.get(beanKey);
        }
        
        copier.copy(source, target, null);
    }   
    
    private static String generateKey(Class<?> class1,Class<?>class2){
        return class1.toString() + class2.toString();
    }
}
