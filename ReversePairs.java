package main.java.leetCode;

import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * Created by qiuqian on 11/23/18.
 */
public class ReversePairs {
    public int reversePairs2(int[] nums) {
        if (nums == null) return 0;
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int l, int r) {
        if (l >= r) return 0;
        int m = (l + r) >> 1;
        int result = helper(nums, l, m) + helper(nums, m + 1, r);
        int pl = l;
        int pr = m + 1;
        int pc = m + 1;
        int[] merge = new int[r - l + 1];
        int pm = 0;
        while (pl <= m) {
            while (pc <= r && nums[pl] > (long)(2 * nums[pc])) pc++;
            result += pc - m - 1;

            while (pr <= r && nums[pl] >= nums[pr]) {
                merge[pm++] = nums[pr++];
            }
            merge[pm++] = nums[pl++];
        }

        while (pr <= r) {
            merge[pm++] = nums[pr++];
        }


        for (int i = 0; i < merge.length; i++) {
            nums[l + i] = merge[i];
        }
        return result;
    }

    public int reversePairs(int[] nums) {
        int result = 0;
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        HashMap<Integer, Integer> occurences = new HashMap<>();
        for(int num : nums) {
            Integer greater = set.isEmpty() ? null : set.first();
            Integer occurence = occurences.getOrDefault(num, 0);
            occurences.put(num, occurence + 1);
            while(greater != null && valid(greater, num)) {
                result++;
                greater = set.higher(greater);
            }
            set.add(num);
        }
        return result;
    }

    private boolean valid(int i, int j) {
        int divide = i / 2;
        if(divide < j) {
            return false;
        }
        return divide != j || i % 2 == 1;
    }

    public static void main(String[] args) {
        ReversePairs test = new ReversePairs();
        int[] nums = {1,3,2,3,1};
        System.out.println(test.reversePairs2(nums));
    }
}
