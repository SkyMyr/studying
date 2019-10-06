package com.didi.job;

/**
 * @ClassNameTest_Palindrome
 * @Description 回文系列
 * @Author myr
 * @Date 2019/10/6 20:52
 * @Version 1.0
 **/
public class Test_Palindrome {


      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

        public boolean isPalindrome(ListNode head) {

            if(head == null || head.next == null)
                return true;
            //快慢指针走完
            ListNode fast = head.next.next;
            ListNode low = head.next;
            while(fast != null && fast.next != null){
                low = low.next;
                fast = fast.next.next;
            }
            //反转链表
            ListNode pre = null;
            ListNode next = null;
            while(head != low){
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            if(fast != null){
                low = low.next;
            }
            while(low != null){
                if(low.val != pre.val)
                    return false;
                low = low.next;
                pre = pre.next;
            }
            return true;
        }

}
