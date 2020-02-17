package com.xydemo.utils.asserts;


import com.xydemo.utils.enums.ReturnCode;
import com.xydemo.utils.exception.ParameterException;
import com.xydemo.utils.exception.SelfDefineException;
import org.apache.commons.lang3.StringUtils;

/**
 * @description: 参数校验
 * @athoor: DRAGON-Yeah
 * @date: 2019/8/8 10:09
 */
public class ParameterAssert {
    public static void notNull(Object obj,String message){
        if(obj == null){
            throw new SelfDefineException(message);
        }
    }

    public static void isNull(Object obj,String message){
        if(obj != null){
            throw new SelfDefineException(message);
        }
    }

    public static void isEmpty(String str,String message){
        if(StringUtils.isEmpty(str)){
            throw new SelfDefineException(message);
        }
    }

    public static void isTrue(boolean obj,String message){
        if(!obj){
            throw new SelfDefineException(message);
        }
    }

    public static void isNotTrue(boolean obj,String message){
        if(obj){
            throw new SelfDefineException(message);
        }
    }


    public static void notNull(Object obj,ReturnCode codeEnum){
        if(obj == null){
            doThrow(codeEnum);
        }
    }


    public static void isNull(Object obj,ReturnCode codeEnum){
        if(obj != null){
            doThrow(codeEnum);
        }
    }

    public static void isEmpty(String str,ReturnCode codeEnum){
        if(StringUtils.isEmpty(str)){
            doThrow(codeEnum);
        }
    }

    public static void isTrue(boolean obj,ReturnCode codeEnum){
        if(!obj){
            doThrow(codeEnum);
        }
    }

    public static void isNotTrue(boolean obj,ReturnCode codeEnum){
        if(obj){
            doThrow(codeEnum);
        }
    }

    private static void doThrow(ReturnCode codeEnum) {
        throw new ParameterException(codeEnum.getCode(), codeEnum.getMessage());
    }


}
