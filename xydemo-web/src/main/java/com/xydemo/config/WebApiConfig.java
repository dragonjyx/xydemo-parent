package com.xydemo.config;


import com.fasterxml.classmate.TypeResolver;
import com.xydemo.support.enums.XyDemoReturnCodeEnum;
import com.xydemo.utils.swagger2.ErrorCodeResponseReader;
import com.xydemo.utils.swagger2.Swagger2Config;
import com.xydemo.utils.swagger2.SwaggerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.TypeNameExtractor;
import springfox.documentation.service.Parameter;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 其他配置
 */
@EnableSwagger2
@Configuration
public class WebApiConfig extends Swagger2Config {


    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @Autowired
    private TypeNameExtractor typeNameExtractor;

    @Bean
    public ErrorCodeResponseReader reader(){
        TypeResolver typeResolver = new TypeResolver();
        ErrorCodeResponseReader reader = new ErrorCodeResponseReader(typeNameExtractor,typeResolver);
        reader.setExtraErrorCodeMap(XyDemoReturnCodeEnum.initSwaggerCode());
        return reader;
    }

    @Bean
    public Docket anthenApi(){
        SwaggerInfo swaggerInfo = swaggerInfo();
        swaggerInfo.setBasePackage("com.xydemo.controller");
        List<Parameter> parameterList = new ArrayList<Parameter>();

        ParameterBuilder parameterBuilder = new ParameterBuilder();
        parameterBuilder.name(swaggerInfo.getTokenName()).description(swaggerInfo.getTokenDesc())
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(true).build();//header中的Token参数必填，但是这里不能解决部分接口不需要token参数
        parameterList.add(parameterBuilder.build());

        Docket docket = super.defaultApi(swaggerInfo);
//        docket.groupName(SystemConsts.NEED_AUTHEN).globalOperationParameters(parameterList).ignoredParameterTypes(HttpServletResponse.class, HttpServletRequest.class);
        docket.globalOperationParameters(parameterList).ignoredParameterTypes(HttpServletResponse.class, HttpServletRequest.class);
        return  docket;
    }



    @Bean
    public SwaggerInfo swaggerInfo(){
        boolean enableSwagger = applicationContext.getEnvironment().getProperty("swagger2-api.enable-swagger",Boolean.class);
        String title          = applicationContext.getEnvironment().getProperty("swagger2-api.title");
        String description    = applicationContext.getEnvironment().getProperty("swagger2-api.description");
        String version        = applicationContext.getEnvironment().getProperty("swagger2-api.version");
        String name  = applicationContext.getEnvironment().getProperty("swagger2-api.name");
        String url   = applicationContext.getEnvironment().getProperty("swagger2-api.url");
        String email = applicationContext.getEnvironment().getProperty("swagger2-api.email");

        SwaggerInfo swaggerInfo = new SwaggerInfo();
        swaggerInfo.setEnable(enableSwagger);
        swaggerInfo.setTitle(title);
        swaggerInfo.setDescription(description);
        swaggerInfo.setVersion(version);
        swaggerInfo.setName(name);
        swaggerInfo.setUrl(url);
        swaggerInfo.setEmail(email);

        swaggerInfo.setTokenName("token");
        swaggerInfo.setTokenDesc("需要token认证");
        return swaggerInfo;
    }

}
