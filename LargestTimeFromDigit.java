package main.java.leetCode;

import java.util.Arrays;

/**
 * Created by qiuqian on 12/2/18.
 */
public class LargestTimeFromDigit {
    public String largestTimeFromDigits(int[] A) {
        if(A == null || A.length == 0) return "";
        Arrays.sort(A);
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[4];
        if(dfs(A, visited, sb)) return sb.toString();
        return "";
    }

    private boolean dfs(int[] A, boolean[] visited, StringBuilder sb) {
        if(sb.length() == 5) {
            return true;
        }
        for(int i = 3; i >= 0; i--) {
            if(visited[i] || !valid(A, i, sb)) continue;
            visited[i] = true;
            sb.append(A[i]);
            if(sb.length() == 2) sb.append(":");
            if(dfs(A, visited, sb)) return true;
            visited[i] = false;
            if(sb.length() == 3) sb.setLength(sb.length() - 2);
            else sb.setLength(sb.length() - 1);
        }
        return false;
    }

    private boolean valid(int[] A, int i, StringBuilder sb) {
        int index = sb.length();
        if(index == 0) return A[i] <= 2;
        if(index == 1) {
            if(sb.charAt(0) != '2') return true;
            return A[i] <= 3;
        }
        if(index == 2) return A[i] <= 5;
        return true;
    }

    public static void main(String[] args) {
        LargestTimeFromDigit test = new LargestTimeFromDigit();
        int[] A = {1,2,3,4};
        System.out.println(test.largestTimeFromDigits(A));
    }


}
