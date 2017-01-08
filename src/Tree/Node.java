package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shivangi on 1/4/2017.
 */
public class Node {
    private List<Node> children = new ArrayList<Node>();
    private int data;

    public Node(int data){
        this.data = data;
    }

    public List<Node> getChildren(){
        return children;
    }


    public int getData(){
        return data;
    }

    public void setData(int data){
        this.data = data;
    }
}

