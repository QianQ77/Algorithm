package main.java.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by qiuqian on 8/4/19.
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;
        int[] invalid = countInvalid(s);
        if (invalid[0] + invalid[1] == s.length()) {
            result.add("");
            return result;
        }
        int left = invalid[0];
        int right = invalid[1];
        dfs(result, new StringBuilder(), new LinkedList<Character>(), s, 0, left, right);
        return result;
    }

    private void dfs(List<String> list, StringBuilder sb, LinkedList<Character> stack, String s, int index, int left, int right) {
        if (left < 0 || right < 0) return;
        if (index == s.length()) {
            if (stack.size() == 0 && left == 0 && right == 0) {
                list.add(sb.toString());
            }
            return;
        }
        int length = sb.length();
        char c = s.charAt(index);
        if (c == ')') {
            dfs(list, sb, stack, s, index + 1, left, right - 1);
            if (stack.isEmpty()) return;
            stack.pop();
        } else if (c == '(') {
            dfs(list, sb, stack, s, index + 1, left - 1, right);
            stack.push(c);
        }

        sb.append(c);
        dfs(list, sb, stack, s, index + 1, left, right);
        sb.setLength(length);
    }

    private int[] countInvalid(String s) {
        int[] invalid = new int[2];
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() && c == ')') {
                invalid[1]++;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                stack.pop();
            }
        }
        invalid[0] = stack.size();
        return invalid;
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses test = new RemoveInvalidParentheses();
        List<String> result = test.removeInvalidParentheses("()())()");
        System.out.println(result);
    }
}
