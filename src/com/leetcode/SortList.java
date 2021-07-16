package com.leetcode;

import java.util.*;

/**
 * @author muyanren
 */
public class SortList {
    /**
     * 链表排序（插入排序）
     * @param head root
     * @return head
     */
    public ListNode sortList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode lastNode = head, cur = head.next;
        while(cur!=null){
            if(lastNode.val<=cur.val){
                lastNode = lastNode.next;
            }else{
                ListNode pre = preHead;
                while (pre.next.val<=cur.val){
                    pre = pre.next;
                }
                lastNode.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = lastNode.next;
        }
        return preHead.next;
    }
}

/**
 * 前K个高频元素
 */
class Solution1{
    public List<Integer> topKFrequent(int[] nums, int k, String s){
        //1.将nums放到一个map中
        //2.堆排序 可用优先级队列 小顶堆  当堆中元素数量大于K时去除堆顶元素
        //3.遍历完毕之后再将队列元素放入队列中去
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//        }
//        // 小顶堆 2-1是大顶堆
//        PriorityQueue<Integer> queue = new PriorityQueue<>((n1,n2)->map.get(n2)-map.get(n1));
//        for (Integer key:map.keySet()) {
//            queue.add(key);
//            if(queue.size()>k){
//                queue.poll();
//            }
//        }
//        List<Integer> res = new ArrayList<>();
//        while (!queue.isEmpty()){
//            res.add(queue.poll());
//        }
//        return res;

        Map<Character,Integer> map1 = new HashMap<>();
        for (char c:s.toCharArray()){
            map1.put(c,map1.getOrDefault(c,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> queue = new PriorityQueue<>((o1,o2)->o2.getValue()-o1.getValue());
        queue.addAll(map1.entrySet());
        StringBuilder res = new StringBuilder();
        while(!queue.isEmpty()){
            Map.Entry<Character,Integer>  entry = queue.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                res.append(entry.getKey());
            }
        }
//        return res.toString();
        return null;
    }
}

/**
 * 反转链表M-N之间的节点
 */
class Solution2{
    public ListNode reverseBetween(ListNode head, int left, int right){
        // 1.两个指针 分别指向第left个节点和他的前置节点
        // 2.再利用头插法，反转left和right之间的节点
        // 3.返回初始化指针
        if(left == right){
            return head;
        }
        ListNode pro = new ListNode(-1);
        pro.next = head;
        ListNode pre = pro;
        ListNode cur = head;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
            cur = cur.next;
        }
        for (int i = 0; i < right - left; i++) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = cur;
            pre.next = tmp;
        }
        return pro.next;

    }
}

/**
 * 三数之和
 */
class Solution3 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 1.边界条件判定
        // 2.排序；第一层循环：先定一个数 target，然后目标就变成了找两数之和=-target
        // 3.双指针指向一头一尾 内层循环条件：头必须在尾左边
        //  （1）如果和等于0，添加结果数组，指针全部向中间移动，且跳过和当前重复的数；
        //  （2）如果和大于0，说明右边的数大了，右指针向中间移动；
        //  （3）如果和小于0，说明左边的数小了，左指针向中间移动；
        // 4.补充边界条件：
        //   (1)外层循环，如果当前数和上一个数重复则跳过
        //   (1)外层循环，如果当前数大于0，则不可能有后边的数和为0的情况，循环结束
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (n < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                break;
            }
            // forget
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
                if (sum > 0) {
                    right--;
                }
                if (sum < 0) {
                    left++;
                }
            }
        }
        return result;
    }
}

/**
 * 删除链表中的倒数第n个节点
 */
class Solution4 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 1.删除链表中的倒数第n个节点 可使用快慢指针 快指针比慢指针先走n个节点
        // 2.如果快指针==null了 说明n是头节点，返回头节点的下一节点即可
        // 3.当快指针不为空时，需要额外一个前置节点记录慢指针的前驱节点，快、慢、前驱指针同时向后移
        // 4.当快指针为空时，前驱节点指向快指针，返回head节点
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if(fast==null){
            return head.next;
        }
        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
            pre = pre.next;
        }
        pre.next = slow.next;
        return head;
    }

    public void reorderList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null){
            return ;
        }
        int len = 0;
        ListNode p = head;
        while (p!=null){
            len++;
            p = p.next;
        }

        reorderList(head,len);
    }

    public ListNode reorderList(ListNode head,int len) {
        if(len==1){
            ListNode outTail = head.next;
            head.next = null;
            return outTail;
        }
        if(len==2){
            ListNode outTail = head.next.next;
            head.next.next=null;
            return outTail;
        }
        ListNode tail = reorderList(head.next,len-2);
        ListNode subHead = head.next;
        head.next = tail;
        ListNode outTail = tail.next;
        tail.next = subHead;
        return outTail;
    }
}