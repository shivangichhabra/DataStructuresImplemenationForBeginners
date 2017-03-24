import java.util.*;
import java.util.Stack;

/**
 * Created by shivangi on 3/21/17.
 */
public class QueueUsingStacks {

    Stack<Integer> main = new Stack<Integer>();
    Stack<Integer> temp = new Stack<Integer>();

    public void push(int data){
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

    public void pop(){
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
        qs.push(1);
        System.out.println(qs.peek());
        qs.push(2);
        qs.push(3);
        qs.push(4);
        System.out.println(qs.peek());
        qs.pop();
        System.out.println(qs.peek());
        qs.pop();
        qs.pop();
        System.out.println(qs.peek());
        System.out.println(qs.empty());
        qs.pop();
        System.out.println(qs.peek());
        System.out.println(qs.empty());
    }
}
