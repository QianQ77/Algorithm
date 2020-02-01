package main.java.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiuqian on 8/18/17.
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(candidate1 == nums[i]){
                count1++;
            }else if(candidate2 == nums[i]){
                count2++;
            }else if(count1 == 0){
                candidate1 = nums[i];
                count1++;
            }else if(count2 == 0){
                candidate2 = nums[i];
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(candidate1 == nums[i]){
                count1++;
            }else if(candidate2 == nums[i]){
                count2++;
            }
        }
        if(count1 > nums.length / 3){
            result.add(candidate1);
        }
        if(count2 > nums.length / 3){
            result.add(candidate2);
        }
        return result;
    }

    public static void main(String[] args){
        int[] array = {8,8,7,7,7};
        MajorityElementII majorityElementII = new MajorityElementII();
        majorityElementII.majorityElement(array);
    }
}
