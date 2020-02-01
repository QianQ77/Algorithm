package main.java.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by qiuqian on 11/2/18.
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> greaters = new HashMap<>();
        for(int i = 0; i < words.length - 1; i++) {
            getAnOrder(greaters, words[i], words[i + 1]);
        }
        int[] visited = new int[26];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            if(greaters.containsKey((char)(i + 'a')) && visited[i] == 0) {
                if(!dfs(sb, i, visited, greaters)) return "";
            }
        }
        sb = sb.reverse();
        return sb.toString();

    }

    private boolean dfs(StringBuilder sb, int i, int[] visited, Map<Character, Set<Character>> greaters) {
        visited[i] = 1;
        char c = (char)(i + 'a');

        if(greaters.containsKey(c)) {
            for(char greater : greaters.get(c)) {
                if(visited[greater - 'a'] == 1) return false;
                if(visited[greater - 'a'] == 2) continue;
                if(!dfs(sb, greater - 'a', visited, greaters)) return false;
            }
        }
        sb.append(c);
        visited[i] = 2;
        return true;
    }

    private void getAnOrder(Map<Character, Set<Character>> greaters, String word1, String word2) {
        int i = 0;
        while(i < word1.length() && i < word2.length() && word1.charAt(i) == word2.charAt(i)) i++;
        if(i == word1.length() || i == word2.length()) return;
        Set<Character> set = greaters.getOrDefault(word1.charAt(i), new HashSet<>());
        set.add(word2.charAt(i));
        greaters.put(word1.charAt(i), set);
    }

    public static void main(String[] args) {
        String[] words = {"wrt","wrf","er","ett","rftt"};
        AlienDictionary test = new AlienDictionary();
        System.out.println(test.alienOrder(words));
    }
}
