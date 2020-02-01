package main.java.leetCode;

/**
 * Created by qiuqian on 9/16/18.
 */
public class ExcelSheetColumnNumber {
    public static int titleToNumber(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            result = result * 26 + num;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
        System.out.println(Integer.MAX_VALUE);
    }
}
