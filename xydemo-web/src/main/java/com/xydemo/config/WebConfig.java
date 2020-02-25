package com.xydemo.config;


import com.xydemo.inteceptor.ApiLoginInterceptor;
import com.xydemo.inteceptor.LoginInteceptor;
import com.xydemo.utils.base.ControllerApiRequestMappingHandlerMapping;
import com.xydemo.utils.config.WebMvcConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 其他配置
 */

@Configuration
@ComponentScan("com.xydemo.dao")
@MapperScan(basePackages = "com.xydemo.mapper")
public class WebConfig extends WebMvcConfig {

    /**
     * 继承父类requestMapping
     * @return
     */
    /*
    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        return new ControllerApiRequestMappingHandlerMapping(Boolean.TRUE);
    }*/


    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInteceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/api/**","/login","/error","/do-login","/static/**","/docs.html","/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
        registry.addInterceptor(new ApiLoginInterceptor()).addPathPatterns("/api/**");
    }
}
