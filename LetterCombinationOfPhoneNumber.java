package main.java.leetCode;

import main.java.util.ListUtil;

import java.util.*;

/**
 * Created by qiuqian on 12/22/17.
 */
public class LetterCombinationOfPhoneNumber {
    public List<String> letterCombinations2(String digits) {
        List<String> result = new LinkedList<>();
        if(digits.length() == 0){
            return result;
        }
        String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        result.add("");
        for(int i = 0; i < digits.length(); i++){
            char c = digits.charAt(i);

            String c_list = map[c - '0'];
            int size = result.size();
            for(int j = 0; j < size; j++){
                for(char k : c_list.toCharArray()){
                    result.add(result.get(0) + k);
                }                    result.remove(0);
            }
        }
        return result;
    }

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if(digits.length() == 0 || digits.contains("1")) {
            return result;
        }
        HashMap<Character, String> map = new HashMap<>();
        //map.put('1', "1");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        String string = "";
        dfs(map, result, string, digits, 0);
        return result;
    }

    private void dfs(HashMap<Character, String> map, List<String> result, String string, String digits, int index) {
        if(string.length() == digits.length()) {
            result.add(string);
            return;
        }
        for(int i = index; i < digits.length(); i++) {
            String digitMapValue = map.get(digits.charAt(i));
            for(int j = 0; j < digitMapValue.length(); j++) {
                string += String.valueOf(digitMapValue.charAt(j));
                dfs(map, result, string, digits, i + 1);
                string = string.substring(0, string.length() - 1);

            }
        }
    }

    public static void main(String[] args) {
        LetterCombinationOfPhoneNumber test = new LetterCombinationOfPhoneNumber();
        System.out.println(test.letterCombinations("23"));
    }
}
