package com.didi.job;

import  java.util.*;
import  java.lang.*;
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
//            反转前半部分链表
            ListNode pre = null;
            ListNode next = null;
            while(head != low){
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
//            判断奇偶
            if(fast != null){
                low = low.next;
            }
//            回文比较
            while(low != null){
                if(low.val != pre.val)
                    return false;
                low = low.next;
                pre = pre.next;
            }
            return true;
        }

        public int primePalindrome(int N)
        {
            while(true){
                String num = String.valueOf(N);
                if( ( num.length() & 1 ) == 0)
                    N = (int)Math.pow(10, num.length() + 1);
                if(isPrime(N) && isReverse(N))
                    return N;
                N++;
                /*if(N > 10000000 && N < 100000000)
                    N = 100000000;*/
            }
        }

        public boolean isPrime(int n)
        {
            if(n < 2)
                return false;
            for(int i = 2; i <= Math.sqrt(n); i++){
                if(n % i == 0)
                    return false;
            }
            return true;
        }

        public boolean isReverse(int n)
        {
            int result = 0, flag = n;
            while(n > 0){
                result = result * 10 + ( n % 10 );
                n /= 10;
            }
            return flag == result? true : false;
        }

}
