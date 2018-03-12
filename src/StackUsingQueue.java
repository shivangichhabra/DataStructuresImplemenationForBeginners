import java.net.Inet4Address;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shivangi on 3/11/2018.
 */
public class StackUsingQueue{

    Queue<Integer> queue = new LinkedList<>();

    public void push(int value){
        queue.add(value);
        int size = queue.size();
        while(size > 1){
            queue.add(queue.remove());
            size--;
        }
    }

    public void pop(){
       queue.remove();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public int peek(){
        return queue.size()> 0 ? queue.peek() : -1 ;
    }

    public static void main(String args[]){
        StackUsingQueue sq = new StackUsingQueue();
        System.out.println(sq.isEmpty());
        sq.push(1);
        sq.push(2);
        sq.push(3);

        System.out.println(sq.isEmpty());
        System.out.println(sq.peek());
        sq.pop();
        System.out.println(sq.peek());
        sq.pop();
        System.out.println(sq.peek());
        sq.pop();
        System.out.println(sq.peek());
        System.out.println(sq.isEmpty());
    }
}
