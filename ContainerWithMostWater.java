package main.java.leetCode;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by qiuqian on 3/13/17.
 * Note to get array's length: height.length;
 * To find a min value in a set, use Collections.min(a collection);
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height.length < 2){
            return 0;
        }

        int maxArea = 0;

        int low = 0;
        int high = height.length - 1;
        while(low < high){
            int width = high - low;
            int h = 0;
            if(height[low] < height[high]){
                h = height[low];
                low++;
            }else{
                h = height[high];
                high--;
            }

            maxArea = Math.max(maxArea, width*h);
        }
        return maxArea;

    }

    public static void main(String[] args){

    }
}
