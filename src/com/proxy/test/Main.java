package com.proxy.test;

import java.lang.reflect.*;

/**
 * @ClassNameMain
 * @Description 客户端
 * @Author myr
 * @Date 2019/10/10 19:00
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        //静态代理
        ProxyObject proxyObject = new ProxyObject(new ExecutiveObject());
        proxyObject.doAction("fire");
        //动态代理
        ExecutiveObject executiveObject = new ExecutiveObject();
        Moduel proxy = (Moduel) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Moduel.class},new DynamicProxyHandler(executiveObject));
        proxy.doAction("fire");
    }
}
