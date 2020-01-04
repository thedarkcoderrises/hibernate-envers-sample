package com.tdcr.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ContextLookup implements ApplicationContextAware {
    private static ApplicationContext staticContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        setStaticContext(applicationContext);
    }

    private static void setStaticContext(ApplicationContext applicationContext) {
        staticContext =applicationContext;
    }

    public static ApplicationContext getStaticContext() {
        return staticContext;
    }
}
