package main.java.leetCode;

import java.util.ArrayList;

/**
 * Created by qiuqian on 3/13/17.
 */
public class ReverseInteger {
    public static int reverse(int x) {
        long result = 0;

        while(x != 0){
            result = result*10 + x % 10;
            x = x/10;

        }
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return 0;
        }else{
            return (int)result;
        }

    }

    public static int reverse2(int x) {
        int result = 0;

        while(x != 0){
            int newResult = result*10 + x % 10;
            /**
             * check overflow
             */
            if((newResult - x%10)/10 != result){
                return 0;
            }
            x = x/10;
            result = newResult;
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(ReverseInteger.reverse2(1534236469));

    }
}
