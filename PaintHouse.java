package main.java.leetCode;

import java.util.Arrays;

/**
 * Created by qiuqian on 10/7/18.
 */
public class PaintHouse {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) {
            return 0;
        }

        //error point: cannot use int[] minCost = costs[0]; should use int[] minCost = Arrays.copyOf(costs[0], 3);
        int[] minCost = Arrays.copyOf(costs[0], 3);
        int[] newMinCost = new int[3];
        for(int i = 1; i < costs.length; i++) {
            newMinCost[0] = Math.min(minCost[1], minCost[2]) + costs[i][0];
            newMinCost[1] = Math.min(minCost[0], minCost[2]) + costs[i][1];
            newMinCost[2] = Math.min(minCost[1], minCost[0]) + costs[i][2];
            minCost = Arrays.copyOf(newMinCost, 3);;
        }
        return chooseMin(minCost[0], minCost[1], minCost[2]);
    }

    private int chooseMin(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static void main(String[] args) {
        PaintHouse test = new PaintHouse();
        int[][] costs = new int[][]{{3,5,3},{6,17,6},{7,13,18},{9,10,18}};
        System.out.println(test.minCost(costs));
    }
}
