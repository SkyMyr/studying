package com.leetcode;

/**
 * @author muyanren
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = head;
        ListNode node = head;
        while(n>0){
            node = node.next;
            n--;
        }
        if(node==null){
            return head.next;
        }
        ListNode preNode = head;
        head = head.next;
        node = node.next;
        while(node!=null){
            preNode = preNode.next;
            head = head.next;
            node = node.next;
        }
        preNode.next = head.next;
        return start;
    }
}
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
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }