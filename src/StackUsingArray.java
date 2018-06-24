import java.util.Arrays;

public class StackUsingArray {

    int[] array;
    int capacity;
    int top;
    int size;

    public StackUsingArray(int n){
        capacity = n;
        array = new int[capacity];
        size = 0;
        top = -1;
    }

    public void push(int data){
        if(isFull())
            return;

        top++;
        array[top] = data;
        size++;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Empty stack");
            return -1;
        }

        int item = array[top];
        top--;
        size--;


        if (size == 0){
            top = -1;
        }


        return item;
    }

    public int peek(){
        return !isEmpty() ? array[top] : -1 ;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public static void main(String args[]){
        StackUsingArray s = new StackUsingArray(5);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.pop();
        s.push(6);
        System.out.println(s.peek());
        System.out.println(s);
    }
}
