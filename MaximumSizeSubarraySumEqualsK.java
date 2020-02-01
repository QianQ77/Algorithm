package main.java.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiuqian on 10/17/18.
 */
public class MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 0);
        int N = nums.length;
        int currSum = 0;
        for(int i = 1; i <= N; i++) {
            currSum += nums[i - 1];
            sumMap.put(currSum, i);
        }
        int result = 0;
        for(Map.Entry<Integer, Integer> entry : sumMap.entrySet()) {
            Integer targetIndex = sumMap.get(k + entry.getKey());
            if(targetIndex != null) {
                result = Math.max(result, Math.abs(targetIndex - entry.getValue()));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, -1, 5, -2, 3};
        MaximumSizeSubarraySumEqualsK test = new MaximumSizeSubarraySumEqualsK();
        System.out.println(test.maxSubArrayLen(nums, 3));
    }
}
