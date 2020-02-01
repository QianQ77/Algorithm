package main.java.leetCode;

import java.util.Stack;

/**
 * Created by qiuqian on 9/17/17.
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        if(s == null){
            return 0;
        }
        char[] chars = s.toCharArray();
        Stack<Integer> numStack = new Stack<>();
        int num = 0;
        char sign = '+';

        for(int i = 0; i < s.length(); i++){
            char c = chars[i];
            if(!isValid(c)){
                return 0;
            }
            // Or Character.isDigit(c)
            if(isNum(c)){
                // Error: numStack.push(Integer.valueOf(c)); because Integer.valueOf('6') = 54.
                num = num * 10 + c - '0';
            }
            if(isOper(c) || i == s.length() - 1){
                if(sign == '+'){
                    numStack.push(num);
                }else if (sign == '-'){
                    numStack.push(-num);
                }else if (sign == '*'){
                    int num1 = numStack.pop();
                    numStack.push(num * num1);
                }else{
                    int num1 = numStack.pop();
                    numStack.push(num1 / num);
                }
                sign = c;
                num = 0;
            }
        }
        int result = 0;
        while(!numStack.isEmpty()){
            result += numStack.pop();
        }
        return result;
    }

    boolean isValid(char c){
        return isNum(c) || isOper(c) || c == ' ';
    }

    boolean isNum(char c){
        //Error: return c >= '1' && c <= '9'
        return c >= '0' && c <= '9';
    }


    boolean isOper(char c){
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static void main(String[] args) {
        BasicCalculatorII test = new BasicCalculatorII();

        System.out.println(test.calculate("3  +  5 / 2"));
    }
}
