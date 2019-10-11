package com.observer.test;

import java.util.*;

/**
 * @ClassNameSimpleObservable
 * @Description 具体主题
 * @Author myr
 * @Date 2019/10/11 10:06
 * @Version 1.0
 **/
public class SimpleObservable extends Observable{

    //信息状态
    private int info;

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        if(this.info != info)           //状态发送变化
        {
            this.info = info;           //更改状态
            setChanged();               //更改状态标志位
            notifyObservers(info);   //通知所有观察者
        }
    }

}
