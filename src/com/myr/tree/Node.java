package com.myr.tree;
import  java.lang.Object;
/**
 * @ClassNameNode
 * @Description TODO
 * @Author myr
 * @Date 2019/9/22 16:14
 * @Version 1.0
 **/
public class Node <T> {
    private T data;
    private Node lchild;
    private Node rchild;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getLchild() {
        return lchild;
    }

    public void setLchild(Node lchild) {
        this.lchild = lchild;
    }

    public Node getRchild() {
        return rchild;
    }

    public void setRchild(Node rchild) {
        this.rchild = rchild;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", lchild=" + lchild +
                ", rchild=" + rchild +
                '}';
    }

}
