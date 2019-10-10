package com.proxy.test;

/**
 * @ClassNameExecutiveObject
 * @Description 执行对象
 * @Author myr
 * @Date 2019/10/10 17:58
 * @Version 1.0
 **/
public class ExecutiveObject implements Moduel {

    @Override
    public void doAction(String gun) {
        System.out.println("I will shoot at you!" + gun);
    }

}
