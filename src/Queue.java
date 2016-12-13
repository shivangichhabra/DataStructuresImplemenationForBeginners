/**
 * Created by Shivangi on 12/11/2016.
 * QUEUE follows the FIFO rule
 */
public class Queue {

    Node front, back;

    public void enqueue(int value){
        Node current = new Node(value);
        if(front == null){
            front = current;
            back = front;
        }else{
            back.next = current;
            back = current;
        }
    }

    public void dequeue(){
        if(front != null){
            front = front.next;
        }else{
            System.out.println("Queue is already emtpy!");
        }
    }

    public void print(){
        if(front != null){
            Node current = front;
            while(current.next != null){
                System.out.print(current.data +"->");
                current = current.next;
            }
            System.out.print(current.data +"\n");
        }else{
            System.out.println("Queue is empty!");
        }
    }

    public static void main(String args[]){
        Queue q = new Queue();
        q.print();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.print();
        q.dequeue();
        q.print();
        q.enqueue(6);
        q.dequeue();
        q.print();
    }

    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }
}
