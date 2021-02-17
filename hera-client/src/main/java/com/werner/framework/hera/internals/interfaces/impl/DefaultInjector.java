package com.werner.framework.hera.internals.interfaces.impl;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Singleton;
import com.werner.framework.hera.exceptions.HeraConfigException;
import com.werner.framework.hera.internals.interfaces.Injector;
import sun.java2d.CRenderer;

/**
 * @program: hera
 * @description: 对象注入默认实现
 * @author: zsy
 * @create: 2021-02-17 13:19
 **/
public class DefaultInjector implements Injector {

    private com.google.inject.Injector m_injector ;

    public DefaultInjector() {
        try {
            m_injector = Guice.createInjector(new HeraModule());
        } catch (Throwable ex) {
            HeraConfigException exception = new HeraConfigException("Unable to initialize Guice Injector!", ex);
            throw exception;
        }
    }

    @Override
    public <T> T getInstance(Class<T> aClass) {
        return m_injector.getInstance(aClass);
    }

    @Override
    public <T> T getInstance(Class<T> aClass, String name) {
        // guice 不支持通过name获取实例对象
        return null;
    }

    public static class HeraModule extends AbstractModule {

        @Override
        protected void configure() {
            bind(Injector.class).to(DefaultInjector.class).in(Singleton.class);
        }
    }

}


