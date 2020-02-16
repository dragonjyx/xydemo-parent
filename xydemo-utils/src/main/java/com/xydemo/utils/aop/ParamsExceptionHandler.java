package com.xydemo.utils.aop;

import com.xydemo.utils.base.BaseResp;
import com.xydemo.utils.enums.ReturnCodeEnum;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import java.sql.SQLException;
import java.util.List;

/**
 * @description:参数异常
 * @athoor: DRAGON-Yeah
 * @date: 2019/8/5 22:36
 */
public abstract class ParamsExceptionHandler {

    public BaseResp handler(Exception e){
        if (e instanceof NullPointerException){
            return BaseResp.error(ReturnCodeEnum.NULL_POINT_EXCEPTION);
        }else if(e instanceof IllegalArgumentException){
            return BaseResp.error(ReturnCodeEnum.ILLEGAL_ARGUMENT_EXCEPTION);
        }else if(e instanceof BindException){
            BindException exception = (BindException)e;
            List<ObjectError> allErrors = exception.getBindingResult().getAllErrors();
            String defaultMessage = null;
            for (ObjectError error : allErrors) {
                defaultMessage = error.getDefaultMessage();
            }
            if(defaultMessage == null){
                return BaseResp.error(ReturnCodeEnum.PARAMS_ERROR);
            }
            return BaseResp.error(ReturnCodeEnum.PARAMS_ERROR.getCode(),defaultMessage);
        }else if(e instanceof SQLException){
            return BaseResp.error(ReturnCodeEnum.SQL_EXCEPTION);
        }else if(e instanceof HttpRequestMethodNotSupportedException){
            return BaseResp.error(ReturnCodeEnum.NOT_SUPPORT_REQUEST);
        } else{
            return BaseResp.error(ReturnCodeEnum.SYSTEM_ERROR);
        }
    }

}
