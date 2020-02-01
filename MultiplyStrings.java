package main.java.leetCode;

/**
 * Created by qiuqian on 8/23/18.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if(num1.length() > num2.length()) {
            return multiplyHelper(num1, num2);
        }
        return multiplyHelper(num2, num1);
    }

    public String multiplyHelper(String longer, String shorter) {
        String result = new String();
        StringBuilder builder;
        int digitShorter = 0;
        int digitLonger = 0;
        int carry = 0;
        for(int i = shorter.length() - 1; i >= 0; i--) {
            digitShorter = shorter.charAt(i) - '0';
            builder = new StringBuilder();
            for(int j = longer.length() - 1; j >= 0; j--) {
                digitLonger = longer.charAt(j) - '0';
                carry += digitShorter * digitLonger;
                builder.append(carry % 10);
                carry = carry / 10;
            }
            if(carry != 0) {
                builder.append(carry);
            }
            builder = builder.reverse();
            for(int k = i; k < shorter.length() - 1; k++) {
                builder.append(0);
            }
            result = add(result, builder.toString());
        }
        return result;
    }

    public String add(String num1, String num2) {
        if(num1 == null || num1.length() == 0) return num2;
        if(num2 == null || num2.length() == 0) return num1;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        while(i >= 0 || j >= 0) {
            if(i >= 0) {
                carry += num1.charAt(i) - '0';
                i--;
            }
            if(j >= 0) {
                carry += num2.charAt(j) - '0';
                j--;
            }
            builder.append(carry % 10);
            carry = carry / 10;
        }
        if(carry != 0) {
            builder.append(carry);
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        MultiplyStrings test = new MultiplyStrings();
        System.out.println(test.multiply("123", "456"));
        System.out.println(123*456);
    }
}
