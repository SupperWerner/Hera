package com.werner.framework.hera.spring.boot;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.Iterator;
import java.util.Map;

/**
 * @program: hera
 * @description: 赫拉客户端自动配置类
 * @author: zsy
 * @create: 2021-02-16 22:25
 **/
public class HeraApplicationContextInitializer implements ApplicationContextInitializer, EnvironmentPostProcessor, PriorityOrdered {
    Logger log = LoggerFactory.getLogger(HeraApplicationContextInitializer.class);
    public static final int DEFAULT_ORDER = 0;
    public static final String DEFAULT_CONFIG_SOURCE = "HeraPropertySources";


    /*
     * @param environment
     * @param application
     * @return void
     * @author
     * @describe: 加载完系统配置后调用
     * @date 2021/2/16 10:28 下午
     */
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        Map<String, Object> systemEnvironment = environment.getSystemEnvironment();

        MutablePropertySources propertySources = environment.getPropertySources();
        Iterator<PropertySource<?>> iterator = propertySources.iterator();
        while (iterator.hasNext()) {
            PropertySource<?> next = iterator.next();
            Gson gson = new Gson();
            String s = gson.toJson(next);
            System.out.println("配置 = " + s);
        }

        systemEnvironment.forEach((x, y) -> {
            System.out.println(String.format("配置属性 key = %s : value = %s ", x, y));
        });


    }

    /*
     * @param configurableApplicationContext
     * @return void
     * @author
     * @describe: 程序初始化自动配置调用
     * @date 2021/2/16 10:30 下午
     */
    @Override
    public void initialize(ConfigurableApplicationContext context) {
        ConfigurableEnvironment environment = context.getEnvironment();
        Map<String, Object> systemEnvironment = environment.getSystemEnvironment();

        MutablePropertySources propertySources = environment.getPropertySources();
        Iterator<PropertySource<?>> iterator = propertySources.iterator();
        while (iterator.hasNext()) {
            PropertySource<?> next = iterator.next();
            Gson gson = new Gson();
            String s = gson.toJson(next);
            System.out.println("配置 = " + s);
        }

        systemEnvironment.forEach((x, y) -> {
            System.out.println(String.format("配置属性 key = %s : value = %s ", x, y));
        });
    }

    @Override
    public int getOrder() {
        return DEFAULT_ORDER;
    }
}
