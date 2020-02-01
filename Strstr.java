package main.java.leetCode;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

/**
 * Created by qiuqian on 11/6/18.
 */
public class Strstr {


    public int find(String s, String p) {
        if(s == null || p == null || s.length() < p.length()) return -1;

        int[] next = buildNext(p);
        int i = 0;
        int j = 0;
        while(j < p.length() && i < s.length()){
            if(s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else if(j == 0){
                i++;
            } else {
                j = next[j - 1];
            }
        }
        if(j == p.length()) {
            return i - j;
        }
        return -1;
    }

    private int[] buildNext(String p) {
        int[] next = new int[p.length()];
        int k = 0;
        for(int i = 1; i < next.length; i++) {
            while(k > 0 && p.charAt(k) != p.charAt(i)) {
                k = next[k - 1];
            }
            if(p.charAt(k) == p.charAt(i)) {
                k++;
            }
            next[i] = k;
        }
        return next;
    }

    public static void main(String[] args) {
        String s = "aabaaabaaac";
        String p = "aabaaac";
        System.out.println(new Strstr().find(s, p));
    }
}
