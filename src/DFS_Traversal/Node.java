package DFS_Traversal;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by shivangi on 3/26/17.
 */
public class Node {
    int data;
    boolean visited;
    List adjacentNodes = new LinkedList();

    Node(int data){
        this.data = data;
        this.visited = false;
    }

    public void addAdjacentNode(Node node){
        adjacentNodes.add(node);
        node.adjacentNodes.add(this);
    }
}
