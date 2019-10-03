package com.didi.job;

/**
 * @ClassNameTest_mergeSort
 * @Description 归并排序
 * @Author myr
 * @Date 2019/9/24 16:23
 * @Version 1.0
 **/
public class Test_mergeSort {


    /**
     * 递归实现
     * @param arr 待排序序列
     * @param low 起始索引
     * @param high 终止索引
     * @param tmp 目标序列
     */
    public void mergeSorts(Integer[] arr, Integer low, Integer high, Integer[] tmp){
        if(low < high){
            Integer mid = (low + high) /2;
            mergeSorts(arr, low, mid,tmp);
            mergeSorts(arr, mid+1, high, tmp);
            merge(arr,low,mid,high,tmp);
        }
    }

    /**
     * 二路归并
     * @param arr
     * @param tmp
     */
    public  void mergeSort(Integer[] arr, Integer[] tmp){
        Integer n = arr.length;
        Integer len = 1;
        while(len<n){
            mergePass(arr,tmp,len,n);
            len = len*2;
            mergePass(tmp,arr,len,n);
        }
    }
    /**
     * 一趟归并算法
     * @param arr 排序前的数组
     * @param tmp 排序后的数组
     * @param len 要合并的有序表的长度
     * @param n arr的终止索引
     */
    public void mergePass(Integer[] arr, Integer[] tmp, Integer len, Integer n){
        int i=0;
        for( ; i+2*len-1 <= n; i = i+2*len){//对两个长度为len的有序表合并
            merge(arr, i, i+len-1, i+2*len-1, tmp);
        }
        if(i + len -1 < n){//一组半的情况
            merge(arr, i, i+len-1, n, tmp);
        }else if(i <= n){
            while(i <= n){//最后一组没有合并者
                tmp[i++] = arr[i++];
            }
        }
    }

    /**
     * 两个有序序列的合并
     * @param arr 待排序的序列
     * @param low 左边序列起始索引
     * @param mid 左边序列终止索引
     * @param high 右边序列终止索引
     * @param tmp 合并后的序列
     */
    public void merge(Integer[] arr, Integer low, Integer mid, Integer high, Integer[] tmp){
        Integer t = low;//合并后序列 的起始索引
        Integer i = low;//左边序列起始索引
        Integer j = mid+1;//右边序列起始索引
        while(i <= mid && j <= high){//往新序列中放，从小到大
            if(arr[i] < arr[j]){
                tmp[t++] = arr[i++];
            }else{
                tmp[t++] = arr[j++];
            }
        }
        //剩余数据放入序列中
        while(i <= mid){
            tmp[t++] = arr[i++];
        }
        while (j <= high){
            tmp[t++] = arr[j++];
        }
    }
}
