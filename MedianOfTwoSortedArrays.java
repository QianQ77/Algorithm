package main.java.leetCode;

/**
 * Created by qiuqian on 10/22/18.
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int size = m + n;
        if(size % 2 == 0) {
            return (getkth(nums1, 0, nums2, 0, (size + 1) / 2) + getkth(nums2, 0, nums2, 0, size / 2 + 1)) / 2;
        }else {
            return getkth(nums1, 0, nums2, 0, (size + 1) / 2);
        }
    }
    private double getkth(int[] nums1, int s1, int[] nums2, int s2, int k) {
        if(s1 >= nums1.length) {
            return nums2[s2 + k - 1];
        }
        if(s2 >= nums2.length) {
            return nums1[s1 + k - 1];
        }
        if(k == 1) {
            return Math.min(nums1[0], nums2[0]);
        }
        int index1 = s1 + k / 2 - 1;
        int index2 = s2 + k / 2 - 1;
        int key1 = (index1 >= nums1.length) ? Integer.MAX_VALUE : nums1[index1];
        int key2 = (index2 >= nums2.length) ? Integer.MAX_VALUE : nums2[index2];
        if(key1 < key2) {
            // error point: k - k / 2, not k / 2,
            return getkth(nums1, index1 + 1, nums2, s2, k - k / 2);
        }else {
            return getkth(nums1, s1, nums2, index2 + 1, k - k / 2);
        }

    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays test = new MedianOfTwoSortedArrays();
        int[] nums1 = new int[] {1, 2};
        int[] nums2 = new int[] {3, 4};
        test.findMedianSortedArrays(nums1, nums2);
    }
}
