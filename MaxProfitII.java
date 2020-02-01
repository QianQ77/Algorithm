package main.java.leetCode;

/**
 * Created by qiuqian on 9/13/17.
 */
public class MaxProfitII {

        public int maxProfit(int[] prices) {
            int prev = Integer.MAX_VALUE;
            int result = 0;
            int min = 0;
            for(int i = 0; i < prices.length; i++){
                int next = (i == prices.length - 1) ? Integer.MIN_VALUE : prices[i + 1];
                if(prices[i] < prev && prices[i] < next){
                    min = prices[i];
                }else if(prices[i] > prev && prices[i] > next){
                    result += prices[i] - min;
                }
            }
            return result;
        }

    public static void main(String[] args) {
        MaxProfitII test = new MaxProfitII();
        System.out.println(test.maxProfit(new int[]{7,6,5,8}));

    }

}
