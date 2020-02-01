package main.java.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiuqian on 12/14/17.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(result, list, 1, n, k);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> list, int index, int n, int k) {
        if(list.size() == k) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i = index; i <= n; i++) {
            list.add(i);
            helper(result, list, i + 1, n, k);
            list.remove(list.size() - 1);
        }
    }
}
