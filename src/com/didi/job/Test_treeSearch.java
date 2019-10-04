package com.didi.job;
import  java.util.*;
/**
 * @ClassNameTest_treeSearch
 * @Description TODO
 * @Author myr
 * @Date 2019/10/4 20:49
 * @Version 1.0
 **/
public class Test_treeSearch {

    public static class TreeNode{
        public Object key;
        public TreeNode parent;
        public List<TreeNode> childrens = new ArrayList<>();

        public TreeNode(Object key) {
            this.key = key;
        }
    }

    private int size = 0;

    private TreeNode root;

    public Test_treeSearch(TreeNode root) {
        this.root = root;
        size++;
    }


    /**
     * 层次遍历
     *
     * @param treeNode
     * @return
     */
    public List<TreeNode> levelOrder(TreeNode treeNode) {
        /**
         * 层次遍历使用到了广度优先搜索，技巧：深度优先用递归，广度优先用队列。
         */
        Queue<TreeNode> queue = new LinkedList<>();

        List<TreeNode> list = new LinkedList<>();
        queue.add(treeNode);
        while (queue.size()>0){
            //出一个，进n个
            //出一个
            TreeNode node = queue.poll();
            list.add(node);
            //进n个
            List<TreeNode> childens = node.childrens;
            for (TreeNode childNode : childens) {
                queue.add(childNode);
            }
        }
        return list;
    }
    
}
