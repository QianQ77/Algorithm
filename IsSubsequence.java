package main.java.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by qiuqian on 9/21/17.
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (t == null || t.length() == 0) {
            return false;
        }
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(t.charAt(i), list);
            } else {
                ArrayList<Integer> list = map.get(t.charAt(i));
                list.add(i);
            }
        }

        int prevIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                return false;
            }
            ArrayList<Integer> list = map.get(s.charAt(i));
            int search = Collections.binarySearch(list, prevIndex);

            if (search < 0) {
                search = -search - 1;
            }
            if (search == list.size()) {
                return false;
            }
                //error: prevIndex = search + 1;
            prevIndex = list.get(search) + 1;
        }
        return true;
        }

    public static void main(String[] args) {

        String s = "acb";
        String t = "ahbgdc";
        IsSubsequence test = new IsSubsequence();
        System.out.println(test.isSubsequence(s, t));
        }

    }
