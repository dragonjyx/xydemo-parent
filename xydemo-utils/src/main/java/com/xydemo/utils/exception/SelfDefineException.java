package com.xydemo.utils.exception;

import com.xydemo.utils.enums.ReturnCode;
import lombok.Getter;

/**
 * @description: 自定义业务异常
 * @athoor: DRAGON-Yeah
 * @date: 2019/8/5 11:18
 */
@Getter
public class SelfDefineException extends RuntimeException {

    private String code;
    private String message;

    public SelfDefineException() {
        super();
    }

    public SelfDefineException(String message) {
        super(message);
    }

    public SelfDefineException(String message, Throwable cause) {
        super(message, cause);
    }

    public SelfDefineException(Throwable cause) {
        super(cause);
    }

    public SelfDefineException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public SelfDefineException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public SelfDefineException(ReturnCode returnCode) {
        this.code = returnCode.getCode();
        this.message = returnCode.getMessage();
    }
}
