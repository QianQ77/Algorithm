package main.java.leetCode;

/**
 * Created by qiuqian on 8/29/18.
 */
public class CountPrimes {

    public static int countPrimes(int n) {
        int count = 0;
        boolean[] notPrime = new boolean[n];
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(!notPrime[i]) {
                if(!isPrime(i)) {
                    for(int j = 1; i * j < n; j++) {
                        notPrime[i * j] = true;
                    }
                }
            }
        }
        for(int i = 2; i < n; i++) {
            if(!notPrime[i]) {
                count++;
            }
        }
        return count;
    }


    private static boolean isPrime(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
