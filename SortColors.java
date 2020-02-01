package main.java.leetCode;

/**
 * Created by qiuqian on 9/10/18.
 */
public class SortColors {
    public static void sortColors(int[] nums) {
        if(nums.length <= 1) {
            return;
        }
        int p0 = 0;
        int p2 = nums.length - 1;

        while(p0 < nums.length && nums[p0] == 0) {
            p0++;
        }
        while(p2 >= 0 && nums[p2] == 2) {
            p2--;
        }
        int i = p0;
        while(i <= p2) {
            if(nums[i] == 0) {
                swap(nums, i, p0);
                p0++;
                continue;
            }
            if(nums[i] == 2) {
                swap(nums, i, p2);
                p2--;
                continue;
            }
            if(nums[i] == 1) {
                i++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 0, 0};
        sortColors(nums);
        System.out.println(nums);
    }
}
