package com.xydemo.utils.base;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

/**
 * 修改启动监听
 *
 * @author DRAGON-Yeah
 * @date 2019-05-06
 */
public class ApplicationStartedEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent>, Ordered {

    public static final int DEFAULT_ORDER = Ordered.HIGHEST_PRECEDENCE + 10;

    private static Class<?>[] EVENT_TYPES = {
            ApplicationStartingEvent.class,
            ApplicationEnvironmentPreparedEvent.class,
            ApplicationPreparedEvent.class,
            ContextClosedEvent.class,
            ApplicationFailedEvent.class
    };

    private static Class<?>[] SOURCE_TYPES = {
            SpringApplication.class,
            ApplicationContext.class
    };


    private boolean isAssignableFrom(Class<?> type, Class<?>... supportedTypes) {
        if (type != null) {
            for (Class<?> supportedType : supportedTypes) {
                if (supportedType.isAssignableFrom(type)) {
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        ConfigurableEnvironment configurableEnvironment = event.getEnvironment();
        MutablePropertySources mutablePropertySources = configurableEnvironment.getPropertySources();
        PropertySource<?> propertySource = mutablePropertySources.get("applicationConfig: [classpath:/application.yaml]");
        if (propertySource != null) {
            String logPath = (String) propertySource.getProperty("logging.path");
            if (!StringUtils.isEmpty(logPath)) {
                MDC.put("logPath", logPath);
            }
            String appName = (String) propertySource.getProperty("spring.application.name");
            if (!StringUtils.isEmpty(appName)) {
                MDC.put("appName", appName);
            }
            String profiles = (String) propertySource.getProperty("spring.profiles.active");
            if (!StringUtils.isEmpty(profiles)) {
                MDC.put("profiles", profiles);
            }
        }
    }

    @Override
    public int getOrder() {
        return DEFAULT_ORDER;
    }
}
