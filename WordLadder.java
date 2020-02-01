package main.java.leetCode;

import java.util.*;

/**
 * Created by qiuqian on 8/10/17.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        ArrayList<String> list = new ArrayList<>();
        list.add(beginWord);
        list.addAll(wordList);

        HashMap<String, ArrayList<String>> degree = generateDegree(list);
        HashMap<String, Boolean> isVisited = new HashMap<>();
        LinkedList<String> queue = new LinkedList<String>();

        queue.offer(list.get(0));
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            for(int i = 0; i < size; i++){
                String word = queue.pop();
                isVisited.put(word, true);
                ArrayList<String> neighbors = degree.get(word);
                for(String neighbor: neighbors){
                    if(neighbor.equals(endWord)){
                        return level;
                    }
                    if(!isVisited.containsKey(neighbor)){
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return 0;
    }

    public HashMap<String, ArrayList<String>> generateDegree(List<String> wordList){
        HashMap<String, ArrayList<String>> degree = new HashMap<>();
        for(int i = 0; i < wordList.size() - 1; i++){
            for(int j = i + 1; j < wordList.size(); j++){
                if(countDist(wordList.get(i), wordList.get(j)) == 1){
                    if(degree.containsKey(wordList.get(i))){
                        degree.get(wordList.get(i)).add(wordList.get(j));
                    }else{
                        ArrayList<String> neighbors = new ArrayList<String>();
                        neighbors.add(wordList.get(j));
                        degree.put(wordList.get(i), neighbors);
                    }

                    if(degree.containsKey(wordList.get(j))){
                        degree.get(wordList.get(j)).add(wordList.get(i));
                    }else{
                        ArrayList<String> neighbors = new ArrayList<String>();
                        neighbors.add(wordList.get(i));
                        degree.put(wordList.get(j), neighbors);
                    }
                }
            }
        }
        return degree;
    }

    public int countDist(String word1, String word2){
        int dist = 0;
        for(int i = 0; i < word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)){
                dist++;
            }
        }
        return dist;
    }
    public static void main(String[] args){
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        WordLadder wordLadder = new WordLadder();
        System.out.println(wordLadder.ladderLength(beginWord, endWord, wordList));
    }
}
