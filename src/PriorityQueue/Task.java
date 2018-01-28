package PriorityQueue;

public class Task {

    String name;
    int priority;

    Task(String n, int p){
        name = n;
        priority = p;
    }

    public String toString(){
       return "Name: " +name +"\nPriority: "+ priority;
    }

}
