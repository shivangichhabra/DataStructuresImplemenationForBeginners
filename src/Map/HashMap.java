package Map;

/**
 * Created by Shivangi on 5/18/2017.
 */
public class HashMap<K, V> {
    private int CAPACITY = 100;
    Entry<K, V>[] table;

    public HashMap(){
        table = new Entry[CAPACITY];
    }

    public int hash(K key){
        return Math.abs(key.hashCode()%CAPACITY);
    }

    public V get(K key){
        int hash = hash(key);
        if(table[hash] != null){
            Entry<K, V>  entry = table[hash];
            while(entry!= null){
                if(entry.getKey().equals(key))
                    return entry.getValue();
                entry = entry.getNext();
            }
        }
        return null;
    }

    public void put(K key, V value){
        if(key == null)
            return;

        int hash = hash(key);
        Entry<K, V> newEntry = new Entry<K, V>(key, value);

        if(table[hash] == null){
            table[hash] = newEntry;
        } else {
            while(table[hash] != null){
                Entry<K, V> temp = table[hash];
                if(temp.getKey().equals(key)) {
                    temp.setNext(newEntry);
                    return;
                }
            }
        }

    }

    public boolean remove(K key){
        int hash = hash(key);
        if(table[hash] != null){
            Entry<K, V> prev = null;
            Entry<K, V> current = table[hash];
            while(current != null){
                if(current.getKey().equals(key)){
                    if(prev == null){
                        table[hash]= table[hash].getNext();
                    } else {
                        prev.setNext(table[hash].getNext());
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean contains(K key){ //containskey
        int hash = hash(key);

        if(table[hash] != null){
            Entry<K, V> temp = table[hash];
            while(temp != null){
                if(temp.getKey().equals(key))
                    return true;
                temp = temp.getNext();
            }
        }
        return false;
    }

    public void display(){
        System.out.println("------ START -------");
        for(int i=0; i<CAPACITY; i++){
            if(table[i] != null) {
                Entry<K, V> entry = table[i];
                while(entry != null){
                    System.out.println(entry.getKey() + "  " + entry.getValue());
                    entry = entry.getNext();
                }
            }
        }
        System.out.println("------- END ---------");
    }

    public static void main(String args[]){
        HashMap<Integer, Integer> map = new HashMap();
        map.display();

        map.put(0,10);
        map.put(1,20);
        map.put(2,30);
        map.put(4,40);
        map.put(5,50);
        map.display();

        System.out.println(map.get(1));
        System.out.println(map.get(65));
        map.display();

        System.out.println(map.remove(2));
        System.out.println(map.remove(43));
        map.display();

        map.put(6,90);
        map.display();

    }
}
