package com.didi.job;
import java.util.*;
/**
 * @ClassNameTest_Youngtableau
 * @Description 杨氏矩阵
 * @Author myr
 * @Date 2019/10/20 14:14
 * @Version 1.0
 **/
public class Test_Youngtableau {

    //一个从右向左递增，从上到下递增的二位数据矩阵，怎么用算法复杂度O（n）的算法来查找其中的某一个数

    public static void main(String[] args) {
        int a[][]={{2,4,6,8,9},{5,7,10,11,12},{6,8,13,15,19},{15,17,19,21,22}};

        System.out.print("demo例子的数据\n");
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("请输入需要查找的数据");
        Scanner sc=new Scanner(System.in);
        int b=sc.nextInt();

        find(a,b);//默认从第0行最后一列开始判断
    }

    public static void find(int[][] a,int targrt) {
        int i=a.length-1;
        int j=0;
        while(i>=0&&j<=a[0].length-1){

            if (a[i][j]==targrt) {
                System.out.println(i+" "+j);
                return;
            }
            else if (targrt<a[i][j]) {
                i--;
            }
            else {
                j++;
            }
        }
        System.out.println("没有找到");
        return;
    }
}
