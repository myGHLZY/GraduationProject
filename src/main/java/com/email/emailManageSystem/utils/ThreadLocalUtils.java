package com.email.emailManageSystem.utils;

import org.springframework.stereotype.Component;

/**
 * @author userlzy
 * @version 1.0
 * @description: TODO
 * @date 2025/3/27 21:38
 */
@Component
public class ThreadLocalUtils {

    public static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    public static Long getCurrentId() {
        return threadLocal.get();
    }

    public static void removeCurrentId() {
        threadLocal.remove();
    }
}

