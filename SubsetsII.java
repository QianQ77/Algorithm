package main.java.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qiuqian on 12/10/17.
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);  //should sort
        helper(result, list, nums, 0);
        return result;
    }

    public void helper(ArrayList<List<Integer>> result, ArrayList<Integer> list, int[] nums, int index){
        result.add(new ArrayList<Integer>(list));
        for(int i = index; i < nums.length; i++){
            if( i != index && nums[i] == nums[i - 1]){  //pay attention.
                continue;
            }
            list.add(nums[i]);
            helper(result, list, nums, i + 1);
            list.remove(list.size() - 1);

        }
    }
}
