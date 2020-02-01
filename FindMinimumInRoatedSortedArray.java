package main.java.leetCode;

/**
 * Created by qiuqian on 8/23/17.
 */
public class FindMinimumInRoatedSortedArray {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }
    public int findMin(int[] nums, int start, int end){
        if(start == end){
            return nums[start];
        }
        int medium = start + (end - start) / 2;
        if(nums[medium] < nums[end]){
            return findMin(nums, start, medium);
        }
        //error point: return findMin(nums, medium + 1, end);
        return findMin(nums, medium + 1, end);


    }

    public static void main(String[] args){
        int[] array = {5,6,8,1,2};
        FindMinimumInRoatedSortedArray test = new FindMinimumInRoatedSortedArray();
        System.out.println(test.findMin(array));
    }
}
