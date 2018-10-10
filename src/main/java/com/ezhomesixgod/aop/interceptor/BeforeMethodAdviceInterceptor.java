package com.ezhomesixgod.aop.interceptor;

import com.ezhomesixgod.aop.advisor.BeforeMethodAdvice;
import com.ezhomesixgod.aop.invocation.MethodInvocation;

/**
 * @author
 * @description
 * @createTime 2018-09-27 15:35
 */
public class BeforeMethodAdviceInterceptor implements AopMethodInterceptor{

    private BeforeMethodAdvice beforeMethodAdvice;

    public BeforeMethodAdviceInterceptor(BeforeMethodAdvice advice){
        this.beforeMethodAdvice =advice;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        beforeMethodAdvice.before(methodInvocation.getMethod(),methodInvocation.getArguments(),methodInvocation);
        return methodInvocation.proceed();
    }
}
