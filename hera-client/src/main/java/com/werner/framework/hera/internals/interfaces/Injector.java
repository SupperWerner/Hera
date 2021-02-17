package com.werner.framework.hera.internals.interfaces;

/**
 * @program: hera
 * @description: 对象注入器 接口
 * @author: zsy
 * @create: 2021-02-17 11:43
 **/
public interface Injector {
    // 获取实例
    <T> T getInstance(Class<T> aClass);

    <T> T getInstance(Class<T> aClass ,String  name);
}
