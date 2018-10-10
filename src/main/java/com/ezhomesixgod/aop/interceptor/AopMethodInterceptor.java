package com.ezhomesixgod.aop.interceptor;

import com.ezhomesixgod.aop.invocation.MethodInvocation;

/**
 * @author renyang
 * @description
 * @createTime 2018-09-27 15:33
 */
public interface AopMethodInterceptor {
    Object invoke(MethodInvocation methodInvocation) throws Throwable;
}
