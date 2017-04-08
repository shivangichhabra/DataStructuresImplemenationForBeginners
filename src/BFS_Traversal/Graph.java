package BFS_Traversal;

import java.util.*;

/**
 * Created by shivangi on 3/26/17.
 */
public class Graph {

    private List nodes = new ArrayList();

    public void bfs(Node root){
        Queue q  = new LinkedList();
        q.add(root);
        root.visited = true;
        while(!q.isEmpty()){
            Node current = (Node) q.poll();
            System.out.println(current.data+ " ");
            while(!current.adjacentNodes.isEmpty()){
                Node adj = (Node)current.adjacentNodes.remove(0);
                if(!adj.visited){
                    adj.visited = true;
                    q.add(adj);
                }
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

        System.out.println("\n------------------BFS_Traversal-----------------\n");
        graph.bfs(root);
    }
}
