package BinarySearchTree;

import java.util.Scanner;

/**
 * Created by Shivangi on 1/7/2017.
 */
public class BinarySearchTree {

    BSTNode root;

    public BinarySearchTree(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    /*
    Insertion
     */
    public void insert(int data){
        root = insert(root, data);
    }

    public BSTNode insert(BSTNode node, int data){
        if(node == null){
            node = new  BSTNode(data);
        } else {
            if(data <= node.getData()){
                node.setLeft(insert(node.getLeft(), data ));
            } else {
                node.setRight(insert(node.getRight(), data));
            }
        }
        return node;
    }

    /*
    Search
     */
    public boolean search(int data){
        return search(root, data);
    }

    public boolean search(BSTNode node, int data){
        if(node ==  null ){
            return false;
        } else {
            if (node.getData() == data){
                return true;
            } else{
                if(data <= node.getData()){
                    return search(node.getLeft(), data);
                } else {
                    return search(node.getRight(), data);
                }
            }
        }
    }

    /*
    Count
     */
    public int count(){
        return count(root);
    }

    public int count(BSTNode node){
        if(node != null){
            int n = 1;
            n +=  count(node.getLeft());
            n += count(node.getRight());
            return n;
        }
        return 0;
    }

    /*
    Height
     */
    public int height(){
        return height(root);
    }

    public int height(BSTNode node){
        if(node != null){
            if(node.getLeft() != null || node.getRight() != null){
                int hleft = height(node.getLeft());
                int hright = height(node.getRight());

                return hleft > hright ? hleft+1 : hright+1;
            }
        }
        return 0;
    }

    /*
    Traversal
     */
    public void preOrder(){
        preOrder(root);
    }

    public void preOrder(BSTNode node){
        if(node != null){
            System.out.print(node.getData() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void inOrder(){
        inOrder(root);
    }

    public void inOrder(BSTNode node){
        if(node != null){
            inOrder(node.getLeft());
            System.out.print(node.getData() + " ");
            inOrder(node.getRight());
        }
    }

    public void postOrder(){
        postOrder(root);
    }

    public void postOrder(BSTNode node){
        if(node != null){
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }

    public static void main(String args[]){
        BinarySearchTree bst = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);

        char ch;
        do{
            System.out.println("\nEnter your choice: \n1. Insert \n2. Search \n3. Count \n4. Check Empty \n5. Height");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\nEnter element to insert");
                    bst.insert(sc.nextInt());
                    break;

                case 2:
                    System.out.println("\nEnter element to search");
                    if(bst.search(sc.nextInt()))
                        System.out.println("Element exist !");
                    else
                        System.out.println("Element does not exit !");
                    break;

                case 3:
                    System.out.println("\nTotal number of nodes: " + bst.count());
                    break;

                case 4:
                    System.out.println("\nIs it empty? -> \"" + bst.isEmpty()+"\"");
                    break;

                case 5:
                    System.out.println("\nHeight of BST: " + bst.height());
                    break;

                default:
                    System.out.println("Wrong input");
                    break;
            }

            //Display tree
            System.out.print("\nPre order: ");
            bst.preOrder();

            System.out.print("\nIn order: ");
            bst.inOrder();

            System.out.print("\nPost order: ");
            bst.postOrder();

            System.out.println("Do you wish to continue (type y or n)");
            ch = sc.next().charAt(0);
    }while(ch == 'Y' || ch == 'y');
}
}
