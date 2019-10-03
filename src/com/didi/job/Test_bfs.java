package com.didi.job;

import com.myr.tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassNameTest_bfs
 * @Description 广度、深度优先遍历
 * @Author myr
 * @Date 2019/9/24 14:33
 * @Version 1.0
 **/
public class Test_bfs {
    /**
     * 广度优先遍历---借助队列---非递归实现
     * @param root 根节点
     * @return list数组
     */
    public ArrayList<Integer> bfs(Node<Integer> root){
        ArrayList<Integer> lists = new ArrayList<Integer>();
        if(root == null){
            return lists;
        }
        Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node<Integer> tree = queue.poll();
            if(tree.getLchild() != null){
                queue.offer(tree.getLchild());
            }
            if(tree.getRchild() != null){
                queue.offer(tree.getRchild());
            }
            lists.add(tree.getData());
        }
        return lists;
    }

    public ArrayList<Integer> dfs(Node<Integer> root){
        ArrayList<Integer> lists = new ArrayList<Integer>();
        if(root == null){
            return lists;
        }
        Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node<Integer> tree = stack.pop();
            if(tree.getRchild() != null){
                stack.push(tree.getRchild());
            }
            if(tree.getLchild() != null){
                stack.push(tree.getLchild());
            }
            lists.add(tree.getData());
        }
        return lists;
    }
}
