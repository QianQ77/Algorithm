package main.java.leetCode;

import main.java.util.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;

/**
 * Created by qiuqian on 9/10/18.
 */
public class MergeIntervals {
    class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        intervals.sort(new IntervalComparator());
        int i = 0;
        List<Interval> result = new ArrayList<>();
        Interval curr = intervals.get(0);
        while(i < intervals.size() - 1) {
            Interval next = intervals.get(i + 1);
            if(next.start <= curr.end) {
                //error point: we should also compare curr.end and next.end to find the end of merged interval
                curr = new Interval(curr.start, Math.max(curr.end, next.end));
            } else {
                result.add(new Interval(curr.start, curr.end));
                curr = next;
            }
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        MergeIntervals test = new MergeIntervals();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        List<Interval> result = test.merge(intervals);
        for(Interval interval : result) {
            System.out.println(interval);
        }
    }
}
