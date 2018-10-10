package com.ezhomesixgod.aop.advisor;

/**
 * @author
 * @description
 * @createTime 2018-09-27 15:38
 */
public class Advisor {

    private Advice advice;

    private Pointcut pointcut;

    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public Pointcut getPointcut() {
        return pointcut;
    }

    public void setPointcut(Pointcut pointcut) {
        this.pointcut = pointcut;
    }
}
