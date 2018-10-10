package com.ezhomesixgod.aop.invocation;

import com.ezhomesixgod.aop.interceptor.AopMethodInterceptor;
import com.ezhomesixgod.aop.utils.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author renyang
 * @description
 * @createTime 2018-09-27 17:01
 */
public class ReflectioveMethodeInvocation implements ProxyMethodInvocation {

    protected final Object proxy;

    protected final Object target;

    protected final Method method;

    protected  Object[] arguments =new Object[0];

    protected final List<AopMethodInterceptor> interceptorList;

    protected int currentInterceptorIndex =-1;

    public ReflectioveMethodeInvocation(Object proxy, Object target, Method method, Object[] arguments, List<AopMethodInterceptor> interceptorList) {
        this.proxy = proxy;
        this.target = target;
        this.method = method;
        this.arguments = arguments;
        this.interceptorList = interceptorList;
    }

    @Override
    public Object getProxy() {
        return proxy;
    }

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public Object[] getArguments() {
        return arguments;
    }

    @Override
    public Object proceed() throws Throwable {
        if(currentInterceptorIndex == this.interceptorList.size()-1){
            return invokeOrigin();
        }

        AopMethodInterceptor aopMethodInterceptor = this.interceptorList.get(++currentInterceptorIndex);

        return aopMethodInterceptor.invoke(this);
    }


    protected Object invokeOrigin() throws Throwable{
        return ReflectionUtils.invokeMethodUseReflection(method,arguments,target);
    }

}
