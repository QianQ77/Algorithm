package main.java.leetCode;

/**
 * Created by qiuqian on 9/16/17.
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int sum = 0;
        int length = 0;
        int start = 0;
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(nums[i] >= s){
                return 1;
            }
            sum += nums[i];
            length++;
            while(sum >= s){
                sum -= nums[start];
                length--;
                start++;
                result = Integer.min(result, length + 1);

            }

        }
    //error: return result
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum test = new MinimumSizeSubarraySum();
        int[] array = new int[]{2,3,1,2,4,3};
        System.out.println(test.minSubArrayLen(7, array));
    }
}
