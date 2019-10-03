package com.didi.job;

import java.util.Stack;

/**
 * @ClassNameTest_quickSort
 * @Description 快排的递归和非递归实现
 * @Author myr
 * @Date 2019/9/24 15:10
 * @Version 1.0
 **/
public class Test_quickSort {

    /**
     * 递归实现快排
     * @param arr
     * @param l
     * @param r
     */
    public void quickSort(Integer[] arr, int l, int r){
        if(l < r){
            Integer mid = partition(arr,l,r);
            quickSort(arr,l,mid-1);
            quickSort(arr,mid+1,r);
        }
    }

    /**
     * 非递归实现快排
     * @param arr
     * @param l
     * @param r
     */
    public void quickSorts(Integer[] arr, int l, int r){
        int index;
        Stack<Integer> stack = new Stack<Integer>();
        //先压left 再压right
        stack.push(l);
        stack.push(r);
        while(!stack.empty()){
            Integer high = stack.pop(); //先弹出right 再弹left
            Integer low = stack.pop();
            index = partition(arr,low,high);
            if(low < index - 1){
                stack.push(low);
                stack.push(index - 1);
            }
            if(index +1 > high){
                stack.push(index +1);
                stack.push(high);
            }
        }
    }

    /**
     * 一次划分算法
     * @param arr 以arr[l]为支点进行划分
     * @param l
     * @param r
     * @return 返回支点记录的最终位置
     */
    public Integer partition(Integer[] arr, int l, int r){
        int tmp = arr[l];
        while(l < r){
            while (l < r && arr[r] >= tmp){
                r--;
            }
            if(l < r){
                arr[l] = arr[r];
                l++;
            }
            while(l < r && arr[l] <= tmp){
                l++;
            }
            if(l < r){
                arr[r] = arr[l];
                r--;
            }
        }
        arr[l] = tmp;
        return l;
    }
}
