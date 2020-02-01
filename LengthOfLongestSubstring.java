package main.java.leetCode;

/**
 * Created by qiuqian on 3/9/17.
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        if(s.length() == 0){
            return 0;
        }

        int start = 0;

        //remember the end
        for(int i = 0; i < s.length(); i++){
            if(i == 0){
                maxLength = 1;
                continue;
            }
            //subString is from start to i-1
            String subString = s.substring(start, i);
            int index = subString.lastIndexOf(s.charAt(i));
            if(index == -1){
                maxLength = Math.max(maxLength, i-start+1);

            }else{
                //remember to add start
                start = start + index + 1;
            }
        }

        return maxLength;

    }

    public static void main(String[] args){
        String s = "pwwkew";
        int length = LengthOfLongestSubstring.lengthOfLongestSubstring(s);
        System.out.print(length);
    }
}

