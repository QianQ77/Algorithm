package main.java.leetCode;

import java.util.HashMap;

/**
 * Created by qiuqian on 7/27/17.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;

        for(int num : nums){
            if(!map.containsKey(num)){              //Error point: 如果没有这个判断，当重复出现数字时，会多加；

                int left = map.get(num - 1) == null ? 0 : map.get(num - 1);    //Error point:
                int right = map.get(num + 1) == null ? 0 : map.get(num + 1);    //Error point:
                int length = 1 + left + right;

                map.put(num - left, length);    //Error point;
                map.put(num + right, length);
                map.put(num, length);

                maxLength = Math.max(length, maxLength);
            }

        }
        return maxLength;
    }
}
