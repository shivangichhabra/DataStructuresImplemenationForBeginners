package Set;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shivangi on 5/18/2017.
 */
public class HashSet<T> {

    private HashMap<T, T> map;

    public HashSet(){
        map = new HashMap<T, T>();
    }

    public void add(T data){
        map.put(data, null);
    }

    public boolean remove(T data){
        return map.remove(data, null);
    }

    public boolean contains(T data){
        return map.containsKey(data);
    }

    public void display(){
        System.out.println("--------- START ---------");
        for(Map.Entry<T,T> entry: map.entrySet())
            System.out.println(entry.getKey());
        System.out.println("--------- END ---------");
    }

    public static void main(String args[]){
        HashSet<Integer> set = new HashSet<Integer>();
        set.display();

        set.add(10);
        set.add(40);
        set.add(100);
        set.add(200);
        set.add(10);
        set.add(200);

        set.display();

        System.out.println(set.remove(300));
        System.out.println(set.contains(300));

        System.out.println(set.contains(10));
        System.out.println(set.remove(10));
        System.out.println(set.contains(10));

        System.out.println(set.remove(100));
        System.out.println(set.contains(200));

        set.add(300);

        set.display();
    }
}
