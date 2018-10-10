package com.ezhomesixgod.aop.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author renyang
 * @description
 * @createTime 2018-09-26 17:39
 */
public class ReflectionUtils {

    public static void injectField(Field field,Object obj,Object value){

        try {
            if(field !=null){
                field.setAccessible(true);
                field.set(obj,value);
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static Object invokeMethodUseReflection(Method method, Object[] arguments, Object target){
        Object object =null;
        try {
            object =  method.invoke(target,arguments);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return object;
    }
}
