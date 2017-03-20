/**
 * Created by Shivangi  on 12/5/2016.
 */
public class LinkedList {

    class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

    Node head;
    Node tail;

    //insert value
    public void insertAtEnd(int value){
        Node current = new Node(value);
        if(head == null){
            head = current;
            tail = current;
        }else{
            tail.next = current;
            tail = current;
        }
    }

    //insert value at pos
    public void insert(int value, int pos){
        Node current = new Node(value);
        if (head != null && (pos-1) < size()) {
            Node temp = head;
            int i = 0;
            while (temp != null && i < pos - 2) {
                temp = temp.next;
                i++;
            }
            current.next = temp.next;
            temp.next = current;
        } else{
            System.out.println("Not enough elements in the list!");
        }
    }

    //insert at the front
    public void insertAtFront(int value){
        Node current = new Node(value);
        if(head == null){
            head = current;
            tail = current;
        }else{
            current.next = head;
            head = current;
            current.next = head.next;
        }
    }

    public int size(){
        int count = 0;
        Node temp = head;
        while(temp != null){
            count++ ;
            temp = temp.next;
        }
        return count;
    }

    //delete first element
    public void deleteFirst(){
        if(head != null){
            head = head.next;
        }else{
            System.out.println("List is already empty!");
        }
    }

    //delete last element
    public void deleteLast(){
        if(head != null){
            if(head.next != null) {
                Node temp = head;
                Node temp1 = head.next;
                while (temp1.next != null) {
                    temp1 = temp1.next;
                    temp = temp.next;
                }
                temp.next = null;
            }else{
                head = null;
            }
        }else{
            System.out.println("Node is already empty");
        }
    }

    //delete first occurence of a particular value
    public void deleteValue(int data){
        if(head == null){
            System.out.println("List is empty");
        }
        if(head.value == data){
            head = head.next;
            if(head == tail){
                tail = null;
            }
        }
        Node temp = head;
        while(temp.next != null){
            if(temp.next.value == data){
                if(temp.next == tail){
                    tail = null;
                }
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
    }

    //delete from a particular pos
    public void deletePos(int pos){
        if (head != null && (pos-1) < size()) {
            Node temp = head;
            int i = 0;
            while (temp != null && i < pos - 2) {
                temp = temp.next;
                i++;
            }
            temp.next = temp.next.next;
        } else {
            System.out.println("Not enough elements in the list!");
        }
    }

    //Reverse a linked list
    public void reverse(){
        Node prev = null;
        Node current = head;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void display(){
        if(head != null){
            Node current = head.next;
            System.out.print(head.value);
            while(current != null) {
                System.out.print("-->"+current.value);
                current = current.next;
            }
        }else{
            System.out.println("List is empty!");
        }
    }

    public void print(){
        if(head != null){
            Node current = head;
            while(current.next != null){
                System.out.print(current.value + "->");
                current = current.next;
            }
            System.out.print(current.value +"\n");
        }else{
            System.out.println("List is empty!");
        }
    }

    public static void main(String args[]){
        LinkedList l = new LinkedList();
        System.out.println(l.size());
        l.deleteFirst();
        l.print();
        l.insertAtEnd(2);
        l.insertAtEnd(3);
        l.insertAtEnd(4);
        l.insertAtFront(1);
        l.insertAtFront(0);
        l.insertAtEnd(5);
        l.insert(9,2);
        l.insert(6,8);
        l.insert(11, 3);
        l.insert(12,3);
        l.insert(13,8);
        l.insertAtEnd(13);
        l.print();
        System.out.println(l.size());
        l.deleteFirst();
        l.print();
        l.deleteLast();
        l.print();
        l.deletePos(2);
        l.print();
        l.reverse();
        l.print();
        l.display();
    }
}
