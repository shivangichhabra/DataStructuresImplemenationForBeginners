package LRU;

/**
 * Created by FS047207 on 5/20/2017.
 */
public class Node {

    int key;
    int value;
    Node prev;
    Node next;

    Node(int k, int v){
        this.key = k;
        this.value = v;
    }
}
