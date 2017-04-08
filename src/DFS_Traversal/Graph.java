package DFS_Traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by shivangi on 3/26/17.
 */
public class Graph {

    private List nodes = new LinkedList();

    /*
    Depth First Iterative Traversal
     */
    public void dfsI(Node node){
        Stack s = new Stack();
        s.push(node);
        node.visited = true;
        while(!s.isEmpty()){
            Node current = (Node) s.pop();
            System.out.println(current.data+ " ");
            while(!current.adjacentNodes.isEmpty()){
                Node adj = (Node) current.adjacentNodes.remove(0);
                if(!adj.visited){
                    adj.visited = true;
                    s.push(adj);
                }
            }
        }
    }

    /*
    Depth First Recursive Traversal
     */
    public void dfsR(Node node){
        if(!node.visited) {
            node.visited = true;
            System.out.println(node.data + "  ");
            while (!node.adjacentNodes.isEmpty()) {
                Node adj = (Node) node.adjacentNodes.remove(0);
                dfsR(adj);
            }
        }
    }

    public Node createGraph(){
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);
        Node i = new Node(9);
        Node j = new Node(10);

        nodes.add(a);
        nodes.add(b);
        nodes.add(c);
        nodes.add(d);
        nodes.add(e);
        nodes.add(f);
        nodes.add(g);
        nodes.add(h);
        nodes.add(i);
        nodes.add(j);

        a.addAdjacentNode(b);
        a.addAdjacentNode(c);
        a.addAdjacentNode(d);

        b.addAdjacentNode(e);
        b.addAdjacentNode(f);

        d.addAdjacentNode(g);
        d.addAdjacentNode(h);

        f.addAdjacentNode(i);

        g.addAdjacentNode(j);

        return a;
    }

    public static void main(String args[]){


        Graph graph = new Graph();
        Node root = graph.createGraph();

        System.out.println("\n------------------DFS_Traversal Recursive-----------------\n");
        graph.dfsR(root);

        //System.out.println("\n------------------DFS_Traversal Iterative-----------------\n");
        //graph.dfsI(root);
    }
}
