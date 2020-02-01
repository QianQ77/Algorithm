package main.java.leetCode;

/**
 * Created by qiuqian on 7/27/17.
 */
public class MaximumAverageSubarray {
    public double findMaxAverage(int[] nums, int k) {
        if(nums.length < k){
            return 0;
        }
        int sum = 0;
        for(int j = 0; j < k; j++){
            sum += nums[j];
        }

        int max = sum;
        for(int i = k; i < nums.length; i++){
            sum = sum - nums[i - k] + nums[i];
            max = Math.max(sum, max);
        }
        return (double)max/k;     //Error Point: return max/k
    }
}
