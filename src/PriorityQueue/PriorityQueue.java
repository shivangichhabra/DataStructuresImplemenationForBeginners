package PriorityQueue;

import java.util.Scanner;

public class PriorityQueue {

    private Task[] heap;
    private int capacity, size;

    PriorityQueue(int capacity){
        this.capacity = capacity+1;
        heap = new Task[this.capacity];
        size = 0;
    }

    public void clear(){
        heap = new Task[capacity];
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == capacity-1;
    }

    public void insert(String name, int priority){
        if(isFull()){
            System.out.println("\nQueue is already full. Remove something to add new element");
            return;
        }
        Task newJob = new Task(name, priority);

        heap[++size] = newJob;
        int pos = size;

        while (pos != 1 && newJob.priority > heap[pos/2].priority){
            heap[pos] = heap[pos/2];
            pos /= 2;
        }
        heap[pos] = newJob;

    }

    public Task remove(){
        if(isEmpty()){
            System.out.println("All jobs removed!");
            return null;
        }

        Task top = heap[1];
        Task temp = heap[size--];

        int parent = 1, child = 2;
        while(child <= size){
            if(child <= size && heap[child].priority < heap[child+1].priority)
                child++;

            if(temp.priority >= heap[child].priority) {
                break;
            }

            heap[parent] = heap[child];
            parent = child;
            child *= 2;
        }

        heap[parent] = temp;

        return top;

    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Priority Queue Test\n");

        System.out.println("Enter size of priority queue ");
        PriorityQueue pq = new PriorityQueue(scan.nextInt() );

        char ch;
        /*  Perform Priority Queue operations */
        do
        {
            System.out.println("\nPriority Queue Operations\n");
            System.out.println("1. insert");
            System.out.println("2. remove");
            System.out.println("3. check empty");
            System.out.println("4. check full");
            System.out.println("5. clear");
            System.out.println("6. size");

            int choice = scan.nextInt();
            switch (choice)
            {
                case 1 :
                    System.out.println("Enter job name and priority");
                    pq.insert(scan.next(), scan.nextInt() );
                    break;
                case 2 :
                    System.out.println("\nJob removed \n\n"+ pq.remove());
                    break;
                case 3 :
                    System.out.println("\nEmpty Status : "+ pq.isEmpty() );
                    break;
                case 4 :
                    System.out.println("\nFull Status : "+ pq.isFull() );
                    break;
                case 5 :
                    System.out.println("\nPriority Queue Cleared");
                    pq.clear();
                    break;
                case 6 :
                    System.out.println("\nSize = "+ pq.size() );
                    break;
                default :
                    System.out.println("Wrong Entry \n ");
                    break;
            }

            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y');
    }
}
