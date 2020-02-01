package main.java.leetCode;

/**
 * Created by qiuqian on 10/19/17.
 */
public class SearchForARange {
    public static int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        int start;
        int end;
        int low = 0;
        int high = nums.length - 1;
        int mid;

        boolean find = false;
        int low_mem = low;
        int high_mem = high;
        while(low < high){
            mid = low + (high - low) / 2;
            if(nums[mid] > target){
                high = mid - 1;
            }else if (nums[mid] < target) {
                low = mid + 1;
            }else {
                if(!find){
                    low_mem = mid;
                    high_mem = high;
                    find = true;
                }
                high = mid;
            }
        }
        if (nums[low] == target){
            start = low;
        }else{
            return new int[]{-1, -1};
        }

        low = low_mem;
        high = high_mem;

        while(low < high){
            mid = low + (high - low) / 2;
            if(nums[mid] > target){
                high = mid - 1;
            }else if (nums[mid] < target) {
                low = mid + 1;
            }else {
                low = mid;
            }
        }

        return new int[]{start, low};

    }

    public static void main(String[] args) {
        int[] array = new int[]{5,7,7,8,8,8,8,8,8,10};

        int[] result = SearchForARange.searchRange(array, 8);
        for(int i : result){
            System.out.println(i);
        }
    }
}
