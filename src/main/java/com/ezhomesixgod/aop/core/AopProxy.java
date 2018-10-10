package com.ezhomesixgod.aop.core;

public interface AopProxy {

    public Object getProxy();

    public Object getProxy(ClassLoader classLoader);
}
