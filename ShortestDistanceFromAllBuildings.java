package main.java.leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qiuqian on 11/10/18.
 */
public class ShortestDistanceFromAllBuildings {
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        int M = grid.length;
        int N = grid[0].length;
        boolean[][] visited = new boolean[M][N];
        int[][] dists = new int[M][N];
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(grid[i][j] == 1) {
                    visited = new boolean[M][N];
                    if(!bfs(grid, visited, i, j, dists)) return -1;
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(dists[i][j] == 0) continue;
                result = Math.min(result, dists[i][j]);
            }
        }
        //should consider when no element is 0, e.g. [[1]]
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private boolean bfs(int[][] grid, boolean[][] visited, int i, int j, int[][] dists) {
        int M = grid.length;
        int N = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        int visitedCount = 1;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int dist = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int k = 0; k < size; k++) {
                int[] pos = queue.poll();
                for(int[] dir : dirs) {
                    int newi = pos[0] + dir[0];
                    int newj = pos[1] + dir[1];
                    if(newi < 0 || newi >= M || newj < 0 || newj >= N || visited[newi][newj]) continue;
                    visited[newi][newj] = true;
                    visitedCount++;
                    if(grid[newi][newj] == 0) {
                        queue.offer(new int[]{newi, newj});
                        dists[newi][newj] += dist;
                    }
                }
            }
            dist++;
        }
        System.out.println(i + "," + j);
        System.out.println(visitedCount);
        if(visitedCount != M * N) return false;
        return true;
    }

    public static void main(String[] args) {
        ShortestDistanceFromAllBuildings test = new ShortestDistanceFromAllBuildings();
        int[][] grid = {{1,1,1,1,1,0},{0,0,0,0,0,1},{0,1,1,0,0,1},{1,0,0,1,0,1},
                {1,0,1,0,0,1},{1,0,0,0,0,1},{0,1,1,1,1,0}};
        System.out.println(test.shortestDistance(grid));
    }
}
