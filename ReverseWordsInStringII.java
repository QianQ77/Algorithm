package main.java.leetCode;

/**
 * Created by qiuqian on 8/23/18.
 */
public class ReverseWordsInStringII {

    public String reverse(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == ' ') {
                reverse(chars, start, end);
                start = i + 1;
                end = i + 1;
            } else {
                end = i;
            }
        }
        reverse(chars, start, end);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    public void reverse(char[] chars, int start, int end) {
        char temp;
        while(start < end) {
            temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ReverseWordsInStringII test = new ReverseWordsInStringII();
        String s = "test a case.";
        System.out.println(test.reverse(s).equals("case. a test"));

    }
}
