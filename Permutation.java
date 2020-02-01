package main.java.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiuqian on 12/10/17.
 */
public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        // write your code here

        ArrayList<List<Integer>> result = new ArrayList<>();
        /*
        if(nums == null || nums.length == 0){
            return result;
        }
        */
        ArrayList<Integer> list = new ArrayList<>();
        helper(nums, result, list);
        return result;
    }

    public void helper(int[] nums, List<List<Integer>> result, List<Integer> list) {
        if(list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!list.contains(nums[i])){
                list.add(nums[i]);
                helper(nums, result, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
