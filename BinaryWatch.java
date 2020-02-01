package main.java.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiuqian on 10/29/17.
 */
public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> results = new ArrayList<>();
        int[][] choices = new int[][] {{1, 0}, {2, 0}, {4, 0}, {8, 0}, {0, 1}, {0, 2}, {0, 4}, {0, 8}, {0, 16}, {0, 32}};
        nSum(num, choices, results, new int[]{0, 0}, 0);
        return results;
    }

    public void nSum(int num, int[][] choices, List<String> results, int[] currSum, int start) {
        if(!isValid(currSum)) {
            return;
        }
        if(num == 0) {
            results.add(toString(currSum));

            return;
        }

        for(int i = start; i < choices.length; i++) {
            currSum = add(currSum, choices[i]);
            //error point: should be (i + 1) not (start + 1)
            nSum(num - 1, choices, results, currSum, i + 1);
            currSum = substract(currSum, choices[i]);
        }
    }

    public int[] add(int[] pair1, int[] pair2) {
        return new int[]{pair1[0] + pair2[0], pair1[1] + pair2[1]};
    }
    public int[] substract(int[] pair1, int[] pair2) {
        return new int[]{pair1[0] - pair2[0], pair1[1] - pair2[1]};
    }

    public String toString(int[] pair) {
        if (pair[1] < 10) {
            return pair[0] + ":0" + pair[1];
        }
        return pair[0] + ":" + pair[1];
    }

    public boolean isValid(int[] pair) {
        if(pair.length != 2 || pair[0] > 11 || pair[1] > 59) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        BinaryWatch watch = new BinaryWatch();
        System.out.println(watch.readBinaryWatch(8));
    }
}
