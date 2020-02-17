package com.xydemo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collection;


/**
 * swagger2配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @Bean
    public Docket ProductApi(){
        Boolean enableSwagger = applicationContext.getEnvironment().getProperty("swagger2-api.enable-swagger",Boolean.class);
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .enable(enableSwagger)
                .pathMapping("/")
                .select()
                .build()
                .apiInfo(productApiInfo());
        return docket;
    }

    private ApiInfo productApiInfo(){
        String title        = applicationContext.getEnvironment().getProperty("swagger2-api.title");
        String description  = applicationContext.getEnvironment().getProperty("swagger2-api.description");
        String version      = applicationContext.getEnvironment().getProperty("swagger2-api.version");
        String name  = applicationContext.getEnvironment().getProperty("swagger2-api.name");
        String url   = applicationContext.getEnvironment().getProperty("swagger2-api.url");
        String email = applicationContext.getEnvironment().getProperty("swagger2-api.email");
        String termsOfServiceUrl = applicationContext.getEnvironment().getProperty("swagger2-api.termsOfServiceUrl");
        String license    = applicationContext.getEnvironment().getProperty("swagger2-api.license");
        String licenseUrl = applicationContext.getEnvironment().getProperty("swagger2-api.licenseUrl");

        Contact contact = new Contact(name,url,email);
        Collection<VendorExtension> vendorExtensions = Arrays.asList();
        ApiInfo apiInfo = new ApiInfo(
                title,
                description,
                version,
                termsOfServiceUrl,
                contact,
                license,
                licenseUrl,
                vendorExtensions
        );
        return apiInfo;
    }



}
