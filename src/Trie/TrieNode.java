package Trie;

import java.util.*;

/**
 * Created by Shivangi on 8/3/2017.
 */
public class TrieNode {
    char content;
    boolean isLeaf;
    int count;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();

    TrieNode(){}

    TrieNode(char c){
        content = c;
        count = 0;
    }
}
