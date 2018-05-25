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
        TrieNode node = root;
        for(int i=0; i< word.length(); i++){
            char c = word.charAt(i);
            if(!node.containsKey(c)){
                node.put(c, new TrieNode());
            }
            node = node.get(c);
            node.incrementCount(c);
        }
        node.setEnd(true);
    }

    public boolean search(String word){
        TrieNode node = searchNode(word);
        return node != null && node.getEnd();
    }

    public TrieNode searchNode(String word){
        if(word.length() == 0 || word == null)
            return null;
        TrieNode node = root;
        for(int i=0; i< word.length(); i++) {
            char c = word.charAt(i);
            if(node.containsKey(c)){
                node = node.get(c);
            } else {
                return null;
            }
        }
        return node;
    }

    public void delete(String word){
        TrieNode node = root;
        if(!search(word)){
            System.out.println("Does not exist in Trie");
        }

        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(node.containsKey(c)){
                if(node.getCount(c) == 1) {
                    node.remove(c);
                    return;
                }
                node.decrementCount(c);
                node = node.get(c);
                node.setEnd(false);
            }

        }
    }

    public boolean startsWith(String prefix){
        return searchNode(prefix) != null;
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
            System.out.println("5. Exit");

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
                case 5:
                    System.exit(0);
                default:
                    System.out.println("wrong entry");
                    break;
            }
            System.out.println("Press y to continue !");
            input = sc.next().charAt(0);
        }while(input == 'y' || input == 'Y');
    }
}
