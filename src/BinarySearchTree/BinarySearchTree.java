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
    Delete a node with value k
     */
    public void delete(int k){
        if(isEmpty())
            System.out.println("Tree is already empty!");
        else if(search(k) == false)
            System.out.println("No such value in the given tree.");
        else{
            root = delete(root, k);
            System.out.println(k + " is deleted.");
        }
    }

    public BSTNode delete(BSTNode node, int data){
        if(node == null)
            return null;
        else if (data < node.getData())
            node.setLeft(delete(node.getLeft(), data));
        else if (data > node.getData())
            node.setRight(delete(node.getRight(), data));
        else{
            //case 1: no child
            if(node.getLeft() == null && node.getRight() == null)
                return null;
                //case 2: one child
            else if(node.getLeft() == null){
                return node.getRight();
            }
            else if(node.getRight() == null){
                return node.getLeft();
            }
            //case 3: two children
            else{
                //Method 1
                node.setData(findRightMin(node.getRight()));
                node.setRight(delete(node.getRight(), node.getData()));

//                //Method 2
//                node.setData(findLeftMax(node.getLeft()));
//                node.setLeft(delete(node.getLeft(), node.getData()));
            }
        }
        return node;
    }

    /*
    Finds minimum in right subtree
     */
    int findRightMin(BSTNode node){
        while(node.getLeft() != null) {
            node = node.getLeft();
        }
        return node.getData();
    }

    /*
    Finds maximum in left subtree
     */
    int findLeftMax(BSTNode node){
        while(node.getRight() != null){
            node = node.getRight();
        }
        return node.getData();
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
    Tree Traversal
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

    /*
    Level Order Traversal
     */
    public void printLevelOrder(){
        int h = height();
        for(int i = 0; i<= h ; i++ )
            printGivenLevel(root, i);
    }

    public void printGivenLevel(BSTNode node, int level){
        if(node == null)
            return;
        if(level == 0)
            System.out.print(node.getData() + " ");
        else {
            printGivenLevel(node.getLeft(), level-1);
            printGivenLevel(node.getRight(), level-1);
        }
    }

    /*
    main
     */
    public static void main(String args[]){
        BinarySearchTree bst = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);

        char ch;
        do{
            System.out.println("\nEnter your choice: \n1. Insert \n2. Search \n3. Delete  \n4. Count \n5. Check Empty \n6. Height");
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
                    System.out.println("\nEnter element to delete");
                    bst.delete(sc.nextInt());
                    break;
                case 4:
                    System.out.println("\nTotal number of nodes: " + bst.count());
                    break;

                case 5:
                    System.out.println("\nIs it empty? -> \"" + bst.isEmpty()+"\"");
                    break;

                case 6:
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

            System.out.print("\nLevel Order Traversal: ");
            bst.printLevelOrder();

            System.out.println("\nDo you wish to continue (type y or n)");
            ch = sc.next().charAt(0);
        }while(ch == 'Y' || ch == 'y');
    }
}
