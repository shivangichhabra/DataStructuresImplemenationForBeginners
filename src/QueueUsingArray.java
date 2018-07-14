import java.util.Arrays;
import java.util.NoSuchElementException;

/*
FIFO:First in First out
Enqueue at end
Dequeue from front
 */
public class QueueUsingArray<T> {

    int queue_capacity = 4;
    int current_size = 0;
    T[] array;
    int front,back;

    public QueueUsingArray(){
        array = (T[]) new Object[queue_capacity];
        front = 0;
        back = 0;
    }

    public void enqueue(T t){
        if(isFull())
            resize();
        
        array[back] = t;
        back = (back+1)%queue_capacity;
        current_size++;
    }

    public T dequeue(){
        if(isEmpty())
            throw new NoSuchElementException("Underflow Exception");

        current_size--;
        T item = array[front];
        front = (front+1)%queue_capacity;
        return item;
    }

    public void resize(){
        if(isFull()) {
            queue_capacity = queue_capacity * 2;
            T[] temp = (T[]) new Object[queue_capacity];
            for(int i=0; i<current_size; i++){
                temp[i] = array[(front+i)%array.length];
            }
            array = temp;
            front = 0;
            back = current_size;
        }
    }

    public boolean isFull(){
        return queue_capacity-1 == current_size;
    }

    public boolean isEmpty(){
        return current_size == 0;
    }

    public int size(){
        return current_size;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public static void main(String args[]){
        QueueUsingArray<Integer> q = new QueueUsingArray<Integer>();
        try {
            System.out.println(q.isEmpty());
            q.enqueue(1);
            q.enqueue(2);
            q.enqueue(3);
            q.enqueue(4);

            System.out.println(q.dequeue());
            q.enqueue(5);
            q.enqueue(6);
            q.enqueue(7);

            System.out.println(q.dequeue());
            System.out.println(q.dequeue());
            System.out.println(q.dequeue());
            System.out.println(q.dequeue());
            System.out.println(q.dequeue());
            System.out.println(q.dequeue());
            //System.out.println(q.dequeue());
            //System.out.println(q.dequeue());
            System.out.println(q);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
