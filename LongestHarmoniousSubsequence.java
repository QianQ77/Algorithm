package main.java.leetCode;

import java.util.HashMap;

/**
 * Created by qiuqian on 8/19/17.
 */
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {

        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(int key : map.keySet()){
            if(map.containsKey(key + 1)){
                result = Math.max(result, map.get(key + 1) + map.get(key));
            }

        }
        return result;
    }

    public static void main(String[] args){
        int[] array = {2,2,2,2,2,3,1,-1,0,1,2,-1,0};
        LongestHarmoniousSubsequence test = new LongestHarmoniousSubsequence();
        System.out.println(test.findLHS(array));
    }
}
