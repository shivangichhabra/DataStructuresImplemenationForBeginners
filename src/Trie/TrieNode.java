package Trie;

import java.util.*;

/**
 * Created by Shivangi on 8/3/2017.
 */
public class TrieNode {

    private TrieNode links[];

    private final int R = 26;

    private boolean isEnd;

    public int count[];

    public TrieNode(){
        links = new TrieNode[R];
        count = new int[R];
    }

    public void setEnd(boolean isEnd){
        this.isEnd = isEnd;
    }

    public boolean getEnd(){
        return isEnd;
    }

    public int getCount(char ch){
        return count[ch-'a'];
    }

    public void incrementCount(char ch){
        count[ch-'a']++;
    }

    public void decrementCount(char ch){
        count[ch-'a']--;
    }

    public boolean containsKey(char ch){
        return links[ch-'a'] != null;
    }

    public TrieNode get(char ch){
        return links[ch-'a'];
    }

    public void put(char ch, TrieNode node){
        links[ch-'a'] = node;
    }

    public void remove(char ch){
        links[ch-'a'] = null;
    }
}
