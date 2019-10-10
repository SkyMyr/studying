package com.proxy.test;

/**
 * @ClassNameProxyObject
 * @Description 代理对象
 * @Author myr
 * @Date 2019/10/10 18:04
 * @Version 1.0
 **/
public class ProxyObject implements Moduel {

    private Moduel moduel;

    public ProxyObject(Moduel moduel){
        this.moduel = moduel;
    }

    @Override
    public void doAction(String gun) {
        try{
            System.out.println("method start");
            moduel.doAction("fire");
            System.out.println("method end");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
