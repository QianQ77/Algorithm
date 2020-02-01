package main.java.leetCode;

import java.util.Stack;

/**
 * Created by qiuqian on 8/14/18.
 */
public class BasicCalculator {
    public static int calculate(String s) {
        int result = 0;
        int currNumber = 0;
        Boolean prevIsNumber = false;
        Stack<Integer> numStack = new Stack<Integer>();
        Stack<Character> operatorStack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                continue;
            }
            if (c >= '0' && c <= '9'){
                //c is a digit
                //error point: must not add c directly
                currNumber = currNumber * 10 + (c - '0');
                prevIsNumber = true;
            } else if (c == '(') {
                operatorStack.push(c);

            } else {
                if(prevIsNumber) {
                    numStack.push(currNumber);
                    currNumber = 0;
                    prevIsNumber = false;
                }

                // error point: if only calculateHelper when ')', would make mistake when s = "#-*-&"
                // thus should call calculateHelper when encountering '+' or '-' too, to calculate from left to right
                calculateHelper(numStack, operatorStack);
                if (c != ')'){
                    operatorStack.push(c);
                } else {
                    if(!operatorStack.empty() && operatorStack.peek() == '(') {
                        operatorStack.pop();
                    }
                }
            }
        }
        //error point: should push currNumber to numStack
        if(prevIsNumber) {
            numStack.push(currNumber);
        }

        if(!operatorStack.empty()) {
            calculateHelper(numStack, operatorStack);
        }
        result = numStack.pop();
        return result;
    }

    public static void calculateHelper(Stack<Integer> numStack, Stack<Character> operatorStack) {
        while(!operatorStack.empty() && operatorStack.peek() != '(') {
            char operator = operatorStack.pop();
            Integer num2 = numStack.pop();
            Integer num1 = numStack.pop();
            if(operator == '+') {
                numStack.push(num1 + num2);
            }else {
                numStack.push(num1 - num2);
            }
        }
        // error point: should not pop '(' here
        /*
        if(!operatorStack.empty() && operatorStack.peek() == '(') {
            operatorStack.pop();
        }
        */
    }

    public static void main(String[] args) {
        String s = "(6+8) -13 - (24 - 12)";
        // error point: (1)
        String s2 = "2-4-(8+2-6+(8+4-(1)+8-10))";
        String s3 = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(BasicCalculator.calculate(s3));
    }
}
