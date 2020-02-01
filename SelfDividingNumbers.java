package main.java.leetCode;

import main.java.util.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiuqian on 11/18/17.
 */
public class SelfDividingNumbers {
    public static List<Integer> selfDividingNumbers(int left, int right) {

        ArrayList<Integer> result = new ArrayList<>();
        if(left <= 0 || left > right) {
            return result;
        }
        for(int i = left; i <= right; i++) {
            int j = i;
            while(j % 10 != 0) {
                if(i % (j % 10) != 0) {
                    break;
                }
                j = j / 10;
            }
            if(j == 0) {
                result.add(i);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = SelfDividingNumbers.selfDividingNumbers(1, 22);
        ListUtil.printIntegerList(result);
        String s = "s";
        s.toLowerCase();
        s.equalsIgnoreCase("s");
    }
}
