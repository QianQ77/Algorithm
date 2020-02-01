package main.java.leetCode;

import java.util.Arrays;

/**
 * Created by qiuqian on 12/22/19.
 */
public class EvenDigits {
    public int findNumbers(int[] nums) {
        return (int)Arrays.stream(nums).filter(num -> hasEvenDigits(num)).count();
    }

    boolean hasEvenDigits(int num) {
        if (num == 0) {
            return false;
        }
        int count = 0;
        num = Math.abs(num);
        while (num > 0) {
            num = num / 10;
            count++;
        }
        return count % 2 == 0;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, -2, -20, 10, 100};
        System.out.println(new EvenDigits().findNumbers(nums));
        System.out.println(Integer.valueOf(2500) == Integer.valueOf(2500));
    }
}
