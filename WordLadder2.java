package main.java.leetCode;

import java.util.*;

/**
 * Created by qiuqian on 7/13/19.
 */
public class WordLadder2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        ArrayList<String> list = new ArrayList<>();
        list.add(beginWord);
        list.addAll(wordList);
        HashMap<String, List<String>> neighbors = getNeighbors(list);
        HashSet<String> visited = new HashSet<>();
        int length = 1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String word = queue.poll();
                visited.add(beginWord);
                size--;
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    chars[i] = '*';
                    List<String> nexts = neighbors.get(String.valueOf(chars));
                    //error point: should check if nexts == null
                    if (nexts == null) continue;
                    for (String next : nexts) {
                        if (visited.contains(next)) continue;
                        if (next.equals(endWord)) return length + 1;
                        queue.offer(next);
                    }
                }

            }
            //error point: should add 1 to length
            length++;
        }
        return 0;
    }

    HashMap<String, List<String>> getNeighbors(List<String> wordList) {
        HashMap<String, List<String>> neighbors = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            char[] chars = wordList.get(i).toCharArray();
            for (int j = 0; j < chars.length; j++) {
                char c = chars[j];
                chars[j] = '*';
                List<String> words = neighbors.getOrDefault(String.valueOf(chars), new ArrayList<>());
                words.add(wordList.get(i));
                neighbors.put(String.valueOf(chars), words);
                chars[j] = c;
            }
        }
        return neighbors;
    }

    public static void main(String[] args){
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        WordLadder2 wordLadder = new WordLadder2();
        System.out.println(wordLadder.ladderLength(beginWord, endWord, wordList));
    }
}
