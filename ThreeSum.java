package main.java.leetCode;

import main.java.util.ListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qiuqian on 7/27/17.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            //error point: should check for duplicates
            if(i > 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }
            int low = i + 1;
            int high = nums.length - 1;
            while(low < high) {
                if(low > i + 1 && nums[low] == nums[low - 1]) {
                    low++;
                    continue;
                }
                if(high < nums.length - 1 && nums[high] == nums[high + 1]) {
                    high--;
                    continue;
                }
                int sum = nums[low] + nums[high] + nums[i];
                if(sum == 0) {
                    result.add(Arrays.asList(nums[low], nums[i], nums[high]));
                    low++;
                    high--;
                }else if (sum > 0) {
                    high--;
                }else {
                    low++;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum2(int[] numbers) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(numbers == null || numbers.length < 3){
            return result;
        }
        Arrays.sort(numbers);
        int n = numbers.length;
        for(int i = 0; i < n; i++){
            if(i == 0 || numbers[i] != numbers[i - 1]) {
                result.addAll(helper(numbers, i));
            }
        }
        return result;
    }

    public List<List<Integer>> helper(int[] numbers, int i) {
        List<List<Integer>> result = new ArrayList<>();
        int low = i + 1;
        int high = numbers.length - 1;
        while (low < high) {
            if(low > i + 1 && numbers[low] == numbers[low - 1]){
                low++;
                continue;
            }
            if(high < numbers.length - 1 && numbers[high] == numbers[high + 1]){
                high--;
                continue;
            }

            long sum = (long)numbers[low] + numbers[high] + numbers[i];
            if(sum > 0) {
                high--;
            }else if(sum < 0) {
                low++;
            }else{
                result.add(Arrays.asList(numbers[i], numbers[low], numbers[high]));
                high--;
                low++;

            }
        }
        return result;
    }


    public static void main(String[] args){
        ThreeSum threeSum = new ThreeSum();
        //int[] nums = {2,7,11,15,-9, -9, -3, -4};
        int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        Arrays.sort(nums);
        List<List<Integer>> result = threeSum.threeSum(nums);
        List<List<Integer>> result2 = threeSum.threeSum2(nums);
        System.out.println("result1: ");
        ListUtil.printIntegerListList(result);
        System.out.println("result2: ");
        ListUtil.printIntegerListList(result2);
    }
}
