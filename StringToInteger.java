package main.java.leetCode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by qiuqian on 3/13/17.
 * Note to consider the string like "+1335";
 * Note to trim the string, consider the string like "    123";
 * Note to consider the string like "+1234aaa23";
 */
public class StringToInteger {

    public static int myAtoi(String str) {
        str = str.trim();
        if(!str.matches("[-|\\+]?[0-9]+[\\W|\\w]*")){
            return 0;
        }
        String reg = "[-|\\+]?[0-9]+";

        Matcher m = Pattern.compile(reg).matcher(str);
        if(!m.find()){
            return 0;
        }

        str = m.group();
        int sign = 1;

        int start = 0;
        int length = str.length();
        switch (str.charAt(0)){
            case '-':
                sign = -1;
                start++;
                if(length>11){
                    return Integer.MIN_VALUE;
                }
                if(length<11){
                    return Integer.valueOf(str);
                }
                break;
            case '+':
                start++;
                if(length>11){
                    return Integer.MAX_VALUE;
                }
                if(length<11){
                    return Integer.valueOf(str);
                }
                break;

            default:
                if(length>10){
                    return Integer.MAX_VALUE;
                }
                if(length<10){
                    return Integer.valueOf(str);
                }
        }


        int subValue = Integer.valueOf(str.substring(start, length-1));
        int lastDigit = Integer.valueOf(str.charAt(length-1)+"");

        int newResult = sign*(subValue*10 + lastDigit);
        if((newResult/sign)%10 !=lastDigit && (newResult/sign)/10 !=subValue){
            if(sign > 0){
                return Integer.MAX_VALUE;
            }else{
                return Integer.MIN_VALUE;
            }
        }else{
            return newResult;
        }

    }

    public static void main(String[] args){
        String s = "    +11191657170";
        System.out.println(StringToInteger.myAtoi(s));
    }

}
