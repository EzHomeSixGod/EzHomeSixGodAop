package com.ezhomesixgod.aop.advisor;

import java.lang.reflect.Method;

/**
 * @author renyang
 * @description
 * @createTime 2018-09-27 15:41
 */
public interface BeforeMethodAdvice extends Advice{

    void before(Method method, Object[] args, Object target);
}
