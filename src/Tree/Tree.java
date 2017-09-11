package Tree;


/**
 * Created by Shivangi on 1/4/2017.
 */
public class Tree {

    private static Node root;

    public Tree(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public Node addRootNode(int data){
        root = new Node(data);
        return root;
    }

    public Node addChildNode(Node parent, int data){
        Node child = new Node(data);
        parent.getChildren().add(child);
        return child;
    }

    public void display(){
        display(root, " ");
    }

    public void display(Node node, String level){
        System.out.println(level + node.getData() );
        for(Node each: node.getChildren()){
            display(each, level+level);
        }
    }

    public int size(){
        return size(root);
    }

    public int size(Node node){
        if(node == null)
            return 0;
        else{
            int count = 1;
            for(Node each: node.getChildren()){
                count += size(each);
            }
            return count;
        }
    }

    public static void main(String args[]){
        Tree t = new Tree();
        System.out.println("Empty status:  " + t.isEmpty());

        root = t.addRootNode(1);

        Node child1 = t.addChildNode(root,2 );
        t.addChildNode(child1, 3);
        t.addChildNode(child1, 4);
        t.addChildNode(child1, 5);

        Node child2 = t.addChildNode(root, 6);
        t.addChildNode(child2, 1);
        t.addChildNode(child2, 2);
        t.addChildNode(child2, 3);
        t.addChildNode(child2, 4);
        t.addChildNode(child2, 5);
        t.addChildNode(child2, 6);
        t.addChildNode(child2, 7);

        Node child3 = t.addChildNode(root, 9);
        t.addChildNode(child3,10);

        Node child4 = t.addChildNode(root, 11);

        t.display();
        System.out.println("Empty status:  " + t.isEmpty());
        System.out.println("Total number of Node:  "+ t.size());
    }
}
