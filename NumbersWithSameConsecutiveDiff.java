package main.java.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiuqian on 12/29/18.
 */
public class NumbersWithSameConsecutiveDiff {
    public static int[] numsSameConsecDiff(int N, int K) {

        List<Integer>[] nums = new List[10];
        //error point: should not Arrays.fill(nums, new ArrayList<>()); in this way all nums would share the same arrayList;
        for (int i = 0; i < 10; i++) {
            nums[i] = new ArrayList<>();
        }
        for (int i = 0; i < 10 - K; i++) {
            nums[i].add(i + K);
            //error point: should check if i == i + k, else if K == 0, then num[0] = {0, 0}; num[1] = {1, 1}; ...
            //would get wrong result when N = 2, K = 0;
            if (i + K != i) nums[i + K].add(i);
        }

        List<Integer> set = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            System.out.println(nums[i]);
            //error point: should not continue when (nums[i].size() == 0);
            //would output [0,1,2,3,6,7,8,9] when N = 1, K = 6
            //if(nums[i].size() == 0) continue;
            StringBuilder sb = new StringBuilder();
            dfs(sb, nums, i, set, N);
        }
        return set.stream().mapToInt(x -> x).toArray();
    }

    private static void dfs(StringBuilder sb, List<Integer>[] nums, int i, List<Integer> set, int N) {
        if (sb.length() == 0 && i == 0 && N > 1) return;
        sb.append(i);
        if (sb.length() == N) {
            set.add(Integer.valueOf(sb.toString()));
            return;
        }
        for (int num : nums[i]) {
            dfs(sb, nums, num, set, N);
            sb.setLength(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(NumbersWithSameConsecutiveDiff.numsSameConsecDiff(5, 0));
    }

}

