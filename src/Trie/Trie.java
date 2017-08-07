package Trie;


import java.util.*;

/**
 * Created by Shivangi on 8/3/2017.
 */
public class Trie {

    TrieNode root;

    Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        HashMap<Character, TrieNode> children = root.children;

        for(int i=0; i< word.length(); i++){
            char c = word.charAt(i);
            TrieNode t;
            if(children.containsKey(c)){
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c,t);
            }
            t.count++;
            children = t.children;
            if(i == word.length()-1)
                t.isLeaf = true;
        }
    }

    public boolean search(String word){
        TrieNode t = searchNode(word);
        if( t != null && t.isLeaf)
            return true;
        return false;
    }

    public TrieNode searchNode(String word){
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for(char c : word.toCharArray()){
            if(children.containsKey(c)){
                t = children.get(c);
                children = t.children;
            }else
                return null;
        }
        return t;
    }

    public void delete(String word){
        Map<Character, TrieNode> children = root.children;

       if(!search(word)) {
           System.out.println("Does not exist in Trie");
           return;
       }
        for(char c : word.toCharArray()){
            TrieNode t = null;
            if(children.containsKey(c)){
                t = children.get(c);
                if(t.count == 1){
                    children.remove(c);
                    return;
                }
                t.count--;
                children = t.children;
                t.isLeaf = false;
            }

        }
    }

    public boolean startsWith(String prefix){
        if(searchNode(prefix) != null)
            return true;
        return false;
    }

    public static  void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Trie t = new Trie();
        System.out.println("................ Tires ................");
        char input = 0;
        do{
            System.out.println("\n Options below:");
            System.out.println("1. insert");
            System.out.println("2. delete");
            System.out.println("3. search");
            System.out.println("4. startsWith");

            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter string to insert");
                    t.insert(sc.next());
                    break;
                case 2:
                    System.out.println("Enter string to delete");
                    try {
                        t.delete(sc.next());
                    } catch(Exception e){
                        e.getMessage();
                    }
                    break;
                case 3:
                    System.out.println("Enter string to search");
                    System.out.println(t.search(sc.next()));
                    break;
                case 4:
                    System.out.println("Enter prefix to look for");
                    System.out.println(t.startsWith(sc.next()));
                    break;
                default:
                    System.out.println("wrong entry");
                    break;
            }
            System.out.println("Press y to continue !");
            input = sc.next().charAt(0);
        }while(input == 'y' || input == 'Y');
    }
}
