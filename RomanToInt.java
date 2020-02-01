package main.java.leetCode;

import java.util.HashMap;

/**
 * Created by qiuqian on 3/14/17.
 * Note when we have i+1 in the for loop;
 * the terminal condition should be i < s.length()-1;
 */
public class RomanToInt {
    public int romanToInt(String s) {
        if(s == null || s.length() ==0){
            return 0;
        }
        HashMap<Character, Integer> map = generateMap();
        char[] chars = s.toCharArray();
        int result = 0;
        for(int i = 0; i < s.length()-1 ; i++){
            int value = map.get(chars[i]);
            if(value >= map.get(chars[i+1])){
                result += value;
            }else{
                result -= value;
            }
        }
        result += map.get(chars[s.length()-1]);

        return result;
    }

    public HashMap<Character, Integer> generateMap(){
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        return map;
    }


}
