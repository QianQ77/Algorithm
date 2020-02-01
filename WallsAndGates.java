package main.java.leetCode;

/**
 * Created by qiuqian on 11/10/18.
 */
public class WallsAndGates {
    static int INF = 2147483647;

    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        int M = rooms.length;
        int N = rooms[0].length;
        //error point: should use int instead of boolean,
        int[][] visited = new int[M][N];
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                //error point: should not skip when visited[i][j] == 2, for example,
                //when the input is [[INF,0],[INF,-1]], if we skip when when visited[i][j] == 2, would return [[1,0],[INF,-1]]
                //should return [[1,0],[2,-1]]
                //if(visited[i][j] == 2) continue;
                getDist(rooms, i, j, visited);
            }
        }
    }

    private void getDist(int[][] rooms, int i, int j, int[][] visited) {
        if(rooms[i][j] <= 0) {
            visited[i][j] = 2;
            return;
        }
        //should set visited here, not in the end of the method
        visited[i][j] = 1;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int newi;
        int newj;
        for(int[] dir : dirs) {
            newi = i + dir[0];
            newj = j + dir[1];
            if(newi < 0 || newi >= rooms.length || newj < 0 || newj >= rooms[0].length) continue;
            if(visited[newi][newj] == 0) getDist(rooms, newi, newj, visited);
            //error point: should consider: rooms[newi][newj] == INF
            //else INF + 1 < 0
            if(rooms[newi][newj] == -1 || rooms[newi][newj] == INF) continue;
            rooms[i][j] = Math.min(rooms[i][j], rooms[newi][newj] + 1);
        }
        visited[i][j] = 2;

    }

    public static void main(String[] args) {
        int[][] rooms = {{0,2147483647,-1,2147483647,2147483647,-1,-1,0,0,-1,2147483647,2147483647,0,-1,2147483647,
                2147483647,2147483647,2147483647,0,2147483647,0,-1,-1,-1,-1,2147483647,
                -1,-1,2147483647,2147483647,-1,-1,0,0,-1,0,0,0,2147483647,0,
                2147483647,-1,-1,0,-1,0,0,0,2147483647},{2147483647,0,-1,2147483647,0,-1,-1,-1,-1,0,0,2147483647,
                2147483647,-1,-1,2147483647,-1,-1,2147483647,2147483647,-1,0,-1,2147483647,0,
                2147483647,-1,2147483647,0,2147483647,0,2147483647,-1,2147483647,0,2147483647,
                -1,2147483647,0,2147483647,2147483647,0,-1,2147483647,-1,-1,-1,0,2147483647}};
        WallsAndGates test = new WallsAndGates();
        test.wallsAndGates(rooms);
        System.out.println(rooms);
    }
}
