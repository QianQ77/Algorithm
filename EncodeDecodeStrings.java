package main.java.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qiuqian on 12/31/18.
 */
public class EncodeDecodeStrings {
    public String encode(List<String> strs) {
        StringBuffer out = new StringBuffer();
        for (String s : strs)
            out.append(s.replace("#", "##")).append(" # ");
        return out.toString();
    }

    public List<String> decode(String s) {
        List strs = new ArrayList();
        String[] array = s.split(" # ", -1);
        for (int i=0; i<array.length-1; ++i)
            strs.add(array[i].replace("##", "#"));
        return strs;
    }

    // Encodes a list of strings to a single string.
    public String encode2(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode2(String s) {
        List<String> list = new ArrayList<>();
        //error point: could not use s.split("##") because if s == "##", s.split("##").length == 0
        int length = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '#') {
                list.add(s.substring(i + 1, i + 1 + length));
                i = i + 1 + length;
                length = 0;
            } else {
                length = length * 10 + (s.charAt(i) - '0');
                i++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> strs = Arrays.asList("");
        EncodeDecodeStrings codec = new EncodeDecodeStrings();
        System.out.println(codec.decode(codec.encode(strs)));
        List<String> strs2 = Arrays.asList("nSM","Dsy");
        System.out.println(codec.decode2(codec.encode2(strs2)));
    }
}
