package main.java.leetCode;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by qiuqian on 1/31/18.
 */
public class FindIntersection {

    static Integer[] findIntersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new Integer[0];
        }

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        int[] nums;
        if(nums1.length > nums2.length) {
            nums = nums2;
        }else {
            nums = nums1;
        }


        for(int num : nums1) {
            set.add(num);
        }
        for(int num : nums2) {
            if(set.contains(num)) {
                result.add(num);
            }
        }
        return result.toArray(new Integer[result.size()]);

    }

    public static void main(String[] args){
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2,2};
        Integer[] result = FindIntersection.findIntersection(nums1, nums2);
        for(Integer num : result) {
            System.out.println(num);
        }
    }

}
