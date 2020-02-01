package main.java.leetCode;

import java.util.*;

/**
 * Created by qiuqian on 10/11/17.
 */
public class ContainsDuplicateIII {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (k <= 0 || t < 0) {
            return false;
        }
        Map<Long, Long> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            long num = (long)nums[i] - Integer.MIN_VALUE;
            long bucket = num / ((long)t + 1);
            if(map.containsKey(bucket) ||
                    map.containsKey(bucket - 1) && num - map.get(bucket - 1) <= t ||
                    map.containsKey(bucket + 1) && map.get(bucket + 1) - num <= t){
                return true;
            }
            map.put(bucket, num);
            if(map.size() > k){
                long old_bucket = ((long)nums[i - k] - Integer.MIN_VALUE) / (t + 1);
                map.remove(old_bucket);
            }
        }
        return false;
    }
    /**
     * This method is wrong. Error when:
     [1,3,6,2]
     1
     2
     * @param nums
     * @param k
     * @param t
     * @return
     */

    public static boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (k <= 0 || t < 0) {
            return false;
        }
        HashMap<Integer, ArrayList<Integer>> valueToIndexes = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            ArrayList<Integer> indexes;
            if (valueToIndexes.containsKey(num)) {
                indexes = valueToIndexes.get(num);
            } else {
                indexes = new ArrayList<>();
                valueToIndexes.put(num, indexes);
            }
            indexes.add(i);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (Math.abs(nums[i] - nums[i + 1]) <= t) {

                ArrayList<Integer> list1 = valueToIndexes.get(nums[i]);
                if(nums[i] == nums[i + 1]){
                    for(int j = 0; j < list1.size() - 1; j++){
                        if(Math.abs(list1.get(j) - list1.get(j + 1)) <= k){
                            return true;
                        }
                    }
                }
                else{
                    // Error point: should consider nums[i] == nums[i+1]

                    ArrayList<Integer> list2 = valueToIndexes.get(nums[i + 1]);
                    int index1 = 0;
                    int index2 = 0;
                    while (index1 < list1.size() && index2 < list2.size()) {
                        if (Math.abs(list1.get(index1) - list2.get(index2)) <= k) {
                            return true;
                        } else {
                            if (list1.get(index1) < list2.get(index2)) {
                                index1++;
                            } else {
                                index2++;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {-1,2147483647};
        System.out.println(ContainsDuplicateIII.containsNearbyAlmostDuplicate(nums, 1, 2147483647));
    }

}
