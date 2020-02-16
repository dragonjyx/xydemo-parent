package com.xydemo.utils.exception;

import com.xydemo.utils.enums.ReturnCode;
import lombok.Getter;

/**
 * @description: 业务异常
 * @athoor: DRAGON-Yeah
 * @date: 2019/8/5 11:18
 */
@Getter
public class BussinessException extends RuntimeException {

    private String code;
    private String message;

    public BussinessException() {
        super();
    }

    public BussinessException(String message) {
        super(message);
    }

    public BussinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BussinessException(Throwable cause) {
        super(cause);
    }

    public BussinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public BussinessException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public BussinessException(ReturnCode returnCode) {
        this.code = returnCode.getCode();
        this.message = returnCode.getMessage();
    }
}
