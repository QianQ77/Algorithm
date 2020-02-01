package main.java.leetCode;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by qiuqian on 3/14/17.
 *
 * remember to get length of array: strs.lengt
 * remember to initialize an array: String[] strs = { "" , "", "" };
 * remember to add i++ in the while loop.
 * remember to add if(equal) condition
 */
public class LongestCommonPrefix {


    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 1){
            return strs[0];
        }

        StringBuilder builder = new StringBuilder();
        Boolean equal = true;
        try{
            int i = 0;
            while(equal){
                HashSet<Character> set = new HashSet<>();
                for(String str:strs){
                    set.add(str.charAt(i));
                    if(set.size()>1){
                        equal = false;
                        break;
                    }
                }

                if(equal){
                    ArrayList<Character> list = new ArrayList<>(set);
                    builder.append(list.get(0));
                    i++;
                }
            }
        }catch(StringIndexOutOfBoundsException ex){

        }finally{
            return builder.toString();
        }
    }

    public String good_longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)    return "";
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
            i++;
        }
        return pre;
    }

    public static String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }
        StringBuilder builder = new StringBuilder();
        int index = 0;
        boolean equal = true;
        while(true) {
            for(int i = 1; i < strs.length; i++) {
                if(index == strs[i].length() || strs[i].charAt(index) != strs[0].charAt(index)) {
                    return builder.toString();
                }
            }
            builder.append(strs[0].charAt(index));
            index++;
        }

    }

    public static void main(String[] args){
        String[] strs = {"abcsd","abc","abcwetweg"};
        System.out.println(LongestCommonPrefix.longestCommonPrefix2(strs));

    }

}
