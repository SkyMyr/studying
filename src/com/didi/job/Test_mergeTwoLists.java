package com.didi.job;

/**
 * @ClassNamemergeTwoLists
 * @Description 合并两个有序链表
 * @Author myr
 * @Date 2019/9/26 18:56
 * @Version 1.0
 **/
public class Test_mergeTwoLists {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode prehead = new ListNode(-1);
        ListNode pre = prehead;
        while(l1!=null && l2!=null){
            if(l1.val > l2.val){
                pre.next = l2;
                pre = pre.next;
            }else{
                pre.next = l1;
                pre = pre.next;
            }
        }
        if(l1 != null){
            pre.next = l1;
        }
        if(l2 != null){
            pre.next = l2;
        }
        return  prehead.next;
    }
}
