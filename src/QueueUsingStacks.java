import java.util.*;
import java.util.Stack;

/**
 * Created by shivangi on 3/21/17.
 */
public class QueueUsingStacks {

    Stack<Integer> main = new Stack<Integer>();
    Stack<Integer> temp = new Stack<Integer>();

    public void enqueue(int data){
        main.push(data);
        /*
        if(!temp.isEmpty()) {
            main.push(data);
        } else {
            while(!main.isEmpty())
                temp.push(main.pop());

            main.push(data);
            while(!temp.isEmpty())
                main.push(temp.pop());
        }
        */
    }

    public void shiftStacks(){
        if(temp.empty()){
            while(!main.isEmpty())
                temp.push(main.pop());
        }
    }

    public void dequeue(){
        /*
        main.pop();
        */
        shiftStacks();
        temp.pop();
    }

    public int peek(){
        /*
        return !main.isEmpty() ? main.peek : 0;
         */
        shiftStacks();
        return !temp.isEmpty() ? temp.peek() : 0;
    }

    public boolean empty(){
        /*
        return main.isEmpty();
         */
        return main.isEmpty() && temp.isEmpty();
    }

    public static void main(String args[]){
        QueueUsingStacks qs = new QueueUsingStacks();
        qs.empty();
        qs.enqueue(1);
        System.out.println(qs.peek());
        qs.enqueue(2);
        qs.enqueue(3);
        qs.enqueue(4);
        System.out.println(qs.peek());
        qs.dequeue();
        System.out.println(qs.peek());
        qs.dequeue();
        System.out.println(qs.peek());
        qs.dequeue();
        System.out.println(qs.peek());
        System.out.println(qs.empty());
        qs.dequeue();
        System.out.println(qs.peek());
        System.out.println(qs.empty());
    }
}
