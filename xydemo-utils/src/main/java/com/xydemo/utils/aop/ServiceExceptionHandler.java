package com.xydemo.utils.aop;

import com.xydemo.utils.base.BaseResp;
import com.xydemo.utils.enums.ReturnCodeEnum;
import com.xydemo.utils.exception.BussinessException;
import com.xydemo.utils.exception.SelfDefineException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @description: 异常捕捉
 * @athoor: DRAGON-Yeah
 * @date: 2019/8/5 13:18
 */
@Slf4j
public abstract class ServiceExceptionHandler {

    public Object doAroundAdvice(ProceedingJoinPoint pjp) {
        Object object = null;
        try {
            object = pjp.proceed();
        } catch (BussinessException e) {
            return BaseResp.error(e.getCode(),e.getMessage());
        }catch (SelfDefineException e){
            return BaseResp.error(e.getCode(),e.getMessage());
        }catch (Throwable throwable){
            return BaseResp.error(ReturnCodeEnum.SYSTEM_ERROR);
        }
        return object;
    }


}
