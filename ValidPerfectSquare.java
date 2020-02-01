package main.java.leetCode;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

/**
 * Created by qiuqian on 8/16/18.
 */
public class ValidPerfectSquare {
    public static boolean isPerfectSquare(int num) {
        if(num == 1){
            return true;
        }
        int start = 1;
        int end = num;
        //optimizing end position
        /*
        if(num >= 100000000) end = num / 10000;
        else if(num >= 1000000) end = num / 1000;
        else if(num >= 10000) end = num / 100;
        else if(num >= 100) end = num / 10;
        */

        /* cost 1 ms; when 2147395600 output wrong answer: false         */
        while(start <= end) {
            int middle = start + (end - start) / 2;
            System.out.println(middle);
            //Error point: cannot square because it may overflow
            int mSquare = middle * middle;
            if(mSquare == num){
                return true;
            }else if (mSquare < num) {
                start = middle + 1;
            }else {
                end = middle - 1;
            }
        }

        /* cost 0 ms; when 2147395600 output right answer: true
        while(start <= end) {
            int middle = start + (end - start) / 2;
            if(num / middle == middle && num % middle == 0){
                System.out.println(middle);
                return true;
            }else if (num / middle > middle) {
                start = middle + 1;
            }else {
                end = middle - 1;
            }
        }
        */

        return false;
    }

    public static void main(String[] args){
        double start = System.currentTimeMillis();
        System.out.println(ValidPerfectSquare.isPerfectSquare(2147395600));
        double end = System.currentTimeMillis();
        System.out.println((end - start) + " ms");
    }
}
