package main.java.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by qiuqian on 12/20/18.
 */
public class PrisonCellAfterNdays {
    public int[] prisonAfterNDays(int[] cells, int N) {

        ArrayList<int[]> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        list.add(cells);
        int loopStart = -1;
        int loopEnd = -1;
        while (N > 0) {
            int[] next = new int[8];
            cells = list.get(list.size() - 1);
            next[0] = 0;
            next[7] = 0;
            for (int i = 1; i < 7; i++) {
                next[i] = (cells[i - 1] == cells[i + 1])? 1 : 0;
            }

            if (!map.containsKey(Arrays.toString(next))) {
                map.put(Arrays.toString(next), list.size());
                list.add(next);
            } else {
                loopStart = map.get(Arrays.toString(next));
                loopEnd = list.size() - 1;
                break;
            }
            N--;
        }
        if (N == 0) return list.get(list.size() - 1);
        N = N % (loopEnd - loopStart + 1);

        return list.get(loopStart + N - 1);
    }

    public static void main(String[] args) {
        int[] cells = {1, 0, 0, 1, 0, 0, 0, 1};
        PrisonCellAfterNdays test = new PrisonCellAfterNdays();
        test.prisonAfterNDays(cells, 826);
    }
}
