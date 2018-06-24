import java.util.Arrays;

public class QueueUsingArray {

    int[] array;
    int size;
    int head, tail;
    int capacity;

    public QueueUsingArray(int n){
        capacity = n;
        array = new int[capacity];
        head = -1;
        tail = -1;

    }

    public void enqueue(int data){
        if(isFull())
            return;
        tail = (tail+1)%capacity;
        array[tail] = data;
        if(head == -1)
            head = tail;
        size++;
    }

    public int dequeue(){
        if(isEmpty()) {
            System.out.println("Empty queue");
            return -1;
        }
        int item = array[head];
        size--;
        head = (head+1)%capacity;

        if(size == 0){
            head = -1;
            tail = -1;
        }
        return item;
    }

    public int peek(){
        return !isEmpty() ? array[head] : -1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public static void main(String args[]){
        QueueUsingArray q = new QueueUsingArray(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.dequeue();
        q.enqueue(6);
        System.out.println(q.peek());
        System.out.println(q);

    }
}
