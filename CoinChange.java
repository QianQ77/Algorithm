package main.java.leetCode;

import java.util.Arrays;

/**
 * Created by qiuqian on 9/15/18.
 */
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        if(coins == null || coins.length == 0) {
            return -1;
        }
        Arrays.sort(coins);
        return change(coins, coins.length - 1, amount);

    }

    private static int change(int[] coins, int end, int amount) {
        if(amount == 0) {
            return 0;
        }
        if(coins[0] > amount ) {
            return -1;
        }
        for(int i = end; i >= 0; i--) {
            if(coins[i] <= amount) {
                //error point: shoud check if change(coins, i - 1, amount % coins[i]) == -1;
                //return amount / coins[i] + change(coins, i - 1, amount % coins[i]);

                //error point: if choose the biggest coin which is less than amount, and remainChange(amount % biggestCoin) == -1, then we should try the less biggest coin, should not return -1;

                int remainChange = change(coins, i - 1, amount % coins[i]);
                if( remainChange == -1) {
                    return change(coins, i - 1, amount);
                }else {
                    return amount / coins[i] + remainChange;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{186,419,83,408};
        int amount = 6249;
        System.out.println(coinChange(coins, amount));
    }
}
