package com.xydemo.support.base;

import com.xydemo.support.enums.XyDemoReturnCodeEnum;
import com.xydemo.utils.base.BaseResp;
import com.xydemo.utils.enums.ReturnCode;
import com.xydemo.utils.enums.ReturnCodeEnum;

/**
 * @author oyxl 10071355
 * @version 1.0
 * @description XyDemoBaseResp
 * @date 2020/2/25 13:01
 * @blame 仓储开发组
 **/
public class XyDemoBaseResp extends BaseResp {
    public XyDemoBaseResp(String code) {
        super(code);
    }

    public XyDemoBaseResp(String code, String message) {
        super(code, message);
    }

    public XyDemoBaseResp(String code, String message, Object data) {
        super(code, message, data);
    }

    public XyDemoBaseResp(String id, String code, String message, Object data) {
        super(id, code, message, data);
    }

    public static XyDemoBaseResp error(ReturnCode returnCode) {
        for (ReturnCodeEnum codeEnum : ReturnCodeEnum.values()) {
            if (codeEnum.getCode() == returnCode.getCode()) {
                return new XyDemoBaseResp(codeEnum.getCode(), codeEnum.getMessage());
            }
        }
        for (XyDemoReturnCodeEnum codeEnum : XyDemoReturnCodeEnum.values()) {
            if (codeEnum.getCode() == returnCode.getCode()) {
                return new XyDemoBaseResp(codeEnum.getCode(), codeEnum.getMessage());
            }
        }
        return new XyDemoBaseResp(ReturnCodeEnum.UNDEFINED_ERROR.getCode(), ReturnCodeEnum.UNDEFINED_ERROR.getMessage());
    }


}
