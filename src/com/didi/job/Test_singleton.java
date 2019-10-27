package com.didi.job;

/**
 * @ClassNameTest_singleton
 * @Description 单例模式
 * @Author myr
 * @Date 2019/9/26 15:24
 * @Version 1.0
 **/
public class Test_singleton {

    /**
     * 懒汉式，线程不安全
     * 不支持多线程
     */
    /*
    private static Test_singleton instance;
    private Test_singleton (){}

    public static Test_singleton getInstance(){
        if(instance == null){
            instance = new Test_singleton();
        }
        return instance;
    }
    */

    /**
     * 懒汉式 线程安全 加了锁
     * 支持多线程
     * 第一次调用才初始化，避免内存浪费，缺点是加锁会影响效率
     */
    /*
    private static Test_singleton instance;
    private Test_singleton (){}

    public static synchronized Test_singleton getInstance(){
        if(instance == null){
            instance = new Test_singleton();
        }
        return instance;
    }
    */

    /**
     * 饿汉式
     * 线程安全，没有加锁，执行效率会提高，类加载时就初始化，浪费内存
     /*
    private static Test_singleton instance  = new Test_singleton();
    private Test_singleton(){}
    public static Test_singleton getInstance(){
        return instance;
    }
    */

    /**
     * 双重校验锁
     * 多线程情况下保持高性能
     */

    /*private static volatile Test_singleton instance;
    private Test_singleton (){}

    public static Test_singleton getInstance(){
        if(instance == null)
        synchronized(Test_singleton.class){
            if(instance == null){
                instance = new Test_singleton();
            }
        }
        return instance;
    }*/
    private static volatile Test_singleton instance;
    private Test_singleton(){}
    public static Test_singleton getInstance()
    {
        if(instance == null){
            synchronized (Test_singleton.class){
                if(instance == null){
                    instance = new Test_singleton();
                }
            }
        }
        return instance;
    }

}
