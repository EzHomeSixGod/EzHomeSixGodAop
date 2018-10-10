package com.ezhomesixgod.aop.core;

import com.ezhomesixgod.aop.advisor.AdvisedSupport;
import com.ezhomesixgod.aop.utils.ClassUtils;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author renyang
 * @description
 * @createTime 2018-09-28 10:30
 */
public class CglibAopProxy implements AopProxy{

    private AdvisedSupport advisedSupport;

    private Object[] constructorArgs;

    private Class<?>[] constructorArgTypes;

    public CglibAopProxy(AdvisedSupport config){
        this.advisedSupport =config;
    }


    @Override
    public Object getProxy() {
        return getProxy(null);
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        Class<?> rootClass = advisedSupport.getTargetSource().getTagetClass();
        if(classLoader == null){
            classLoader = ClassUtils.getDefaultClassLoader();
        }
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(rootClass.getSuperclass());
        //增加拦截器的核心方法
        Callback callbacks = getCallBack(advisedSupport);
        enhancer.setCallback(callbacks);
        enhancer.setClassLoader(classLoader);
        if(constructorArgs != null && constructorArgs.length > 0){
            return enhancer.create(constructorArgTypes,constructorArgs);
        }
        return enhancer.create();

    }

    private Callback getCallBack(AdvisedSupport advised) {
        return new DynamicAdvisedInterceptor(advised.getAopMethodInterceptors(),advised.getTargetSource());
    }

}
