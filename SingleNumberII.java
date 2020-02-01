package main.java.leetCode;

import main.java.util.ListUtil;

import java.util.ArrayList;

/**
 * Created by qiuqian on 8/18/17.
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        if(nums == null || (nums.length < 4 && nums.length != 1)){
            return -1;
        }

        ArrayList<Integer> trits = numToTrits(nums[0]);

        for(int i = 1; i < nums.length; i++){
            ArrayList<Integer> result = XOR3(trits, numToTrits(nums[i]));
            trits = result;
        }
        return tritsToNum(trits);
    }

    public ArrayList<Integer> numToTrits(int num){
        ArrayList<Integer> result = new ArrayList<>();
        if(num == 0){
            result.add(0);
        }
        //error point: while(num > 0). we should also consider negative numbers
        boolean negative = (num < 0);
        if(negative){
            num = -num;
        }
        while(num != 0){
            result.add(num % 3);
            num /= 3;
        }
        if(negative){
            result.add(1);
        }else{
            result.add(0);
        }
        return result;
    }

    public ArrayList<Integer> numToTrits2(int num){
        ArrayList<Integer> result = new ArrayList<>();
        if(num == 0){
            result.add(0);
        }
        //error point: while(num > 0). we should also consider negative numbers
        boolean negative = (num < 0);
        boolean isMin = (num == Integer.MIN_VALUE);

        if(isMin){
            num = num + 1;
        }
        if(negative){
            //error point: if num = -2147483648, then -num > Integer.MAX_VALUE

            num = -num;
        }
        while(num != 0){
            result.add(num % 3);
            num /= 3;
        }
        if(isMin){
            result.add(0, result.get(0) + 1);
        }
        if(negative){
            result.add(1);
        }else{
            result.add(0);
        }
        return result;
    }


    public int tritsToNum(ArrayList<Integer> trits){
        int result = 0;

        if(trits.get(trits.size() - 1) == 1){
            for(int i = 0; i < trits.size() - 1; i++){
                result -= trits.get(i) * Math.pow(3, i);
            }
        }else{
            for(int i = 0; i < trits.size() - 1; i++){
                result += trits.get(i) * Math.pow(3, i);
            }
        }
        return result;
    }

    public ArrayList<Integer> XOR3(ArrayList<Integer> num1, ArrayList<Integer> num2){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < Math.max(num1.size(), num2.size()); i++){
            int trit1 = i < num1.size() ? num1.get(i) : 0;
            int trit2 = i < num2.size() ? num2.get(i) : 0;
            result.add((trit1 + trit2) % 3);
        }
        return result;
    }

    public static void main(String[] args){
        SingleNumberII single = new SingleNumberII();
        ListUtil.printIntegerList(single.numToTrits(4));
        ListUtil.printIntegerList(single.numToTrits(-4));
        ListUtil.printIntegerList(single.numToTrits(-2147483648));
        ListUtil.printIntegerList(single.numToTrits(-2147483647));
        ListUtil.printIntegerList(single.numToTrits2(-2147483647));
        System.out.println(single.tritsToNum(single.numToTrits2(-2147483648)));

        int[] test = {-401451,-177656,-2147483646,-473874,-814645,-2147483646,-852036,-457533,-401451,-473874,-401451,-216555,-917279,-457533,-852036,-457533,-177656,-2147483646,-177656,-917279,-473874,-852036,-917279,-216555,-814645,2147483645,-2147483648,2147483645,-814645,2147483645,-216555};

    }
}
