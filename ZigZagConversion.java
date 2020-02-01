package main.java.leetCode;

/**
 * Created by qiuqian on 3/13/17.
 */
public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        if(numRows <= 1){
            return s;
        }
        char[] chars = s.toCharArray();
        int length = s.length();
        StringBuilder[] builder = new StringBuilder[numRows];
        /**
         * remember to initialize
         */
        /**
         * In this way, after the for loop, all elements are still null in builder
         */
        /*for(StringBuilder b: builder){
            b = new StringBuilder();
        }*/
        for(int i = 0; i < numRows; i++){
            builder[i] = new StringBuilder();
        }

        int row = 0;
        int incre = 1;

        for(int i=0; i<length; i++){
            builder[row].append(chars[i]);
            if(row == 0){
                incre = 1;
            }
            if(row == numRows-1){
                incre = -1;
            }
            row += incre;
        }

        if(numRows > 1){
            for(int i = 1; i < numRows; i++){
                builder[0].append(builder[i]);
            }
        }
        return builder[0].toString();

    }

    public static void main(String[] args){
        String s = "ABCD";
        int rows = 2;
        String result = ZigZagConversion.convert(s, rows);
        System.out.println(result);
    }
}
