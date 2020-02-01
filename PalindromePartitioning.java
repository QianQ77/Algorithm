package main.java.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiuqian on 12/20/17.
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        ArrayList<List<String>> result = new ArrayList<>();
        if(s == null || s.length() == 0){
            return result;
        }
        ArrayList<String> list = new ArrayList<>();
        helper(result, list, s, 0);
        return result;
    }

    public void helper(ArrayList<List<String>> result, ArrayList<String> list, String s, int index){
        String sub = "";
        for(int i = index; i < s.length(); i++){
            sub += s.charAt(i);
            if(isPalindrome(sub)){
                list.add(sub);
                helper(result, list, s, index + 1);
                list.remove(list.size() - 1);
            }

        }
    }

    public boolean isPalindrome(String s){
        int start = 0, end = s.length() - 1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
