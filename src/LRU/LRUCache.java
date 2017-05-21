package LRU;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by FS047207 on 5/20/2017.
 */
public class LRUCache {

    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head = null;
    Node tail = null;

    public LRUCache(int capacity){
        this.capacity = capacity;
    }
    public int get(int key){
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            moveToHead(n);
            return n.value;
        }
        return -1;
    }

    public void set(int key, int value){
        if(map.containsKey(key)){
            Node x = map.get(key);
            //update
            x.value = value;
            remove(x);
            //move to head
            moveToHead(x);
        } else{
            //create new node
            Node n = new Node(key, value);
            if(map.size() >= capacity){
                //remove least recent node from end both list and map
                map.remove(tail.key);
                remove(tail);
            }
            moveToHead(n);
            map.put(key, n);
        }
    }

    private void remove(Node n){
        if(n.prev != null){
            n.prev.next = n.next;
        } else {
            head = n.next;
        }

        if(n.next != null){
            n.next.prev = n.prev;
        } else {
            tail = n.prev;
        }
    }

    private void moveToHead(Node n){
        n.next = head;
        n.prev = null;

        if(head != null){
            head.prev = n;
        }

        head = n;

        if(tail == null){
            tail = head;
        }
    }

    public void display(){
        System.out.println("------------- START -------------");
        for(Map.Entry<Integer,Node> entry : map.entrySet())
            System.out.println(entry.getKey() + "  " + entry.getValue().value);
        System.out.println("-------------  END  -------------");
    }

    public static void main(String args[]){
        LRUCache cache = new LRUCache(4);
        cache.display();
        cache.set(1, 1);
        System.out.println(cache.get(1));
        cache.set(2, 2);
        cache.set(3, 3);
        cache.set(4, 4);
        cache.display();
        cache.set(5, 5);
        cache.display();
        System.out.println(cache.get(1));
        System.out.println(cache.get(4));
        cache.set(6, 6);
        System.out.println(cache.get(6));
        cache.display();

    }
}
