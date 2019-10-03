package com.myr.tree;

/**
 * @ClassNameTreeCrud
 * @Description TODO
 * @Author myr
 * @Date 2019/9/22 16:10
 * @Version 1.0
 **/
public class TreeCrud {

    Node root = new Node();

    //参考：https://blog.csdn.net/qq_33188563/article/details/82430128  +  https://blog.csdn.net/qq_31884013/article/details/73457685

    /**
     * 增加节点
     * @param node 新增节点
     * @param root 根节点
     */
    public void insertTree(Node<Integer> node,Node<Integer> root){
        if( node.getData() >  root.getData() ){
            if(root.getRchild() == null ){
                root.setRchild(node);
            }else{
                insertTree(node,root.getRchild());
            }
        }else if(node.getData() < root.getData()){
            if(root.getLchild() == null ){
                root.setLchild(node);
            }else{
                insertTree(node,root.getLchild());
            }
        }
        else{
            //do nothing
        }
    }

    /**
     * 查找指定元素的节点
     * @param root 根节点
     * @param data 需要查找的数据
     * @return 空或者目标元素节点
     */
    public Node<Integer> searchTree(Node<Integer> root, Integer data){
        if(root == null){
            System.out.println("查找节点不存在！");
            return root;
        }
        if(root.getData().compareTo(data) < 0){
            return searchTree(root.getRchild(),data);
        }else if(root.getData().compareTo(data) > 0){
            return searchTree(root.getLchild(),data);
        }else{
            return root;
        }
    }

    /**
     * 删除指定元素的节点
     * @param root 根节点
     * @param data 要删除的节点的数据
     * @return 删除是否成功
     */
    public boolean deleteTree(Node<Integer> root, Integer data){
        Node<Integer> cur = root;
        Node<Integer> pre = cur;
        boolean isLchild = true;

        //找目标节点
        while (cur.getData().compareTo(data) != 0){
            pre = cur;
            if(cur.getData().compareTo(data) > 0){
                cur = cur.getLchild();
                isLchild = true;
            }else{
                cur = cur.getRchild();
                isLchild = false;
            }
            //找不到
            if(cur == null){
                return false;
            }
        }
        //删除目标节点
        if(cur.getLchild() == null && cur.getRchild() == null){ //没有孩子
            if(cur == root){//考虑根节点的情况
                root = null;
            }else if(isLchild){
                pre.setLchild(null);
            }else{
                pre.setRchild(null);
            }
        }else if(cur.getLchild() == null){//左孩子为空
            if(cur == root){
                root = root.getRchild();
            }else if(isLchild){
                pre.setLchild(cur.getRchild());
            }else{
                pre.setRchild(cur.getRchild());
            }
        }else if(cur.getRchild() == null){//右孩子为空
            if(cur == root){
                root = root.getLchild();
            }else if(isLchild){
                pre.setLchild(cur.getLchild());
            }else{
                pre.setRchild(cur.getLchild());
            }
        }else{//左右孩子都有
            Node success = getSuccess(cur);//获取目标节点后边的节点
            if(cur == root){
                root = success;
            }else if(isLchild){
                pre.setLchild(success);
            }else{
                pre.setRchild(success);
            }
            success.setLchild(cur.getLchild());
        }
        return true;
    }

    /**
     *@description //获取目标删除节点后边的节点
     * @param delNode 要删除的目标节点
     * @return 调整后他后边的孩子   这里是向右调整，找到最左的孩子
     */
    public Node<Integer> getSuccess(Node<Integer> delNode){
        Node<Integer> success = delNode;
        Node<Integer> successParent = delNode;
        Node<Integer> cur = delNode.getRchild();
        while(cur != null){
            successParent = success;
            success = cur;
            cur = cur.getLchild();
        }
        if(success != delNode.getRchild()){
            successParent.setLchild(success.getRchild());
            success.setRchild(successParent);
        }
        return success;
    }

    /**
     * 修改，就是先删除，然后再添加节点
     */

}
