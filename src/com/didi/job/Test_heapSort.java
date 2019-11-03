package com.didi.job;

/**
 * @ClassNameTest_heapSort
 * @Description 堆排序
 * @Author myr
 * @Date 2019/9/24 15:35
 * @Version 1.0
 **/
public class Test_heapSort {

    //https://www.jianshu.com/p/11655047ab58

    /**
     * 堆排序  初始化+排序
     * @param list 二叉树元素
     */
    public void heapSort(Integer[] list){
        Integer len = list.length;
        //构造初始堆，从第一个非叶子结点开始调整，从下往上，节点较大的换到上边
        for(int i = len/2-1; i >= 0; i--){
            heapAdjust(list, len, i);
        }
        //排序，最大的节点放到堆尾，然后从根节点重新调整
        for(int i = len-1; i > 1; i--){
            Integer tmp = list[0];
            list[0] = list[i];
            list[i] = list[0];
            heapAdjust(list,i,0);
        }
    }

    /**
     * 调整堆的过程
     * 注意理解 = 的含义，这里交换的是值，如果每个结点是一个对象，处理的就是对象的引用
     * @param list
     * @param n 最后一个节点
     * @param i 可能不满足堆特性的根节点
     */
    public void heapAdjust(Integer[] list, Integer n, Integer i){//在list当中，只有list[i]与左右子树可能不满足堆的特性，这里是大根堆    空间是到list[n]
        Integer k = i;//根节点
        Integer index =  2*k + 1; //根节点的左孩子节点
        Integer tmp = list[k];//记录根节点
        while(index < n){//左孩子小于n
            if(index +1 < n){//如果有右孩子
                if(list[index] < list[index +1 ]){//选择节点值大的孩子
                    index = index +1;
                }
            }
            if(list[index] > tmp){//如果孩子节点比自己大，向下调整
                list[k] = list[index];
                k = index;
                index = 2*k + 1;
            }else{
                list[k] = tmp;
                break;//已经满足堆特性 不用向下调整了
            }
        }
    }

    //再刷堆排序
    public void heapSort(Integer[] list,Integer n,Integer i){
        Integer k = i;
        Integer index = 2*k + 1;
        Integer tmp = list[i];
        while (index < n){
            if(index+1 < n){
                if(list[index]<list[index+1]){
                    index = index + 1;
                }
            }
            if(list[index]>tmp){
                list[k] = list[index];
                k = index;
                index = 2*k + 1;
            }else {
                list[k] = tmp;
                break;
            }
        }
    }
}
