package main.java.leetCode;

import main.java.util.ListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qiuqian on 8/25/17.
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        int max_size = 0;
        int max_index = 0;
        int[] dp = new int[nums.length];

        int[] prev = new int[nums.length];
        //error point: cannot just set prev[0] = -1. should set all elements in prev to be -1;
        for(int i = 0; i < nums.length; i++){
            prev[i] = -1;
            dp[i] = 1;
        }

        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){

            for(int j = i - 1; j >= 0; j--){
                if(nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if(dp[i] > max_size){
                max_size = dp[i];
                max_index = i;
            }
        }
        for(int i = max_index; i >= 0; ){
            result.add(nums[i]);
            i = prev[i];
        }

        return result;
    }
    public static void main(String[] args){
        LargestDivisibleSubset test = new LargestDivisibleSubset();
        int[] nums = {2,3,8,9,27};
        List<Integer> result = test.largestDivisibleSubset(nums);
        ListUtil.printIntegerList(result);
    }
}
