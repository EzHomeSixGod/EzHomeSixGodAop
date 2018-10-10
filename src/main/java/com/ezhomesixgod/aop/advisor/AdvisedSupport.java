package com.ezhomesixgod.aop.advisor;

import com.ezhomesixgod.aop.interceptor.AopMethodInterceptor;

import java.util.LinkedList;
import java.util.List;

/**
 * @author renyang
 * @description
 * @createTime 2018-09-27 15:40
 */
public class AdvisedSupport extends Advisor{

    private TargetSource targetSource;

    private List<AopMethodInterceptor> aopMethodInterceptors=new LinkedList<>();

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public List<AopMethodInterceptor> getAopMethodInterceptors() {
        return aopMethodInterceptors;
    }

    public void setAopMethodInterceptors(List<AopMethodInterceptor> aopMethodInterceptors) {
        this.aopMethodInterceptors = aopMethodInterceptors;
    }

    public void addAopMethodInterceptor(AopMethodInterceptor aopMethodInterceptor){
        aopMethodInterceptors.add(aopMethodInterceptor);
    }

    public void addAopMethodInterceptors(List<AopMethodInterceptor> interceptors){
        aopMethodInterceptors.addAll(interceptors);
    }
}
