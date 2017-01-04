package BinaryTreeImpl;

/**
 * Created by FS047207 on 1/4/2017.
 */
public class BinaryTreeNode {

    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(){
        left = null;
        right = null;
        data = 0;
    }

    public BinaryTreeNode(int d){
        left = null;
        right = null;
        this.data = d;
    }

    public void setLeft(BinaryTreeNode l){
        left = l;
    }

    public BinaryTreeNode getLeft(){
        return left;
    }

    public void setRight(BinaryTreeNode r){
        right = r;
    }

    public BinaryTreeNode getRight(){
        return right;
    }

    public void setData(int d){
        data = d;
    }

    public int getData(){
        return data;
    }
}