package com.ezhomesixgod.aop.interceptor;

import com.ezhomesixgod.aop.advisor.AfterReturningAdvice;
import com.ezhomesixgod.aop.invocation.MethodInvocation;

import java.lang.reflect.Method;

/**
 * @author renyang
 * @description
 * @createTime 2018-09-27 15:35
 */
public class AfterRunningAdviceInterceptor implements AopMethodInterceptor{

    private AfterReturningAdvice advice;

    public AfterRunningAdviceInterceptor(AfterReturningAdvice advice) {
        this.advice = advice;
    }


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object object = methodInvocation.proceed();
        advice.after(object,methodInvocation.getMethod(),methodInvocation.getArguments(),methodInvocation);
        return object;
    }
}
