package BinarySearchTree;

/**
 * Created by Shivangi on 1/7/2017.
 */
public class BSTNode {
    private int data;
    private BSTNode left;
    private BSTNode right;

    public BSTNode(){
        data = 0;
        left = null;
        right = null;
    }

    public BSTNode(int data){
        this.data = data;
        left = null;
        right = null;
    }

    public int getData(){
        return data;
    }

    public void setData(int d){
        this.data = d;
    }

    public BSTNode getLeft(){
        return left;
    }

    public void setLeft(BSTNode l){
        this.left = l;
    }

    public BSTNode getRight(){
        return right;
    }

    public void setRight(BSTNode r){
        this.right = r;
    }
}
