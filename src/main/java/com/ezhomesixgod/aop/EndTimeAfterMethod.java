package com.ezhomesixgod.aop;

import com.ezhomesixgod.aop.advisor.AfterReturningAdvice;
import com.ezhomesixgod.aop.utils.ThreadLocalUtils;

import java.lang.reflect.Method;

/**
 * @author renyang
 * @description
 * @createTime 2018-09-29 11:08
 */
public class EndTimeAfterMethod implements AfterReturningAdvice {
    @Override
    public Object after(Object returnVal, Method method, Object[] args, Object target) {
        long endTime = System.currentTimeMillis();
        long startTime = ThreadLocalUtils.get();
        ThreadLocalUtils.remove();
        System.out.println("方法耗时：" + (endTime - startTime) + "ms");
        return returnVal;

    }
}
