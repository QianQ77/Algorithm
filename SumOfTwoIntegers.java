package main.java.leetCode;

import java.util.ArrayList;

/**
 * Created by qiuqian on 8/24/17.
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        String sa = Integer.toBinaryString(a);
        String sb = Integer.toBinaryString(b);
        ArrayList<Integer> list = new ArrayList<>();
        int add = 0;
        int i = sa.length() - 1;
        int j = sb.length() - 1;
        for(; i >= 0 || j >= 0; i-- , j--){
            int int_a = (i >= 0) ? (sa.charAt(i) - '0') : 0;
            int int_b = (j >= 0) ? (sb.charAt(j) - '0') : 0;
            list.add(int_a ^ int_b ^ add);
            if((int_a & int_b) == 1 || (int_a & add) == 1 || (int_b & add) == 1){
                add = 1;
            }else{
                add = 0;
            }
        }
        if(add == 1){
            list.add(add);
        }
        int result = 0;
        int multi = 1;
        for(int k = 0; k < list.size(); k++){
            result += multi * list.get(k);
            multi *= 2;
        }
        return result;
    }
}
