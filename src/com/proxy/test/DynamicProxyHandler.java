package com.proxy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassNameDynamicProxyHandler
 * @Description 动态代理（基于反射）
 * @Author myr
 * @Date 2019/10/10 19:49
 * @Version 1.0
 **/
public class DynamicProxyHandler implements InvocationHandler {
    private  Object executiveObject;

    public DynamicProxyHandler(Object executiveObject) {
        this.executiveObject = executiveObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("DynamicProxy,动态代理");
        return method.invoke(executiveObject,args);
    }
}
