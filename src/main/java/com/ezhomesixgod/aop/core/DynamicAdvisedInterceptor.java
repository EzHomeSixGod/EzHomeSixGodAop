package com.ezhomesixgod.aop.core;

import com.ezhomesixgod.aop.advisor.TargetSource;
import com.ezhomesixgod.aop.interceptor.AopMethodInterceptor;
import com.ezhomesixgod.aop.invocation.CglibMethodInvocation;
import com.ezhomesixgod.aop.invocation.MethodInvocation;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author
 * @description
 * @createTime 2018-09-28 10:43
 */
public class DynamicAdvisedInterceptor implements MethodInterceptor {

    protected final List<AopMethodInterceptor> interceptorList;
    protected final TargetSource targetSource;

    public DynamicAdvisedInterceptor(List<AopMethodInterceptor> interceptorList, TargetSource targetSource) {
        this.interceptorList = interceptorList;
        this.targetSource = targetSource;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        MethodInvocation invocation = new CglibMethodInvocation(obj,targetSource.getTagetObject(),method, args,interceptorList,proxy);
        return invocation.proceed();
    }

}
