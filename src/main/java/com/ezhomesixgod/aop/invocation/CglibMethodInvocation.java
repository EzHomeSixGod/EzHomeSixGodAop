package com.ezhomesixgod.aop.invocation;

import com.ezhomesixgod.aop.interceptor.AopMethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author
 * @description
 * @createTime 2018-09-28 10:06
 */
public class CglibMethodInvocation extends ReflectioveMethodeInvocation {

    private MethodProxy methodProxy;

    public CglibMethodInvocation(Object proxy, Object target, Method method, Object[] arguments, List<AopMethodInterceptor> interceptorList,MethodProxy methodProxy) {
        super(proxy, target, method, arguments, interceptorList);
        this.methodProxy =methodProxy;
    }


    @Override
    protected Object invokeOrigin() throws Throwable {
        return methodProxy.invoke(target,arguments);
    }
}
