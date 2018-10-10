package com.ezhomesixgod.aop.core;

import com.ezhomesixgod.aop.adapter.AfterRunningAdviceAdapter;
import com.ezhomesixgod.aop.adapter.BeforeMethodAdviceAdapter;
import com.ezhomesixgod.aop.advisor.*;
import com.ezhomesixgod.aop.bean.AopBeanDefinition;
import com.ezhomesixgod.aop.interceptor.AopMethodInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author renyang
 * @description
 * @createTime 2018-09-29 10:25
 */
public class AopBeanFactoryImpl extends BeanFactoryImpl{

    private static final Logger logger = LoggerFactory.getLogger(AopBeanFactoryImpl.class);

    private static final ConcurrentHashMap<String,AopBeanDefinition> aopBeanDefinitionMap = new ConcurrentHashMap<>();

    private static final ConcurrentHashMap<String,Object> aopBeanMap = new ConcurrentHashMap<>();

    @Override
    public Object getBean(String name) throws Exception {
        logger.info("AopBeanFactoryImpl get Bean:"+name);
        Object aopBean = aopBeanMap.get(name);

        if(aopBean != null){
            return aopBean;
        }

        if(aopBeanDefinitionMap.containsKey(name)){


            AopBeanDefinition aopBeanDefinition = aopBeanDefinitionMap.get(name);
            logger.info("AopBeanFactoryImpl get aopBeanDefinition:"+name);

            AdvisedSupport advisedSupport = getAdvisedSupport(aopBeanDefinition);
            aopBean = new CglibAopProxy(advisedSupport).getProxy();
            aopBeanMap.put(name,aopBean);
            return aopBean;
        }

        return super.getBean(name);
    }

    protected void registerBean(String name, AopBeanDefinition aopBeanDefinition){
        aopBeanDefinitionMap.put(name,aopBeanDefinition);
    }

    private AdvisedSupport getAdvisedSupport(AopBeanDefinition aopBeanDefinition) throws Exception {
        logger.info("AopBeanFactoryImpl aopBeanDefinition getAdvisedSupport");
        AdvisedSupport advisedSupport = new AdvisedSupport();
        List<String> interceptorNames = aopBeanDefinition.getInterceptorNames();
        if(interceptorNames != null && !interceptorNames.isEmpty()){
            for (String interceptorName : interceptorNames) {

                Advice advice = (Advice) getBean(interceptorName);

                Advisor advisor = new Advisor();
                advisor.setAdvice(advice);

                if(advice instanceof BeforeMethodAdvice){
                    AopMethodInterceptor interceptor = BeforeMethodAdviceAdapter.getInstants().getInterceptor(advisor);
                    advisedSupport.addAopMethodInterceptor(interceptor);
                }

                if(advice instanceof AfterReturningAdvice){
                    AopMethodInterceptor interceptor = AfterRunningAdviceAdapter.getInstants().getInterceptor(advisor);
                    advisedSupport.addAopMethodInterceptor(interceptor);
                }

            }
        }

        TargetSource targetSource = new TargetSource();

        Object object = getBean(aopBeanDefinition.getTarget());

        targetSource.setTagetClass(object.getClass());
        targetSource.setTagetObject(object);

        advisedSupport.setTargetSource(targetSource);


        return advisedSupport;

    }
}
