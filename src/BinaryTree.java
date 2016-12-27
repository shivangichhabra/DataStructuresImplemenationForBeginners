import java.util.Scanner;

/**
 * Created by Shivangi on 12/25/2016.
 */
public class BinaryTree {
    BinaryTreeNode root;

    public BinaryTree(){
        root = null;
    }

    /*
    Insert
     */
    public void insert(int data){
        root = insert(root, data);
    }

    public BinaryTreeNode insert(BinaryTreeNode node, int data){
        if(node == null){
            node = new BinaryTreeNode(data);
        } else {
            if(node.getLeft() == null){
                node.left = insert(node.left, data);
            } else{
                node.right = insert(node.right, data);
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

    public boolean search(BinaryTreeNode node, int data){
        if(node == null ){
            return false;
        } else {
            if (node.getData() == data) {
                return true;
            } else if (node.getLeft() != null) {
                return search(node.getLeft(), data);
            } else {
                return search(node.getRight(), data);
            }
        }
    }

    /*
    Count
     */
    public int count(){
        return count(root);
    }

    public int count(BinaryTreeNode node){
        if(node == null)
            return 0;
        else{
            int l = 1;
            l += count(node.getLeft());
            l += count(node.getRight());
            return l;
        }
    }

    /*
    Check empty
     */
    public boolean isEmpty(){
        return root == null;
    }

    /*
    Tree Traversal
     */

    public void preOrder(){
        preOrder(root);
    }

    public void preOrder(BinaryTreeNode node){
        if(node != null){
            System.out.print(node.getData() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void inOrder(){
        inOrder(root);
    }

    public void inOrder(BinaryTreeNode node){
        if(node != null){
            inOrder(node.getLeft());
            System.out.print(node.getData() + " ");
            inOrder(node.getRight());
        }
    }

    public void postOrder(){
        postOrder(root);
    }

    public void postOrder(BinaryTreeNode node){
        if(node != null){
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }

    /*
    Main method
     */
    public static void main(String args[]) {
        BinaryTree bt = new BinaryTree();
        Scanner sc = new Scanner(System.in);

        char ch;
        //do{
        while(true) {
            System.out.println("\nEnter your choice: \n1. Insert \n2. Search \n3. Count \n4. Check Empty");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\nEnter element to insert");
                    bt.insert(sc.nextInt());
                    break;

                case 2:
                    System.out.println("\nEnter element to search");
                    System.out.println(bt.search(sc.nextInt()));
                    break;

                case 3:
                    System.out.println("\nTotal number of nodes: " + bt.count());
                    break;

                case 4:
                    System.out.println("\nIs it empty? -> \"" + bt.isEmpty()+"\"");
                    break;

                default:
                    System.out.println("Wrong input");
                    break;
            }

            //Display tree
            System.out.print("\nPre order: ");
            bt.preOrder();

            System.out.print("\nIn order: ");
            bt.inOrder();

            System.out.print("\nPost order: ");
            bt.postOrder();

            //System.out.println("Do you wish to continue (type y or n)");
            //ch = sc.next().charAt(0);
        }
        //}while(ch == 'Y' || ch == 'y');
    }
}
