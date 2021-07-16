package com.myr.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author muyanren
 */
public class LRU {
    class LRUCache {

        class Node{
            int key;
            int value;
            Node pre;
            Node next;
            public Node(){}
            public Node(int k, int v){
                this.key=k;
                this.value=v;
            }
        }

        private int size;
        private int capacity;
        private HashMap<Integer,Node> map = new HashMap<>();
        private Node head,tail;
        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            tail = new Node();
            head = new Node();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            Node node = map.get(key);
            if(node != null){
                //1.将该节点移到队头
                moveToHead(node);
                //2.返回该节点的值
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if(node != null){
                //1.将该节点移到队列头部
                node.value = value;
                moveToHead(node);
            }else {
                node = new Node(key,value);
                map.put(key,node);
                addToHead(node);
                //1.初始化该节点，放入缓存中，并且移动到队头
                //2.如果缓存大小大于队列长度，移出队尾节点
                size++;
                if(size>capacity){
                    map.remove(tail.pre.key);
                    removeNode(tail.pre);

                    --size;
                }
            }
        }

        void moveToHead(Node node)
        {
            removeNode(node);
            addToHead(node);
        }

        void removeNode(Node node){
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        void addToHead(Node node){
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }
    }


    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            int len = nums.length;
            if (len < 3) {
                return result;
            }
            Arrays.sort(nums);
            for (int i = 0; i < len; i++) {
                if(nums[i]>0){
                    break;
                }
                if(i>0&&nums[i]==nums[i-1]){
                    continue;
                }
                int l=i+1,r=len-1;
                while (l<r){

                    int sum = nums[l] + nums[r] + nums[i];
                    if(sum==0){
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[i]);
                        item.add(nums[l]);
                        item.add(nums[r]);
                        result.add(item);
                        while(l<r&&nums[l]==nums[l+1]){
                            l++;
                        }
                        while(l<r&&nums[r]==nums[r-1]){
                            r--;
                        }
                        l++;r--;
                    }
                    if(sum<0){
                        l++;
                    }
                    if(sum>0){
                        r--;
                    }
                }
            }
            return result;
        }
    }


}
