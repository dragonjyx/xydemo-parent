package com.xydemo.utils.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * @author oyxl 10071355
 * @version 1.0
 * @description 重写 RequestMapping
 * @date 2020/2/25 12:34
 * @blame 仓储开发组
 **/
@Slf4j
public class ControllerApiRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

    //是否打印mapping
    private boolean logMappingPath = true;

    public ControllerApiRequestMappingHandlerMapping(boolean logMappingPath) {
        this.logMappingPath = logMappingPath;
    }

    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo mappingInfo = super.getMappingForMethod(method, handlerType);
        Class<?> superClass = handlerType.getSuperclass();
        appendParentRequestMapping(superClass, mappingInfo);
        return super.getMappingForMethod(method, handlerType);
    }

    /**
     * 递归拼接父级requestMapping
     *
     * @param handlerType
     * @param mappingInfo
     * @return
     */
    protected RequestMappingInfo appendParentRequestMapping(Class<?> handlerType, RequestMappingInfo mappingInfo) {
        if (handlerType == null) {
            return mappingInfo;
        }
        RequestMapping parentRequestMapping = handlerType.getAnnotation(RequestMapping.class);
        if (parentRequestMapping != null && parentRequestMapping.value().length > 0 && mappingInfo != null) {
            mappingInfo = RequestMappingInfo.paths(parentRequestMapping.value()).build().combine(mappingInfo);
        }
        return appendParentRequestMapping(handlerType.getSuperclass(), mappingInfo);
    }


    private void logMapping(RequestMappingInfo mappingInfo) {
        if (!logMappingPath || mappingInfo == null) {
            return;
        }
        log.info("mapping path:{}", mappingInfo.toString());
    }

}
