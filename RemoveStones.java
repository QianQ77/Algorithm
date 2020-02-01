package main.java.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by qiuqian on 11/29/18.
 */
public class RemoveStones {
    public int removeStones2(int[][] stones) {
        if(stones == null || stones.length == 0) return 0;
        Set<Integer> visited = new HashSet<>();
        int result = 0;
        for(int[] stone : stones) {
            if(!visited.add(stone[0]) || !visited.add(10000 + stone[1])) {
                result++;
            }
        }

        return result;
    }

    public int removeStones(int[][] stones) {
        if(stones == null || stones.length == 0) return 0;
        HashMap<Integer, Set<Integer>> indices = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for(int[] stone : stones) {
            indices.putIfAbsent(stone[0], new HashSet<>());
            indices.get(stone[0]).add(10000 + stone[1]);
            indices.putIfAbsent(10000 + stone[1], new HashSet<>());
            indices.get(10000 + stone[1]).add(stone[0]);
        }
        int islands = 0;
        for(int[] stone : stones) {
            if(!visited.contains(stone[0])) {
                islands++;
                dfs(indices, visited, stone[0]);
            }
        }
        return stones.length - islands;
    }

    private void dfs(HashMap<Integer, Set<Integer>> indices, Set<Integer> visited, int index) {
        visited.add(index);
        for(int i : indices.get(index)) {
            if(!visited.contains(i)) {
                dfs(indices, visited, i);
            }
        }
    }

    public static void main(String[] args) {
        RemoveStones test = new RemoveStones();
        int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        test.removeStones2(stones);
    }
}
