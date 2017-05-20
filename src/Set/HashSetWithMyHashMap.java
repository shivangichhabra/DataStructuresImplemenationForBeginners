package Set;


/**
 * Created by FS047207 on 5/19/2017.
 */
public class HashSetWithMyHashMap<T> {
    Map.HashMap<T, T> map;

    HashSetWithMyHashMap(){
        map = new Map.HashMap<T, T>();
    }

    public void add(T data){
        map.put(data, null);
    }

    public boolean remove(T data){
        return map.remove(data);
    }

    public boolean contains(T data){
        return map.contains(data);
    }

    private void display() {
        map.display();
    }

    public static void main(String args[]){
        HashSetWithMyHashMap set = new HashSetWithMyHashMap();
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
