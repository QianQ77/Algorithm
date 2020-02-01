package main.java.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qiuqian on 8/23/18.
 */
public class EncodeAndDecodeStrings {

    public static String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for(String str : strs) {
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '/') {
                    builder.append('/');
                }
                builder.append(str.charAt(i));
            }
            builder.append("/#");
        }
        return builder.toString();
    }

    public static List<String> decode(String s) {
        List<String> strs = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        Boolean escape = false;
        for(int i = 0; i < s.length(); i++) {
            if(!escape && s.charAt(i) == '/') {
                escape = true;
            } else if (escape && s.charAt(i) == '#') {
                strs.add(builder.toString());
                builder = new StringBuilder();
                escape = false;
            } else {
                builder.append(s.charAt(i));
                escape = false;
            }

        }
        return strs;
    }

    public static String encode2(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        int length;
        for(String str : strs) {
            length = str.length();
            builder.append(length);
            builder.append('#');
            builder.append(str);
        }
        return builder.toString();
    }

    public static List<String> decode2(String s) {
        List<String> results = new ArrayList<>();
        int num = 0;
        int i = 0;
        while(i < s.length()) {
            if(s.charAt(i) == '#') {
                results.add(s.substring(i + 1, i + 1 + num));
                i = i + 1 + num;
                num = 0;
            } else {
                num = num * 10 + (s.charAt(i) - '0');
                i++;
            }
        }
        return results;
    }

    public static boolean validate(List<String> tests, List<String> results) {
        if(results.size() != tests.size()) {
            return false;
        }
        for(int i = 0; i < tests.size(); i++) {
            if(!tests.get(i).equals(results.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> tests = Arrays.asList(new String[]{
                "\\", "", "", "/#", "#", "///", "/#/#", "s/d#/e", "#s/d#/e#"});
        List<String> tests2 = Arrays.asList(new String[]{"", ""});
        System.out.println(validate(tests, decode(encode(tests))));
        System.out.println(validate(tests2, decode(encode(tests2))));

        System.out.println(validate(tests, decode2(encode2(tests))));
        System.out.println(validate(tests2, decode2(encode2(tests2))));

        List<String> tests3 = Arrays.asList(new String[]{});
        System.out.println(validate(tests3, decode(encode(tests3))));
        System.out.println(validate(tests3, decode2(encode2(tests3))));

        List<String> tests4 = Arrays.asList(new String[]{""});
        System.out.println(validate(tests4, decode(encode(tests4))));
        System.out.println(validate(tests4, decode2(encode2(tests4))));

    }
}
