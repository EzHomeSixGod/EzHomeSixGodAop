package com.ezhomesixgod.aop.advisor;

import java.lang.reflect.Method;

public interface AfterReturningAdvice extends Advice {

    Object after(Object returnVal, Method method, Object[] args, Object target);

}
