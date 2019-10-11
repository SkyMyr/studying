package com.observer.test;

/**
 * @ClassNameMain
 * @Description 测试类
 * @Author myr
 * @Date 2019/10/11 11:09
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        SimpleObservable s1 = new SimpleObservable();
        SimpleObserver observer1 = new SimpleObserver(s1);
        SimpleObserver observer2 = new SimpleObserver(s1);
        s1.setInfo(123);
        s1.setInfo(456);
        s1.setInfo(789);
    }
}
