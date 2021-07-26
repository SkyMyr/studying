package com.didi.job;

import java.util.LinkedList;

public class Test_cQueue {

    /**
     * 两个栈实现队列
     */
    class CQueue {
        LinkedList stackA, stackB;
        public CQueue() {
            stackA = new LinkedList();
            stackB = new LinkedList();
        }

        public void appendTail(int value) {
            stackA.addLast(value);
        }

        public int deleteHead() {
            if(!stackB.isEmpty()){
                return (int) stackB.removeLast();
            }
            if(stackA.isEmpty()){
                return -1;
            }
            while (!stackA.isEmpty()){
                stackB.addLast(stackA.removeLast());
            }
            return (int) stackB.removeLast();
        }
    }
}
