package com.xydemo.utils.exception;

import com.xydemo.utils.enums.ReturnCode;
import lombok.Getter;

/**
 * @description: 参数异常
 * @athoor: DRAGON-Yeah
 * @date: 2019/8/5 11:18
 */
@Getter
public class ParameterException extends RuntimeException {

    private String code;
    private String message;

    public ParameterException() {
        super();
    }

    public ParameterException(String message) {
        super(message);
    }

    public ParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParameterException(Throwable cause) {
        super(cause);
    }

    public ParameterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ParameterException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ParameterException(ReturnCode returnCode) {
        this.code = returnCode.getCode();
        this.message = returnCode.getMessage();
    }
}
