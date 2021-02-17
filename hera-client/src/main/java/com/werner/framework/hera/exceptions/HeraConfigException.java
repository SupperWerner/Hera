package com.werner.framework.hera.exceptions;

/**
 * @program: hera
 * @description: 赫拉自定义异常
 * @author: zsy
 * @create: 2021-02-17 13:36
 **/
public class HeraConfigException extends RuntimeException {
    public HeraConfigException(String msg) {
        super(msg);
    }

    public HeraConfigException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
