package com.ezhomesixgod.aop.advisor;

/**
 * @author
 * @description
 * @createTime 2018-09-27 15:39
 */
public class TargetSource {
    private Class<?> tagetClass;

    private Object tagetObject;

    public Class<?> getTagetClass() {
        return tagetClass;
    }

    public void setTagetClass(Class<?> tagetClass) {
        this.tagetClass = tagetClass;
    }

    public Object getTagetObject() {
        return tagetObject;
    }

    public void setTagetObject(Object tagetObject) {
        this.tagetObject = tagetObject;
    }
}
