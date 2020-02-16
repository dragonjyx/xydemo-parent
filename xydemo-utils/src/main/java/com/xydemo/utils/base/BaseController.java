package com.xydemo.utils.base;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * @description: BaseController
 * @athoor: DRAGON-Yeah
 * @date: 2019/8/10 17:54
 */
public class BaseController implements EnvironmentAware {

    protected String env;

    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment.getProperty("spring.profiles.active");
    }



}
