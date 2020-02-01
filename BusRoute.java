package main.java.leetCode;

import java.util.*;

/**
 * Created by qiuqian on 11/5/18.
 */
public class BusRoute {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        int rN = routes.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer>[] edges = new Set[rN];
        for(int i = 0; i < rN; i++) {
            for(int stop : routes[i]) {
                Set<Integer> route = map.getOrDefault(stop, new HashSet<>());
                if(route.size() != 0) {
                    for(int r : route) {
                        if(edges[r] == null) {
                            edges[r] = new HashSet<>();
                        }
                        edges[r].add(i);
                        if(edges[i] == null) {
                            edges[i] = new HashSet<>();
                        }
                        edges[i].add(r);
                    }
                }
                route.add(i);
                map.put(stop, route);
            }
        }
        Queue<Integer> queue = new LinkedList<>(map.get(S));
        Set<Integer> stopRoutes = map.get(T);
        int step = 0;
        boolean[] visited = new boolean[rN];
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                int r = queue.poll();
                size--;
                if(stopRoutes.contains(r)) return step + 1;
                visited[r] = true;
                for(int next : edges[r]) {
                    if(visited[next]) continue;
                    queue.offer(next);
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        BusRoute test = new BusRoute();
        int[][] routes = {{1,2,7},{3,6,7}};
        System.out.println(test.numBusesToDestination(routes, 1, 6));
    }
}
