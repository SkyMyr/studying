package com.observer.test;

import java.util.Observable;
import java.util.Observer;

/**
 * @ClassNameSimpleObserver
 * @Description 具体观察者
 * @Author myr
 * @Date 2019/10/11 11:01
 * @Version 1.0
 **/
public class SimpleObserver implements Observer{

    /**
     * 观察者注册
     * @param simpleObservable  //具体主题对象
     */
    public SimpleObserver(SimpleObservable simpleObservable) {
        simpleObservable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("data has been changed to " + arg + this.toString());
    }
}
