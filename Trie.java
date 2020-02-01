package main.java.leetCode;

import java.util.HashMap;

/**
 * Created by qiuqian on 8/17/17.
 */
public class Trie {

    boolean flag;
    HashMap<Character, Trie> map;

    /** Initialize your data structure here. */
    public Trie() {
        flag = false;
        map = new HashMap<>();
    }

    public Trie(boolean flag) {
        this.flag = flag;
        map = new HashMap<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        HashMap<Character, Trie> currentMap = map;
        for(int i = 0; i < word.length(); i++){

            if(currentMap.size() == 0 || !currentMap.containsKey(word.charAt(i))){
                Trie newTrie = new Trie(i == word.length() - 1);
                currentMap.put(word.charAt(i), newTrie);
                currentMap = newTrie.map;
            }else{
                //error point
                if(i == word.length() - 1){
                    currentMap.get(word.charAt(i)).flag = true;
                }
                currentMap = currentMap.get(word.charAt(i)).map;
            }

        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        HashMap<Character, Trie> currentMap = map;
        for(int i = 0; i < word.length(); i++){
            if(currentMap.size() == 0 || !currentMap.containsKey(word.charAt(i))){
                return false;
            }

            if(i == word.length() - 1 && currentMap.get(word.charAt(i)).flag){
                return true;
            }
            currentMap = currentMap.get(word.charAt(i)).map;
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        HashMap<Character, Trie> currentMap = map;
        for(int i = 0; i < prefix.length(); i++){
            if(currentMap.size() == 0 || !currentMap.containsKey(prefix.charAt(i))){
                return false;
            }
            currentMap = currentMap.get(prefix.charAt(i)).map;
        }
        return true;
    }

    public static void main(String[] args){
        Trie obj = new Trie();
        obj.insert("ab");
        boolean param_2 = obj.search("ab");
        boolean param_3 = obj.startsWith("ab");
        System.out.println("search ab:" + param_2);
        System.out.println("startsWith ab:" + param_3);
    }
}
