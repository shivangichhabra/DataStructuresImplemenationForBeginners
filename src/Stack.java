/**
 * Created by Shivangi on 12/11/2016.
 * STACK follows the LIFO rule
 */
public class Stack {

    Node Top;

    //pushes the element to the top
    public void push(int value){
        Node current = new Node(value);
        if(Top == null){
            Top = current;
        }else{
            current.next = Top;
            Top = current;
        }
    }

    //pops element from top
    public void pop(){
        if(Top != null){
            Top = Top.next;
        }else{
            System.out.println("Stack is already empty");
        }
    }

    //displays
    public void print(){
        if(Top != null){
            Node current = Top;
            while(current.next != null){
                System.out.print(current.data + "->");
                current = current.next;
            }
            System.out.print(current.data +"\n");
        }else{
            System.out.println("Stack is empty!");
        }
    }

    public static void main(String args[]){
        Stack s = new Stack();
        s.push(0);
        s.print();
        s.pop();
        s.push(1);
        s.print();
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.print();
        s.pop();
        s.pop();
        s.print();
    }

    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }
}
