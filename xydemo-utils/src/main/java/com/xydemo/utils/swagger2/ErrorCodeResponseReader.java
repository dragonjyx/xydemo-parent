package com.xydemo.utils.swagger2;

import com.fasterxml.classmate.TypeResolver;
import com.google.common.base.Optional;
import com.xydemo.utils.enums.ReturnCode;
import com.xydemo.utils.enums.ReturnCodeEnum;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springfox.documentation.schema.TypeNameExtractor;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.service.contexts.OperationContext;
import springfox.documentation.swagger.common.SwaggerPluginSupport;
import springfox.documentation.swagger.readers.operation.SwaggerResponseMessageReader;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @description: 返回码注解
 * @athoor: DRAGON-Yeah
 * @date: 2019/8/8 11:22
 */
@Component
@ConditionalOnBean(TypeNameExtractor.class)
@Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER + 3)
public class ErrorCodeResponseReader extends SwaggerResponseMessageReader {
    private static final String NEW_LINE_SYMBOL = "\r\n";

    private static final Map<String, ReturnCode> CODE_MAP = new HashMap<String, ReturnCode>();

    static {
        ReturnCodeEnum[] values = ReturnCodeEnum.values();
        for (ReturnCodeEnum code : values) {
            CODE_MAP.put(code.name(), code);
        }
    }

    public void setExtraErrorCodeMap(Map<String, ReturnCode> params) {
        if (params != null) {
            CODE_MAP.putAll(params);
        }
    }

    public ErrorCodeResponseReader(TypeNameExtractor typeNameExtractor, TypeResolver typeResolver) {
        super(typeNameExtractor, typeResolver);
    }

    @Override
    public void apply(OperationContext context) {
        Optional<ErrorCode> errorCodeAnnotation = context.findAnnotation(ErrorCode.class);
        if (errorCodeAnnotation.isPresent()) {
            Set<ResponseMessage> messageSet = read(context);
            messageSet.forEach(message -> {
                if (message.getCode() == 200) {
                    // 只在成功的responseMessage上修改
                    ErrorCode errorCode = errorCodeAnnotation.get();
                    String[] codes = errorCode.codes();

                    StringBuilder messageBuilder = new StringBuilder();
                    messageBuilder.append("\r\n本接口返回的响应码包含:\r\n");
                    messageBuilder.append(ReturnCodeEnum.SUCCESS.getCode())
                            .append(":").append(ReturnCodeEnum.SUCCESS.getMessage())
                            .append(NEW_LINE_SYMBOL)
                            .append(ReturnCodeEnum.PARAMS_ERROR.getCode())
                            .append(":").append(ReturnCodeEnum.PARAMS_ERROR.getMessage())
                            .append(NEW_LINE_SYMBOL)
                            .append(ReturnCodeEnum.SYSTEM_ERROR.getCode())
                            .append(":").append(ReturnCodeEnum.SYSTEM_ERROR.getMessage())
                            .append(NEW_LINE_SYMBOL)
                            .append(ReturnCodeEnum.TOKEN_EXPIRED.getCode())
                            .append(":").append(ReturnCodeEnum.TOKEN_EXPIRED.getMessage())
                            .append(NEW_LINE_SYMBOL);


                    for (String code : codes) {
                        ReturnCode enumImpl = CODE_MAP.get(code);
                        if (null != enumImpl) {
                            messageBuilder.append(enumImpl.getCode());
                            messageBuilder.append(":");
                            messageBuilder.append(enumImpl.getMessage());
                            messageBuilder.append("\r\n");
                        }
                    }
                    messageSet.remove(message);
                    messageSet.add(new ResponseMessage(message.getCode(), messageBuilder.toString(), message.getResponseModel(), message.getHeaders(), message.getVendorExtensions()));
                }
            });

            context.operationBuilder().responseMessages(messageSet);
        }
    }
}
