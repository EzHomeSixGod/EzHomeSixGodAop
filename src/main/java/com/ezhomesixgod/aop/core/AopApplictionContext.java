package com.ezhomesixgod.aop.core;

import com.ezhomesixgod.aop.bean.AopBeanDefinition;
import com.ezhomesixgod.aop.bean.BeanDefinition;
import com.ezhomesixgod.aop.utils.ClassUtils;
import com.ezhomesixgod.aop.utils.JsonUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.List;

/**
 * @author renyang
 * @description
 * @createTime 2018-09-29 11:15
 */
public class AopApplictionContext extends AopBeanFactoryImpl {

    private static final Logger logger = LoggerFactory.getLogger(AopApplictionContext.class);

    private String fileName;

    public AopApplictionContext(String fileName) {
        this.fileName = fileName;
    }

    public void init(){
        loadFile();
    }

    private void loadFile(){
        logger.info("----loadFile----");
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);

        List<AopBeanDefinition> beanDefinitions = JsonUtils.readValue(is,new TypeReference<List<AopBeanDefinition>>(){});

        if(beanDefinitions != null && !beanDefinitions.isEmpty()) {

            for (AopBeanDefinition beanDefinition : beanDefinitions){
                Class<?> clz = ClassUtils.loadClass(beanDefinition.getClassName());
                if(clz == ProxyFactoryBean.class){
                    registerBean(beanDefinition.getName(),beanDefinition);
                }else {
                    registerBean(beanDefinition.getName(),(BeanDefinition) beanDefinition);
                }
            }
        }

    }

}
