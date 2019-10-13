package com.didi.job;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.Vector;

/**
 * @ClassNameTest_58
 * @Description 58笔试
 * @Author myr
 * @Date 2019/10/13 19:38
 * @Version 1.0
 **/
public class Test_58 {

    public static void main(String[] args) {
        //2、寻找数组中出现数的个数
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        System.out.println(getNum(m,n,x));
//        //3、上台阶
//        int n = scanner.nextInt();
//        System.out.println(xiaoba(n));
    }

    public static  long getNum(int m,int n,int x)
    {
        long num = 0;
        for(int i = m; i<=n;i++)
        {
            String a = i+"";
            num += a.length() - a.replace(x + "", "").length();
        }
        return num;
    }

    public static int xiaoba (int n)
    {
        int a = 1, b = 1;
        while( (n--) != 0 )
        {
            b += a;
            a = b - a;
        }
        return a;
    }
}
