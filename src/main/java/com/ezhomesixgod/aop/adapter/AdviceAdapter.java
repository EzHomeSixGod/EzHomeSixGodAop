package com.ezhomesixgod.aop.adapter;

import com.ezhomesixgod.aop.advisor.Advisor;
import com.ezhomesixgod.aop.interceptor.AopMethodInterceptor;

/**
 * @author renyang
 * @description
 * @createTime 2018-09-29 10:45
 */
public interface AdviceAdapter {
    AopMethodInterceptor getInterceptor(Advisor advisor);
}
