package com.didi.job;

import java.util.HashMap;

/**
 * @ClassNameTest_leetCode344
 * @Description 反转字符串
 * @Author myr
 * @Date 2019/10/5 14:59
 * @Version 1.0
 **/
public class Test_leetCode344 {

    public static void main(String[] args) {
        System.out.println(9*4/-5%5);//-2
        //test
        char[] a = {'a','b','c'};
        reverseString(a);
    }

    /**
     * 写完了他告我说这叫双指针，我就呵呵了，这么简单谁想不到呀
     * @param s
     */
    public static void reverseString(char[] s) {
        int len = s.length;
        for(int i = 0, j = len-1; i < j; i++,j-- ){
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
        for(int i = 0; i < len; i++)
            System.out.println(s[i]);
    }
}
