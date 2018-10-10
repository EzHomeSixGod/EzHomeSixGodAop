package com.ezhomesixgod.aop;

import com.ezhomesixgod.aop.core.AopApplictionContext;

/**
 * @author
 * @description
 * @createTime 2018-09-27 15:19
 */
public class Application {
    public static void main(String[] args) {
        AopApplictionContext aopApplictionContext = new AopApplictionContext("application.json");
        aopApplictionContext.init();
        TestService testService = null;
        try {
            testService = (TestService) aopApplictionContext.getBean("testServiceProxy");

            testService.testMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
