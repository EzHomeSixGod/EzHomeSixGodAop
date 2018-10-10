package com.ezhomesixgod.aop.utils;

/**
 * @author renyang
 * @description
 * @createTime 2018-09-29 11:06
 */
public class ThreadLocalUtils {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static long get(){
        if(threadLocal == null){
            throw new IllegalStateException("ThreadLocal");
        }
        return threadLocal.get();
    }

    public static void set(long startTime){
        threadLocal.set(startTime);
    }

    public static void remove(){
        threadLocal.remove();
    }
}
