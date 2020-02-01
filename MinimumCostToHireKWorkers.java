package main.java.leetCode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Created by qiuqian on 11/14/18.
 */
public class MinimumCostToHireKWorkers {
    class Worker{
        int index;
        int qlt;
        double wagePerQlt;
        public Worker(int i, int q, double w) {
            index = i;
            qlt = q;
            wagePerQlt = w;
        }
    }

    class wpqComparator implements Comparator<Worker> {
        @Override
        public int compare(Worker w1, Worker w2) {
            double diff = w1.wagePerQlt - w2.wagePerQlt;
            if(diff > 0) return 1;
            else if(diff < 0) return -1;
            return 0;
        }
    }

    class qltComparator implements Comparator<Worker> {
        @Override
        public int compare(Worker w1, Worker w2) {
            return w2.qlt - w1.qlt;
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        TreeSet<Worker> set = new TreeSet<>(new wpqComparator());
        for(int i = 0; i < quality.length; i++) {
            set.add(new Worker(i, quality[i], (double)wage[i] / quality[i]));
        }
        int qltCount = 0;
        PriorityQueue<Worker> maxHeap = new PriorityQueue<>(new qltComparator());
        double result = 0;
        for(int i = 0; i < K; i++) {
            Worker worker = set.pollFirst();
            maxHeap.add(worker);
            qltCount += worker.qlt;
            if(i == K - 1) {
                result = qltCount * worker.wagePerQlt;
            }
        }
        while(!set.isEmpty()) {
            Worker worker = set.pollFirst();
            if(worker.qlt >= maxHeap.peek().qlt) continue;
            qltCount -= maxHeap.poll().qlt;
            maxHeap.add(worker);
            qltCount += worker.qlt;
            result = Math.min(result, qltCount * worker.wagePerQlt);
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumCostToHireKWorkers test = new MinimumCostToHireKWorkers();
        int[] quality = {3,1,10,10,1};
        int[] wage = {4,8,2,2,7};
        System.out.println(test.mincostToHireWorkers(quality, wage, 3));
    }
}
