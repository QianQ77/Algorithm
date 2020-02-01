package main.java.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qiuqian on 12/10/17.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);

        getSubset(result, list, nums, 0);

        return result;
    }


    public void getSubset(List<List<Integer>> result, ArrayList<Integer> list, int[] nums, int position){

        result.add(new ArrayList<>(list));

        for(int i = position; i < nums.length; i++){
            list.add(nums[i]);

            getSubset(result, list, nums, i+1);

            list.remove(list.size() - 1);
        }

    }
}
