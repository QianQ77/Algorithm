package main.java.leetCode;

import java.util.Random;

/**
 * Created by qiuqian on 10/11/18.
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k);
    }


    private int findKthLargest(int[] nums, int start, int end, int k) {
        //4 ms
        int pivot = nums[start + new Random().nextInt(end + 1 - start)];
        //50 ms
        //int pivot = nums[start];
        int left = start;
        int right = end;
        int index = left;
        while(index <= right) {
            if(nums[index] > pivot) {
                swap(nums, index, left);
                index++;
                left++;
            } else if (nums[index] < pivot) {
                swap(nums, index, right);
                right--;
            } else {
                index++;
            }
        }
        if(k == left + 1) {
            return nums[left];
        } else if(k < left + 1) {
            return findKthLargest(nums, start, left - 1, k);
        } else {
            return findKthLargest(nums, left + 1, nums.length - 1, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int k = nums[i];
        nums[i] = nums[j];
        nums[j] = k;
    }

    public static void main(String[] args) {
        FindKthLargest test = new FindKthLargest();
        int[] a = new int[] {3,2,1,5,6,4};
        int k = 3;
        System.out.println(test.findKthLargest(a, k));
    }
}
