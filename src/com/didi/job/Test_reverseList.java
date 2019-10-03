package com.didi.job;

import java.util.List;
import java.util.Stack;

/**
 * @ClassNameTest_reverseList
 * @Description 反转链表
 * @Author myr
 * @Date 2019/9/26 18:17
 * @Version 1.0
 **/
public class Test_reverseList {

     class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode node = head;
        Stack<ListNode> stack = new Stack<ListNode>();
        while(node.next != null){
            stack.push(node);
            node = node.next;
        }
        ListNode resultNode = node;
        while(!stack.isEmpty()){
            node.next = stack.pop();
            node = node.next;
        }
        node.next = null;
        return resultNode;
    }
}
