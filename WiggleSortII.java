package main.java.leetCode;

/**
 * Created by qiuqian on 10/16/18.
 */
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length < 2) {
            return;
        }
        int N = nums.length;
        int medianIndex = findKthSmallest(nums, 0, N - 1, (N - 1) / 2);
        int sIndex = 0;
        int curr = 0;
        while(curr < N) {
            swap(nums, sIndex, curr);
            curr += 2;
            sIndex += 1;
        }
        int lIndex = N - 1;
        if(N % 2 == 0) {
            curr = N - 1;
        }else {
            curr = N - 2;
        }
        while(curr >= 0) {
            swap(nums, lIndex, curr);
            lIndex -= 1;
            curr -= 2;
        }
    }

    private int findKthSmallest(int[] nums, int start, int end, int k) {
        int left = start;
        int right = end;
        int index = start;
        int pivot = nums[start];
        while(index <= right) {
            if(nums[index] < pivot) {
                swap(nums, index++, left++);
            } else if(nums[index] > pivot) {
                swap(nums, index, right--);
            } else {
                index++;
            }
        }
        if(right == k) return right;
        if(right > k) return findKthSmallest(nums, start, right - 1, k);
        else return findKthSmallest(nums, right + 1, end, k);
    }

    private void swap(int[] nums, int i, int j) {
        int k = nums[i];
        nums[i] = nums[j];
        nums[j] = k;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,1,1,6,4};
        WiggleSortII test = new WiggleSortII();
        test.wiggleSort(nums);
    }
}
