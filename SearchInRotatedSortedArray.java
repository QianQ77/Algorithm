package main.java.leetCode;

import java.util.Arrays;

/**
 * Created by qiuqian on 3/12/17.
 */
public class SearchInRotatedSortedArray {
    int goodsearch(int A[], int n, int target) {
        int lo=0,hi=n-1;
        // find the index of the smallest value using binary search.
        // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
        // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(A[mid]>A[hi]) lo=mid+1;
            else hi=mid;
        }
        // lo==hi is the index of the smallest value and also the number of places rotated.
        int rot=lo;
        lo=0;hi=n-1;
        // The usual binary search and accounting for rotation.
        while(lo<=hi){
            int mid=(lo+hi)/2;
            int realmid=(mid+rot)%n;
            if(A[realmid]==target)return realmid;
            if(A[realmid]<target)lo=mid+1;
            else hi=mid-1;
        }
        return -1;
    }


    public static int search(int[] nums, int target) {
        //note
        if(nums.length == 0){
            return -1;
        }
        //note
        if(nums.length == 1){
            if(nums[0] == target){
                return 0;
            }else{
                return -1;
            }
        }

        //nums[index] denotes the smallest integer
        int index = 0;
        for(int i = 1; i< nums.length; i++){
            if(nums[i] < nums[i-1]){
                index = i;
                break;
            }
        }
        int[] sorted = new int[nums.length];
        int j = 0;

        for(int i = index; i< nums.length; i++){
            sorted[j++] = nums[i];
        }
        for(int i = 0; i <index; i++){
            sorted[j++] = nums[i];
        }
        //int resultInSorted = binarySearch(sorted, target,0, nums.length);
        int resultInSorted = Arrays.binarySearch(sorted, target);

        //note!!!!!!!! Don't miss it.
        /**
         * Arrays.binarySearch(nums, target) could return -3; so we
         */
        if(resultInSorted < 0){
            return -1;
        }
        if(resultInSorted <= nums.length - index -1){
            return index+resultInSorted;
        }else{
            return resultInSorted - nums.length + index;
        }
    }

    public static int binarySearch(int[] nums, int target, int i, int j){
        if(j < i){
            return -1;
        }
        //note!! I was wrong: k = (j-i)/2
        /**
         * or mid = (low + high)/2
         */
        int k = i + (j-i)/2;
        if(nums[k] < target){
            return binarySearch(nums, target, k+1, j);
        }else if(nums[k] > target){
            return binarySearch(nums, target, i, k-1);
        }else{
            return k;
        }
    }

    public static void main(String[] args){
        int[] nums ={3, 1};
        System.out.println(search(nums, 1));
    }

}
