package main.java.leetCode;

/**
 * Created by qiuqian on 8/23/18.
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        boolean wordSpace = false;
        for(int i = s.length() - 1; i >= 0; i--) {
            //trailing space or continueing spaces between words
            if(s.charAt(i) == ' ' && ((builder.length() == 0) || wordSpace)) {
                continue;
            }
            if(s.charAt(i) == ' ' ) {
                wordSpace = true;
            } else {
                if(wordSpace) {
                    builder.append(' ');
                }
                builder.append(s.charAt(i));
                wordSpace = false;
            }
        }
        char[] chars = builder.toString().toCharArray();
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
        return new String(chars);

    }

    private void reverse(char[] chars, int start, int end) {
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
        ReverseWordsInAString test = new ReverseWordsInAString();
        System.out.println(test.reverseWords("the sky is blue"));
    }
}
