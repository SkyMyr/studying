package com.didi.job;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassNameReview_reverseList
 * @Description 数组实现链表反转（包括链表的多种变形形式）
 * @Author myr
 * @Date 2019/10/1 14:46
 * @Version 1.0
 **/
public class Review_reverseList {

    //原来滴滴面试官对我这么宽容了已经...
    /**
     * 节点数据结构
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 输入: 1->2->3->4->5->NULL
     * 普通单链表反转
     * @param head
     * @return
     */
    public static  ListNode reverseList(ListNode head){//前驱后继互换法
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static  ListNode reverseList1(ListNode head){//头插法
        ListNode pre = new ListNode(-1);
        ListNode cur = head;
        ListNode next = null;
        pre.next = head;

        while (cur.next != null){//截止条件  null（普通单链表）
            next = cur.next;
            if(cur.next == head){//截止条件 head 环形单链表
                cur.next = null;
                break;
            }
            if(next.next == pre.next)//截止条件 n3.next = n2 尾巴环形单链表
            {
                cur.next = null;
                pre.next = next;
                break;
            }
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return pre.next;
    }

    /**
     * 输入: 1->2->3->4->5->1
     * @param head
     * @return
     */
    public static  ListNode reverseList2(ListNode head){//环形链表
        ListNode cur = head.next;
        ListNode next = cur.next;
        head.next = null;
        ListNode head1 = head;
        while (head != next){
            cur.next = head1;
            head1 = cur;
            cur = next;
            next = next.next;
        }
        cur.next = head1;
        return cur;
    }

    /**
     * 输入: 1->2->3->4->5->4
     * @param head
     * @return
     */
    public static  ListNode reverseList3(ListNode head){//尾部有环
        ListNode cur = head.next;
        ListNode next = cur.next;
        head.next = null;
        ListNode head1 = head;
        while (cur != next.next){
            cur.next = head1;
            head1 = cur;
            cur = next;
            next = next.next;
        }
        cur.next = head1;
        return next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        // n3.next = head;        //环形
        // n3.next = n2;          //尾部有环
        ListNode result = reverseList(head);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
        System.out.println();
    }
}
