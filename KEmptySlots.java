package main.java.leetCode;

/**
 * Created by qiuqian on 11/23/18.
 */
public class KEmptySlots {
    public static int kEmptySlots(int[] flowers, int k) {
        int N = flowers.length;
        int result = -1;
        if(k < 0) return result;
        int[] days = new int[N];
        for(int i = 0; i < N; i++) {
            days[flowers[i] - 1] = i;
        }
        System.out.println("days: ");
        for(int i = 0; i < N; i++) {
            System.out.print(days[i] + ", ");
        }
        int i = 0;
        while(i < N - k - 1) {
            int j = 1;
            while(j <= k) {
                if(days[i + j] < days[i] || days[i + j] < days[i + k + 1]) {
                    i = i + j;
                    break;
                }else {
                    j++;
                }
            }
            if(j == k + 1) {
                int curr = Math.max(days[i], days[i + k + 1]) + 1;
                result = result == -1 ? curr : Math.min(result, curr);
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] flowers = {3,9,2,8,1,6,10,5,4,7};
        int k = 1;
        System.out.println(kEmptySlots(flowers, k));

    }
}
