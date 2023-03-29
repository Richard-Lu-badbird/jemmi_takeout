package com.richard.jemmi.common;

/**
 * 基于ThreadLocal封装工具类，用于存储当前登录用户的id
 */
public class BaseContext {
    private static final ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }
    public static Long getCurrentId() {
        return threadLocal.get();
    }
}
