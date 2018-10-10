package com.ezhomesixgod.aop;

import com.ezhomesixgod.aop.advisor.BeforeMethodAdvice;
import com.ezhomesixgod.aop.utils.ThreadLocalUtils;

import java.lang.reflect.Method;

/**
 * @author renyang
 * @description
 * @createTime 2018-09-29 11:05
 */
public class StartTimeBeforeMethod implements BeforeMethodAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) {
        long startTime = System.currentTimeMillis();
        System.out.println("开始计时");
        ThreadLocalUtils.set(startTime);

    }
}
