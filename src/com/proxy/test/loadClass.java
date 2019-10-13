package com.proxy.test;

/**
 * @ClassNameloadClass
 * @Description 双亲委派
 * @Author myr
 * @Date 2019/10/12 22:05
 * @Version 1.0
 **/
public class loadClass {
    protected synchronized Class<?> loadClass(String name, boolean resolve) throws  ClassNotFoundException
    {
        //Class c =findLoadedClass(name);
        Class c = Class.forName("");
        return c;
    }
}
