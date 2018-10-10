package com.ezhomesixgod.aop.bean;

import java.util.List;

/**
 * @author
 * @description Bean对象
 * @createTime 2018-09-26 17:37
 */
public class AopBeanDefinition extends BeanDefinition {

    private String target;

    private List<String> interceptorNames;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public List<String> getInterceptorNames() {
        return interceptorNames;
    }

    public void setInterceptorNames(List<String> interceptorNames) {
        this.interceptorNames = interceptorNames;
    }
}
