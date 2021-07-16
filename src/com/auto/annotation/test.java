package com.auto.annotation;

import com.sun.deploy.util.StringUtils;

import javax.crypto.spec.PSource;
import java.util.Collections;
import java.util.Stack;

/**
 * @author muyanren
 */
public class test {


    public static int getMax(int[] nums){
//        5,1,2,-9,6,4
        int max = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            if(sum>=0){
                sum +=num;
            }else {
                sum = num;
            }
            max = Math.max(max,sum);
        }
        return max;
//
//        int[] nums = new int[]{5,1,2,-9,6,4};
//        System.out.println(getMax(nums));
    }

    public static void printTowNum(int[] nums, int target){
        int len = nums.length;
        int i = 0,j=len-1;
        while(i<j){
            int sum = nums[i]+nums[j];
            if(sum==target){
                System.out.println(nums[i] + "," + nums[j]);
                i++;
            }
            if(sum<target){
                i++;
            }else{
                j--;
            }
        }
    }

    public static void main(String[] args) {
//        String str = "xabc\b\bd\b\bghi";
//        int len = str.length();
//        Stack<Character> stack = new Stack<>();
//        StringBuilder res = new StringBuilder();
//        for (int i=0;i<len;i++) {
//            char c = str.charAt(i);
//            if(c=='\\'&& i+1<len && str.charAt(i+1)=='b'){
//                stack.pop();
//                i++;
//            }else {
//                stack.push(c);
//            }
//        }
//        while (!stack.isEmpty()){
//            res.append(stack.pop());
//        }
//        System.out.println(res.reverse());

//        Print print = new Print();
//
//        Thread threadOne = new Thread(print);
//        threadOne.setName("Printer1 — ");
//        Thread threadTwo = new Thread(print);
//        threadTwo.setName("Printer2 — ");
//
//        threadOne.start();
//        threadTwo.start();

        Thread thread1 = new Thread(new UserThread(),"user1");
        Thread thread2 = new Thread(new UserThread(),"user2");

        thread1.start();
        thread2.start();
    }

    static class UserThread implements Runnable{

        // 共享变量 库存
        private static int skuPackage = 1000;

        // 私有变量 已购买数
        private int sku = 1;

        @Override
        public void run() {
            // 用户抢购的过程
            while (true){
                synchronized (this){
                    try {
                        Thread.sleep(500);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    // 库存不足不能再抢购
                    if(skuPackage>0){
                        // 用户抢购数大于最大购买数也不可再抢购
                        if(sku>3){
                            System.out.println(Thread.currentThread().getName() + "已达到最大购买数量！" + "当前剩余库存："+skuPackage);
                            break;
                        }

                        System.out.println(Thread.currentThread().getName() + "抢购了" + sku + "个商品");
                        skuPackage--;
                        sku++;
                    }else {
                        System.out.println("该礼品已经抢购完，请关注下次抢购时间");
                        break;
                    }
                }
            }
        }
    }

    static class Print implements Runnable {

        private int num = 1;

        @Override
        public void run() {

            while (true) {
                synchronized (this) {

                    notify();
                    if (num <= 100) {
                        try {
                            Thread.sleep(100);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + num);
                        num++;
                    } else {
                        break;
                    }

                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }



}
