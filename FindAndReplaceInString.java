package main.java.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by qiuqian on 1/7/19.
 */
public class FindAndReplaceInString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        if (S == null || S.length() == 0) return S;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < indexes.length; i++) {
            list.add(new int[]{indexes[i], i});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (int[] pair : list) {
            int index = pair[0];
            String source = sources[pair[1]];
            String target = targets[pair[1]];
            if (S.substring(index, index + source.length()).equals(source)) {
                S = S.substring(0, index) + target + S.substring(index + source.length());
            }
        }
        return S;
    }
}
