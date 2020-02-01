package main.java.leetCode;

import java.util.Arrays;

/**
 * Created by qiuqian on 8/18/17.
 */
public class BinarySearch {

    public int search(int t, int[] array){
        if(array == null || array.length == 0){
            return -1;
        }

        Arrays.sort(array);
        return helper(t, array, 0, array.length - 1);
    }

    public int helper(int t, int[] array, int low, int high){
        if(low <= high && low >= 0 && high < array.length){
            int middle = low + (high - low) / 2;
            if(array[middle] == t){
                return middle;
            }else if(array[middle] < t){
                return helper(t, array, middle + 1, high);
            }
            return helper(t, array, low, middle - 1);
        }
        return -1;
    }

    public static void main(String[] args){
        int[] array = {1, 2, 3, 5, 6, 8, 9};
        BinarySearch search = new BinarySearch();
        System.out.println(search.search(8, array));
    }
}
