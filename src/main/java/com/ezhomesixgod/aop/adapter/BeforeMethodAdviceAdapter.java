package com.ezhomesixgod.aop.adapter;

import com.ezhomesixgod.aop.advisor.Advice;
import com.ezhomesixgod.aop.advisor.Advisor;
import com.ezhomesixgod.aop.advisor.BeforeMethodAdvice;
import com.ezhomesixgod.aop.interceptor.AopMethodInterceptor;
import com.ezhomesixgod.aop.interceptor.BeforeMethodAdviceInterceptor;

/**
 * @author renyang
 * @description
 * @createTime 2018-09-29 10:46
 */
public class BeforeMethodAdviceAdapter implements AdviceAdapter {

    private BeforeMethodAdviceAdapter() {
    }

    private static final BeforeMethodAdviceAdapter INSTANTS = new BeforeMethodAdviceAdapter();

    public static BeforeMethodAdviceAdapter getInstants(){
        return INSTANTS;
    }
    @Override
    public AopMethodInterceptor getInterceptor(Advisor advisor) {
        BeforeMethodAdvice advice = (BeforeMethodAdvice) advisor.getAdvice();
        return new BeforeMethodAdviceInterceptor(advice);
    }
}
