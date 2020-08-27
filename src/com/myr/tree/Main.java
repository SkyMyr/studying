package com.myr.tree;

import java.util.*;

public class Main {

    //TopN问题
//    public List<Integer> getTopK(int[] nums,int k){
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for (int x:nums) {
//            map.put(x,map.getOrDefault(x,0)+1);
//        }
//        PriorityQueue<Integer> queue = new LinkedList<Integer>((n1,n2)->map.get(n1)-map.get(n2));
//        for (int x:map.keySet()) {
//            queue.add(x);
//            if(queue.size()>k){
//                queue.poll();
//            }
//        }
//        List<Integer> result = new ArrayList<>();
//        while(!queue.isEmpty()){
//            result.add(queue.poll());
//        }
//        return result;
//    }


    //上帝视角一周股市 收益最大化
    public static Integer getMaxMoney(int[] nums){
        Integer result = 0;
        int len = nums.length;
        int[] a = new int[len];
        for (int i = 0; i < len-1; i++) {
            a[i] = nums[i+1] - nums[i];
            if(a[i]>0){
                result += a[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,3,5,3,5};
        System.out.println(getMaxMoney(input));
    }

}
