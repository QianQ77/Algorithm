package main.java.leetCode;

import java.util.*;

/**
 * Created by qiuqian on 11/1/18.
 */
public class GraphValidTree {
    public static boolean validTree(int n, int[][] edges) {
        int M = edges.length;
        if(M != n - 1) return false;
        Set<Integer>[] neighbors = new Set[n];
        for(int i = 0; i < n; i++) {
            neighbors[i] = new HashSet<>();
        }
        for(int[] edge : edges) {
            neighbors[edge[0]].add(edge[1]);
            neighbors[edge[1]].add(edge[0]);
        }
        int[] visited = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int node = queue.poll();
                visited[node] = 1;
                for(int neighbor : neighbors[node]) {
                    if(visited[neighbor] == 1) return false;
                    if(visited[neighbor] == 0) queue.offer(neighbor);
                }
                visited[node] = 2;
            }
        }
        for(int v : visited) {
            if(v == 0) return false;
        }

        return true;
    }
    /*
    public static boolean validTree(int n, int[][] edges) {
        int M = edges.length;
        if(M < n - 1 || M >= n) return false;
        List<Integer>[] neighbors = new List[n];
        //error point: cannot Arrays.fill(neighbors, new ArrayList<>());
        //in this way, all elements in this array are the same arraylist, change one would change all.
        for(int i = 0; i < n; i++) {
            neighbors[i] = new ArrayList<>();
        }
        for(int[] edge : edges) {
            if(edge[0] == edge[1]) return false;
            neighbors[edge[0]].add(edge[1]);
            neighbors[edge[1]].add(edge[0]);
        }
        int[] status = new int[n];
        for(int i = 0; i < n; i++) {
            if(findCircle(neighbors, -1, i, status)) return false;
        }
        return true;
    }
    public static boolean findCircle(List<Integer>[] neighbors, int prev, int node, int[] status) {
        if(status[node] == 2) return false;
        status[node] = 1;
        for(int neighbor : neighbors[node]) {
            if(status[neighbor] == 2 || neighbor == prev) {
                continue;
            }
            if(status[neighbor] == 1) return true;
            status[neighbor] = 1;
            if(findCircle(neighbors, node, neighbor, status)) return true;

        }
        status[node] = 2;
        return false;
    }
    */

    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{1,2}};
        System.out.println(validTree(4, edges));
    }
}
