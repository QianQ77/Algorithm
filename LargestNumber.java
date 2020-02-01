package main.java.leetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * Created by qiuqian on 8/17/17.
 */

public class LargestNumber {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }

        String[] strings = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strings[i] = String.valueOf(nums[i]);
        }

        Comparator<String> comparator = new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return (s2 + s1).compareTo(s1 + s2);
            }
        };

        Arrays.sort(strings, comparator);
        //error point
        if(strings[0].charAt(0) == '0'){
            return "0";
        }

        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < strings.length; i++){
            builder.append(strings[i]);
        }

        return builder.toString();
    }

}