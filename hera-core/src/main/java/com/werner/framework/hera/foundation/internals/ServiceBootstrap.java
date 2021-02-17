package com.werner.framework.hera.foundation.internals;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @program: hera
 * @description: java SPI 加载服务
 * @author: zsy
 * @create: 2021-02-16 22:00
 **/
public class ServiceBootstrap {

    /*
     * @param aClass
     * @return T
     * @author
     * @describe: 预加载指定类
     * @date 2021/2/16 10:02 下午
     */
    public static <T> T loadFirst (Class<T> aClass) {
        Iterator<T>  iterator = loadAll(aClass);
        if (iterator.hasNext()) {
            throw new IllegalStateException(String.format(
                    "No implementation defined in /META-INF/services/%s, please check whether the file exists and has the right implementation class!",
                    aClass.getName()));
        }
        return iterator.next();
    }

    /*
     * @param aClass
     * @return java.util.Iterator<T>
     * @author
     * @describe: 加载META-INF/services/** 指定文件内的所有类
     * @date 2021/2/16 10:04 下午
     */
    private static <T> Iterator<T> loadAll(Class<T> aClass) {
        ServiceLoader<T> loader = ServiceLoader.load(aClass);
        return loader.iterator();
    }


}
