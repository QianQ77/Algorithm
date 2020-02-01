package main.java.leetCode;

import java.util.PriorityQueue;

/**
 * Created by qiuqian on 1/13/19.
 */
public class ExamRoom {
    class Interval {
        int start;
        int end;
        int dist;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
            if (start == 0) {
                this.dist = end;
            } else if (end == N - 1) {
                this.dist = end - start;
            } else {
                this.dist = (end - start) / 2;
            }
        }
        @Override
        public boolean equals(Object o) {
            Interval that = (Interval) o;
            return this.start == that.start && this.end == that.end;
        }
    }

    PriorityQueue<Interval> heap;
    boolean[] seats;
    int N;

    public ExamRoom(int N) {
        this.N = N;
        heap = new PriorityQueue<>((
                i1, i2) -> i1.dist == i2.dist ? i1.start - i2.start: i2.dist - i1.dist);
        heap.add(new Interval(0, N - 1));
        seats = new boolean[N];
    }

    public int seat() {
        Interval interval = heap.poll();
        int seat;
        if (interval.start == 0) seat = 0;
        else if (interval.end == N - 1) seat = N - 1;
        else {
            seat = (interval.start + interval.end) >>> 1;
        }
        if (interval.start <= seat - 1) {
            heap.add(new Interval(interval.start, seat - 1));
        }
        if (interval.end >= seat + 1) {
            heap.add(new Interval(seat + 1, interval.end));
        }
        seats[seat] = true;
        return seat;
    }

    public void leave(int p) {
        int left = p - 1;
        while(left >= 0 && !seats[left]) {
            left--;
        }
        left++;
        int right = p + 1;
        while(right < N && !seats[right]) {
            right++;
        }
        right--;
        seats[p] = false;
        heap.remove(new Interval(left, p - 1));
        heap.remove(new Interval(p + 1, right));
        heap.add(new Interval(left, right));
    }

    public static void main(String[] args) {
        ExamRoom room = new ExamRoom(10);
        System.out.println(room.seat());
        System.out.println(room.seat());
        System.out.println(room.seat());
        room.leave(0);
        room.leave(4);
        System.out.println(room.seat());
        System.out.println(room.seat());
    }
}
