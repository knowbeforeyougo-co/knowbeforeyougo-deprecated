package com.yakovliam.knowbeforeyougo.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Wrapper to always return a reference to the Spring Application
 Context from
 * within non-Spring enabled beans. Unlike Spring MVC's
 WebApplicationContextUtils
 * we do not need a reference to the Servlet context for this. All we need is
 * for this bean to be initialized during application startup.
 */
@Component
public class SpringApplicationContext {

    private static ApplicationContext ctx;

    public static void setApplicationContext(ApplicationContext appContext) {
        ctx = appContext;
    }

    public static ApplicationContext getApplicationContext() {
        return ctx;
    }
}