package main.java.leetCode;

/**
 * Created by qiuqian on 8/13/18.
 */
public class IslandPerimeter {
    public static int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int gridNum = 0;
        int toDelete = 0;
        for(int i = 0; i < grid.length; i++) {
            int consecutive = 0;
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    gridNum++;
                    consecutive++;
                }
                /**
                 * error:
                 * else {
                    if(consecutive > 1) {
                    toDelete += consecutive - 1;
                    }
                    consecutive = 0;
                    }
                 */
                if (grid[i][j] == 0 || j == grid[0].length - 1){
                    if(consecutive > 1) {
                        toDelete += consecutive - 1;
                    }
                    consecutive = 0;
                }
            }
        }

        for(int j = 0; j < grid[0].length; j++) {
            int consecutive = 0;
            for(int i = 0; i < grid.length; i++) {
                if(grid[i][j] == 1) {
                    consecutive++;
                }
                if (grid[i][j] == 0 || i == grid.length - 1){
                    if(consecutive > 1) {
                        toDelete += consecutive - 1;
                    }
                    consecutive = 0;
                }
            }
        }

        return gridNum * 4 - toDelete * 2;
    }

    public static void main(String[] args) {
        int[][] grids = new int[][]{
                {0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}
        };
        System.out.println(IslandPerimeter.islandPerimeter(grids));
    }
}
