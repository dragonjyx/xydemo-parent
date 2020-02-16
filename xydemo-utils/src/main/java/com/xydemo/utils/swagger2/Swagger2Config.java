package com.xydemo.utils.swagger2;

import org.apache.commons.lang3.StringUtils;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @description:swagger2 配置
 * @athoor: DRAGON-Yeah
 * @date: 2019/8/5 22:46
 */
public abstract class Swagger2Config {

    public Docket defaultApi(SwaggerInfo swaggerInfo){
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerInfo.isEnable())
                .apiInfo(apiInfo(swaggerInfo))
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerInfo.getBasePackage()))
                .paths(PathSelectors.any())
                .build();
        return  docket;
    }

    private ApiInfo apiInfo(SwaggerInfo swaggerInfo){
        ApiInfoBuilder apiInfoBuilder =  new ApiInfoBuilder();
        apiInfoBuilder.title(swaggerInfo.getTitle());
        apiInfoBuilder.description(swaggerInfo.getDescription());
        if(!StringUtils.isEmpty(swaggerInfo.getTermsOfServiceUrl())){
            apiInfoBuilder.termsOfServiceUrl(swaggerInfo.getTermsOfServiceUrl());
        }
        apiInfoBuilder.version(swaggerInfo.getVersion()).contact(new Contact(swaggerInfo.getName(),swaggerInfo.getUrl(),swaggerInfo.getEmail()));
        return apiInfoBuilder.build();
    }


}
