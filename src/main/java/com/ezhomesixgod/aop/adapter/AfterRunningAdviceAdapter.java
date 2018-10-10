package com.ezhomesixgod.aop.adapter;

import com.ezhomesixgod.aop.advisor.Advisor;
import com.ezhomesixgod.aop.advisor.AfterReturningAdvice;
import com.ezhomesixgod.aop.interceptor.AfterRunningAdviceInterceptor;
import com.ezhomesixgod.aop.interceptor.AopMethodInterceptor;

/**
 * @author renyang
 * @description
 * @createTime 2018-09-29 10:45
 */
public class AfterRunningAdviceAdapter implements AdviceAdapter {
    private AfterRunningAdviceAdapter(){

    }

    private static final AfterRunningAdviceAdapter INSTANTS = new AfterRunningAdviceAdapter();

    public static AfterRunningAdviceAdapter getInstants(){
        return INSTANTS;
    }

    @Override
    public AopMethodInterceptor getInterceptor(Advisor advisor) {
        AfterReturningAdvice advice = (AfterReturningAdvice) advisor.getAdvice();
        return new AfterRunningAdviceInterceptor(advice);
    }
}
